<%-- 
    Document   : attenanceViewerEachClass
    Created on : 2019/12/14, 上午 09:38:43
    Author     : wansichong
--%>

<%@page import="ict.bean.AttendanceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.ClassBean"%>
<%@page import="ict.db.Database"%>
<%!
    private ArrayList<ClassBean> classBeans = null;
    private ArrayList<AttendanceBean> attendanceBeans = null;
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class Management</title>
        <link rel="stylesheet" href="index.css" />
        <script>
            document.getElementById('TodayDate').value = new Date().toDateInputValue();
        </script>
    </head>
    <body>
        <h1 style="text-align: center;">
            Attendance Report/Management
        </h1>
        <form action="attendanceViewerEachAttendanceRate.jsp">
            <input type="hidden" name="ClassID" value="60" classID/>
            <input type="submit" value="View All">
        </form>
        <br>
        <br>
        <br>
        <hr>

        <%

            this.classBeans = DB.queryClass();

            for (ClassBean cBeans : classBeans) {
                String classID = cBeans.getClassID();
                out.print("<div class=\"card WhiteCard centerCard\">");
                out.print("<table style=\"width: 100%;\">");
                out.println("<form  method=\"get\" action=\"editAttendance.jsp\">");

                //ClassID
                out.println("<input type=\"hidden\" name=\"ClassID\" value=\"" + classID + "\">");

                //ClassName
                out.println("<tr><td  colspan=\"3\">");
                out.println("Class Name : " + cBeans.getClassName() + "<tr><td colspan=\"2\">");
                out.println("<input type=\"date\" name=\"SchoolDay\" id=\"TodayDate\" value=\"Add Attendance\">");
                out.println("<input type=\"submit\" class=\"btnFunction btnUpdata\" value=\"Add Attendance\">");
                out.println("</form>");

                this.attendanceBeans = DB.queryAttendanceSchoolDay(cBeans.getClassID());
                for (AttendanceBean attendanceBean : attendanceBeans) {

                    String date = attendanceBean.getSchoolDay();

                    if (date == null | classID == null) {
                        out.print("<h2>Not Any Record!</h2>");
                        break;
                    }
                    
                    if(DB.queryAttendanceStudentPercentageNum(date, classID)>60){
                        continue;
                    }

                    String attendPercentage = DB.queryAttendanceStudentPercentage(date, classID);
                    String AbsencePercentage = DB.queryAbsenceStudentPercentage(date, classID);

                    String numOfStudent = DB.queryAttendanceStudentNumber(date, classID);
                    String numOfAttendStudent = DB.queryAttendanceStudentYesNumber(date, classID);
                    String numOfAbsenceStudent = DB.queryAttendanceStudentNoNumber(date, classID);

                    //ClassID
                    out.println("<form  method=\"get\" action=\"editAttendance.jsp\">");
                    out.println("<input type=\"hidden\" name=\"ClassID\" value=\"" + classID + "\">");

                    //SchoolDay
                    out.println("<input type=\"hidden\" name=\"SchoolDay\" value=\"" + date + "\">");

                    out.println("<table style=\"width: 100%;\">");
                    out.println("<tr>");
                    out.println("<td colspan=\"2\">");
                    out.println("Date : " + date);
                    out.println("</tr>");
                    out.println("</td>");

                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<h2>Attendance Rate</h2>");
                    out.println("</td>");
                    out.println("<td style=\"text-align: right;\">");
                    out.println("Number of students : " + numOfStudent);
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<h3>Attend " + attendPercentage + "</h3>(Number of attend students : " + numOfAttendStudent + ")");
                    out.println("</td>");
                    out.println("<td style=\"text-align: right;\">");
                    out.println("<h3>Absence " + AbsencePercentage + "</h3>(Number of absence students : " + numOfAbsenceStudent + ")");
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</table>");

                    out.println("<table style=\"width: 100%;\">");
                    out.println("<tr style=\"height: 16px;\">");
                    out.println("<td style=\"background-color: #2ecc71;width: " + attendPercentage + ";\"></td>");
                    out.println("<td style=\"background-color: #e74c3c;width: " + AbsencePercentage + ";\"></td>");
                    out.println("</tr>");
                    out.println("</table>");

                    out.println("<table style=\"width: 100%;\">");

                    out.println("<tr>");
                    out.println("<tr>");
                    out.println("<tr>");

                    out.println("<td style=\"text-align: left\">");
                    out.println("<input type=\"submit\" class=\"btnFunction btnUpdata\" value=\"Edit Data\">");
                    out.println("</td>");

                    out.println("</tr>");

                    out.println("</table>");

                    out.println("<br>");
                    out.println("<hr>");

                    out.println("</form>");

                }
                out.println("</td>");

                out.println("</tr></td></tr>");

                out.println("</table>");
                out.println("</div><br>");

            }
        %>
    </body>
</html>
