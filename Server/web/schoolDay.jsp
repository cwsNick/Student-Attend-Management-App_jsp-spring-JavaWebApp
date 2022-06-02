<%-- 
    Document   : course
    Created on : 2019/12/13, 上午 01:15:40
    Author     : wansichong
--%>
<%@page import="ict.bean.SchoolDayBean"%>
<%@page import="ict.bean.CourseBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="java.util.*" %>
<%@page  import="ict.db.Database" %>
<%!
    private ArrayList<SchoolDayBean> schoolDayBeans = null;
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Day Management</title>
        <link rel="stylesheet" href="index.css" />
    </head>

    <body>
        <h1 style="text-align: center;">
            School Day Management
        </h1>
        <hr>


        <div class="main">

            <div class="row">

                <div class="card WhiteCard centerCard">
                    <form method="get" action="?">
                        <table width="100%">
                            <tr>
                                <td colspan="2"><input type="text" name="SemName" maxlength="50" placeholder="Sem/School Days Name" required></td>
                            </tr>
                            <tr>
                                <td>
                                    Start Day:<input id="date" type="date" class="date" name="StartTime">
                                </td>
                                <td>
                                    End Day:<input id="date" type="date" class="date" name="StopTime">
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right" width="100%">
                                    <input type="reset" class="btnFunction cancelBtn">
                                </td>
                                <td>    
                                    <input type="submit" class="btnFunction btnAdd" value="Add Course">
                                </td>
                            <input type="hidden" name="delSchoolDayID" id="delSchoolDayID" value="">
                            <input type="hidden" name="SchoolDayID" id="SchoolDayID" value="">
                            </tr>
                        </table>
                    </form>
                </div>

                <%
                    String delSchoolDayID = request.getParameter("delSchoolDayID");

                    String SchoolDayID = request.getParameter("SchoolDayID");
                    String SemName = request.getParameter("SemName");
                    String StartTime = request.getParameter("StartTime");
                    String StopTime = request.getParameter("StopTime");

                    if (SchoolDayID == "") {
                        //add
                        DB.addSchoolDayRecord(SemName, StartTime, StopTime);
                    } else if (delSchoolDayID != "") {
                        //del
                        DB.delSchoolDay(delSchoolDayID);
                    } else {
                        //edit
                        DB.editSchoolDay(SchoolDayID, SemName, StartTime, StopTime);
                    }

                    this.schoolDayBeans = DB.querySchoolDay();
                %>

                <br>
                <%
                    for (SchoolDayBean SDBean : schoolDayBeans) {
                        out.print("<div class=\"card WhiteCard centerCard\">");
                        out.print("<table style=\"width: 100%;\">");
                        out.println("<form  method=\"get\" action=\"schoolDay.jsp\">");

                        //School Day ID
                        out.println("<tr><td  width=\"100%\" style=\"text-align: right\">");
                        out.println("School ID: </td><td><input type=\"text\" name=\"SchoolDayID\"  width=\"20px\" style=\"text-align: right;padding: 0px ;background-color: white;box-shadow: none;border:none\" readonly value=\"" + SDBean.getSchoolDayID() + "\">");
                        out.println("</td></tr>");

                        //Sem Name
                        out.println("<tr><td  colspan=\"2\">");
                        out.println("Sem Name :<tr><td>");
                        out.println("<tr><td  colspan=\"2\" ><input type=\"text\" name=\"SemName\" value=\""
                                + SDBean.getSemName() + "\">");
                        out.println("</td></tr>");
                        out.println("<tr><td>");

                        //Start
                        out.println("Start Day :");
                        out.println("<input id=\"date\" type=\"date\" name=\"StartTime\" value=\"" + SDBean.getStartTime() + "\"/>");
                        out.println("</td></tr><tr><td>");
                        out.println("End Day :");
                        out.println("<input id=\"date\" type=\"date\" name=\"StopTime\" value=\"" + SDBean.getStopTime()+ "\"/>");

                        out.println("</td></tr>");
                        out.println("<input type=\"hidden\" name=\"delSchoolDayID\" id=\"delSchoolDayID\" value=\"\">");

                        //delLocation //check del
                        out.println("<td style=\"text-align: right\">");
                        out.println("<input type=\"button\" class=\"btnFunction cancelBtn\" onclick=\"window.location.href = 'schoolDay.jsp?delSchoolDayID=" + SDBean.getSchoolDayID() + "';\" value=\"X\"/>");
                        out.println("</td><td>");
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
