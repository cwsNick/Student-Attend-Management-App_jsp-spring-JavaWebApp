<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="java.util.*" %>
<%@page  import="ict.bean.AccountBean" %>
<%@page  import="ict.bean.RoleBean" %>
<%@page  import="ict.bean.DepartmentBean"%>
<%@page  import="ict.db.Database" %>
<%!
    private ArrayList<AccountBean> accounts = null;
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);

    private ArrayList<RoleBean> roles = null;
    private ArrayList<DepartmentBean> DepartmentBean = null;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Management</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/123941/rwd.table.min.css'>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="input.css" />
    </head>

    <body>
        <h2>Account Management</h2>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive" data-pattern="priority-columns">
                        <table class="table table-bordered table-hover">
                            <caption class="text-center">
                                <form method="get" action="?">
                                    <div id="css_table">
                                        <div class="css_tr">
                                            <div class="css_td"><input type="text" name="loginID" maxlength="20" placeholder="Login ID" required></div>
                                            <div class="css_td"><input type="text" name="password" maxlength="20" placeholder="Password" required></div>
                                            <div class="css_td">
                                                <div class="custom-select">
                                                    <select name="type">
                                                        <option value="">Select Role:</option>
                                                        <%
                                                            this.roles = DB.queryRole();
                                                            for (RoleBean rb : roles) {
                                                                if (!rb.getRole().equals("")) {
                                                                    out.println("<option value=\"" + rb.getRole() + "\">" + rb.getRole() + "</option>");
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="css_td">
                                                <div class="custom-select">
                                                    <select name="departmentOrYears">
                                                        <option value="">Select Department</option>
                                                        <%
                                                            this.DepartmentBean = DB.queryDepartment();
                                                            for (DepartmentBean departmentBean : DepartmentBean) {
                                                                if (!departmentBean.getDepartmentID().equals("")) {
                                                                    out.println("<option value=\"" + departmentBean.getDepartmentID() + "\">" + departmentBean.getDepartmentName() + "</option>");
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="css_td"><input type="text" name="name" maxlength="20" placeholder="Name" required></div>
                                            <div class="css_td"><input type="submit" value="Add Account"></div>
                                        </div>
                                    </div>
                                    <input type="hidden" name="DaccountID" id="DaccountID" value="">
                                    <input type="hidden" name="DuserID" id="DuserID" value="">
                                </form>
                                <jsp:useBean id="account" class="ict.bean.AccountBean"  scope="request" />
                                <jsp:setProperty name="account" property="*" />
                            </caption>
                            <thead>
                                <tr>
                                    <th>LoginID</th>
                                    <th data-priority="1">password</th>
                                    <th data-priority="2">Type</th>
                                    <th data-priority="3">Department</th>
                                    <th data-priority="4">Name</th>
                                    <th data-priority="5">Delete</th>
                                    <th data-priority="6">Edit</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    String DaccountID = request.getParameter("DaccountID");
                                    String DuserID = request.getParameter("DuserID");
                                    DB.delAccountRecord(DaccountID, DuserID);

                                    this.DB.addAccount(account);

                                    this.accounts = DB.queryAccount();

                                    for (AccountBean ab : accounts) {
                                        out.println("");

                                        out.println("<tr class=\"text-center\">"
                                                + "<form method=\"get\" action=\"AccountManagement2.jsp\">"
                                                + "<td><input type=\"text\" name=\"loginID\" value=\"" + ab.getLoginID() + "\"></td>"
                                                + "<input type=\"text\" name=\"accountID\" style=\"display:none\" readonly value=\"" + ab.getAccountID() + "\">"
                                                + "<input type=\"text\" name=\"userID\" style=\"display:none\" readonly value=\"" + ab.getUserID() + "\">"
                                                + "<td><input type=\"text\" name=\"password\" maxlength=\"20\" required value=\"" + ab.getPassword() + "\"></td>"
                                        );

                                        //              Type
                                        out.println("<td>");
                                        out.println("<div class=\"custom-select\">");
                                        out.println("<select name=\"type\">");

                                        out.println("<option value=\"" + ab.getType() + "\">" + ab.getType() + "</option>");
                                        this.roles = DB.queryRole();
                                        for (RoleBean rb : roles) {
                                            if (!rb.getRole().equals("")) {
                                                out.println("<option value=\"" + rb.getRole() + "\">" + rb.getRole() + "</option>");
                                            }
                                        }

                                        out.println("</select>");
                                        out.println("</div>");
                                        out.println("</td>");

                                        //              Department
                                        out.println("<td>");
                                        out.println("<div class=\"custom-select\">");
                                        out.println("<select name=\"departmentOrYears\">");

                                        out.println("<option value=\"" + ab.getType() + "\">" + DB.queryDepartment(ab.getDepartmentOrYears()) + "</option>");
                                        this.DepartmentBean = DB.queryDepartment();
                                        for (DepartmentBean departmentBean : DepartmentBean) {
                                            if (!departmentBean.getDepartmentID().equals("")) {
                                                out.println("<option value=\"" + departmentBean.getDepartmentID() + "\">" + departmentBean.getDepartmentName() + "</option>");
                                            }
                                        }

                                        out.println("</select>");
                                        out.println("</div>");
                                        out.println("</td>");

                                        out.println(""
                                                + "<td><input type=\"text\" name=\"name\" maxlength=\"20\" placeholder=\"Name\" required value=\"" + ab.getName() + "\"></td>"
                                                + "<td><button class=\"btnFunction btnDelete\"><a href=AccountManagement.jsp?accountID=&password=&type=&departmentOrYears=&name=&DaccountID=" + ab.getAccountID() + "&DuserID=" + ab.getUserID() + ">&nbsp;X&nbsp;</a></button></td>"
                                                + "<td><input type=\"submit\" class=\"btnFunction btnUpdata\" value=\"Edit Data\"></td>"
                                                + "</form>"
                                                + "</tr>"
                                        );
                                    }
                                %>

                            </tbody>
                            <tfoot>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.2/js/bootstrap.min.js'></script>
        <script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/123941/rwd-table-patterns.js'></script>
    </body>
</html>
