<%-- 
    Document   : editAttenance
    Created on : 2019/12/13, 下午 10:23:18
    Author     : wansichong
--%>

<%@page import="ict.bean.AttendanceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.ClassBean"%>
<%@page import="ict.bean.StudentClassBean"%>
<%@page import="ict.bean.ClassTeacherBean"%>
<%@page import="ict.bean.TeacherBean"%>
<%@page import="ict.bean.StudentBean"%>
<%@page import="ict.db.Database"%>

<%!
    private ArrayList<ClassBean> classBeans = null;
    private ArrayList<ClassTeacherBean> classTeacherBeans = null;
    private ArrayList<AttendanceBean> absenceAttendanceBeans = null;
    private ArrayList<AttendanceBean> attendanceBeans = null;

    private ArrayList<StudentClassBean> studentClassBeans = null;
    private ArrayList<StudentBean> studentBeans = null;

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
        <title>Class Student and Teacher Page</title>
        <link rel="stylesheet" href="index.css" />
    </head>
    <body>
        <table border="0">
            <tr>
                <td width="900%">
                    <h1 style="text-align: center;">
                        <%
                            String ClassID = request.getParameter("ClassID");//Key
                            out.print("Class :" + ClassID + "Attenance Management");

                            String SchoolDay = request.getParameter("SchoolDay");
                            if (!DB.hasAttendance(SchoolDay, ClassID)) {
                                ArrayList<StudentClassBean> studentClassBeans = null;
                                studentClassBeans = DB.queryStudentClass(ClassID);

                                for (StudentClassBean studentClassBean : studentClassBeans) {
                                    DB.addAttendanceRecord(SchoolDay, ClassID, studentClassBean.getStudentID(), "0");
                                }
                            }
                        %>
                    </h1>
                </td>
                <td>
                    <button><a href="attendanceViewerEachClass.jsp">Back</a></button>
                </td>
            </tr>
        </table>

        <hr>
        <%
            String setAttendee = request.getParameter("setAttendee");
            if (setAttendee != null) {
                DB.setAttend(setAttendee);
            }
            String setAbsence = request.getParameter("setAbsence");
            if (setAbsence != null) {
                DB.setNoAttend(setAbsence);
            }
        %>

        <div class="main">

            <div class="row">

                <table class="centerCard">
                    <tr>
                        <td style="vertical-align:text-top;">
                            <h2 style="text-align: center;">Attendee Student</h2>
                            <div class="card WhiteCard centerCard">
                                <%
                                    this.attendanceBeans = DB.queryYesAttendance(SchoolDay, ClassID);
                                    for (AttendanceBean attendanceBean : attendanceBeans) {

                                        String StudentID = attendanceBean.getStudentID();

                                        //SchoolDay
                                        out.println("<input type=\"hidden\" name=\"setAbsence\" value=\"" + attendanceBean.getAttendanceID() + "\">");

                                        out.println("<table width=\"100%\">");
                                        out.println("<tr>");
                                        out.println("<td>");
                                        out.println("<h4>Student Name: </h3>" + DB.queryStudentName(attendanceBean.getStudentID()));

                                        out.println("</td>");

                                        out.println("<td style=\"text-align: right\">");
                                        out.println("<button class=\"btnFunction cancelBtn\"  onclick=\"window.location.href = 'editAttendance.jsp?setAbsence=" + attendanceBean.getAttendanceID() + "&ClassID=" + ClassID + "&SchoolDay=" + SchoolDay + "';\">&nbsp;X&nbsp;</button>");
                                        out.println("</td>");
                                        out.println("</tr>");
                                        out.println("</table>");
                                    }
                                %>
                            </div>
                        </td>
                        <td style="vertical-align:text-top;">
                            <h2 style="text-align: center;">Absence Student</h2>
                            <div class="card WhiteCard centerCard">
                                <%
                                    this.absenceAttendanceBeans = DB.queryNoAttendance(SchoolDay, ClassID);
                                    for (AttendanceBean attendanceBean : absenceAttendanceBeans) {

                                        String StudentID = attendanceBean.getStudentID();

                                        //SchoolDay
                                        out.println("<input type=\"hidden\" name=\"SchoolDay\" value=\"" + attendanceBean.getAttendanceID() + "\">");

                                        out.println("<table width=\"100%\">");
                                        out.println("<tr>");
                                        out.println("<td>");
                                        out.println("<h4>Student Name: </h3>" + DB.queryStudentName(StudentID));
                                        out.println("</td>");

                                        out.println("<td style=\"text-align: right\">");
                                        out.println("<button class=\"btnFunction cancelBtn\"  onclick=\"window.location.href = 'editAttendance.jsp?setAttendee=" + attendanceBean.getAttendanceID() + "&ClassID=" + ClassID + "&SchoolDay=" + SchoolDay + "';\">&nbsp;X&nbsp;</button>");
                                        out.println("</td>");
                                        out.println("</tr>");
                                        out.println("</table>");
                                    }
                                %>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>

        </div>

    </body>
</html>