<%-- 
    Document   : RoleManagement
    Created on : 2019/11/19, 下午 08:20:54
    Author     : kem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="java.util.*" %>
<%@page  import="ict.bean.RoleBean" %>
<%@page  import="ict.db.Database" %>
<%!
    private ArrayList<RoleBean> roles = null;
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Role Management</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
        <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/123941/rwd.table.min.css'>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="input.css" />
    </head>

    <body>
        <h2>Role Management</h2>

        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive" data-pattern="priority-columns">
                        <table class="table table-bordered table-hover">
                            <caption class="text-center">
                                <form method="post" action="?">
                                    <input type="text" name="role" maxlength="20">
                                    <input type="submit" value="Add Role">
                                    <input type="hidden" name="roleType" id="roleType" value="">
                                </form>
                                <jsp:useBean id="role" class="ict.bean.RoleBean"  scope="request" />
                                <jsp:setProperty name="role" property="*" />
                            </caption>
                            <thead>
                                <tr>
                                    <th>Role</th>
                                    <th data-priority="1">Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    String roleType = request.getParameter("roleType");
                                    DB.delRoleRecord(roleType);

                                    this.DB.addRoleRecord(role);

                                    this.roles = DB.queryRole();
                                    for (RoleBean rb : roles) {
                                        if (!rb.getRole().equals("") && !rb.getRole().equals("Admin")) {
                                            out.println("<tr><td>" + rb.getRole() + "</td>"
                                                    + "<td><button><a href=RoleManagement.jsp?role=&roleType=" + rb.getRole() + ">Delete</a></button></td></tr>");
                                        }
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