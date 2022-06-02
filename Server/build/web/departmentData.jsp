<%@page import="ict.bean.DepartmentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="java.util.*" %>
<%@page  import="ict.db.Database" %>
<%!
    private ArrayList<DepartmentBean> departmentBeans = null;
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Management</title>
        <link rel="stylesheet" href="index.css" />
    </head>

    <body>
        <h1 style="text-align: center;">
            Department Management
        </h1>
        <hr>


        <div class="main">

            <div class="row">

                <div class="card WhiteCard centerCard">
                    <form method="get" action="?">
                        <table width="100%">
                            <tr>
                                <td colspan="2"><input type="text" name="DepartmentName" maxlength="50" placeholder="Department Name" required></td>
                            </tr>
                            <tr>
                                <td colspan="2"><textarea name="DepartmentDetailed" rows="5" cols="50" placeholder="Department Detailed"></textarea></td>
                            </tr>
                            <tr>
                                <td style="text-align: right" width="100%">
                                    <input type="reset" class="btnFunction cancelBtn">
                                </td>
                                <td>    
                                    <input type="submit" class="btnFunction btnAdd" value="Add Department">
                                    <input type="hidden" name="delDepartmentRecord" id="delDepartmentRecord" value="">
                                    <input type="hidden" name="DepartmentID" id="DepartmentID" value="">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>

                <%
                    String delDepartmentRecord = request.getParameter("delDepartmentRecord");
                    DB.delDepartmentRecord(delDepartmentRecord);

                    String DepartmentID = request.getParameter("DepartmentID");
                    String DepartmentName = request.getParameter("DepartmentName");
                    String DepartmentDetailed = request.getParameter("DepartmentDetailed");

                    if (DepartmentID == "" && DepartmentName != "" && DepartmentDetailed != "") {
                        this.DB.addDepartmentRecord(DepartmentName, DepartmentDetailed);
                    }

                    if (DepartmentID != "" && DepartmentName != "" && DepartmentDetailed != "") {
                        this.DB.editDepartmentRecord(DepartmentID, DepartmentName, DepartmentDetailed);
                    }

                    this.departmentBeans = DB.queryDepartment();
                %>

                <br>
                <%
                    for (DepartmentBean dBean : departmentBeans) {
                        out.print("<div class=\"card WhiteCard centerCard\">");
                        out.print("<table style=\"width: 100%;\">");
                        out.println("<form  method=\"get\" action=\"departmentData.jsp\">");

                        out.println("<tr><td  width=\"100%\" style=\"text-align: right\">");
                        out.println("Department ID: </td><td><input type=\"text\" name=\"DepartmentID\"  width=\"20px\" style=\"text-align: right;padding: 0px ;background-color: white;box-shadow: none;border:none\" readonly value=\"" + dBean.getDepartmentID() + "\">");
                        out.println("</td></tr>");

                        out.println("<tr><td  colspan=\"2\">");
                        out.println("Department Name :<tr><td>");
                        out.println("<tr><td  colspan=\"2\" ><input type=\"text\" name=\"DepartmentName\" value=\""
                                + dBean.getDepartmentName() + "\">");
                        out.println("</td></tr>");
                        out.println("<tr><td colspan=\"2\" >");

                        out.println("Department Detailed :<br>");
                        out.println("<textarea name=\"DepartmentDetailed\" rows=\"5\" cols=\"50\">"
                                + dBean.getDepartmentDetailed() + "</textarea>");

                        out.println("</td></tr>");

                        out.println("<td style=\"text-align: right\">"
                                + "<input type=\"button\" class=\"btnFunction cancelBtn\" onclick=\"window.location.href = 'departmentData.jsp?delDepartmentRecord=" + dBean.getDepartmentID() + "';\" value=\"X\"/>"
                                + "</td><td>");
                        out.println("<input type=\"submit\" class=\"btnFunction btnUpdata\" value=\"Edit Data\"></td>");

                        out.println("</form>");
                        out.println("</table>");
                        out.println("</div><br>");
                    }
                %>
            </div>
        </div>
    </body>
</html>
