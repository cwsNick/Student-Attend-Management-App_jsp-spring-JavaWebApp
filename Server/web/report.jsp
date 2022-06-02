<%-- 
    Document   : classStudentTeacherManagement.jsp
    Created on : 2019/12/13, 下午 07:45:22
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
    private ArrayList<AttendanceBean> attendanceBeans = null;
    private ArrayList<ClassTeacherBean> classTeacherBeans = null;
    private ArrayList<TeacherBean> teacherBeans = null;

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
        <h1 style="text-align: center;">
            Report And Export To Excel Function
        </h1>

        <hr>
        <div class="main">

            <div class="row">

                <table class="centerCard">
                    <tr>
                        <td  style="vertical-align:text-top;">
                            <h2 style="text-align: center;">Class Attendance</h2>
                            
                            <hr>
                            <p style="text-align: center;">
                            <button onclick="window.location.href = 'ExportExcel/attendanceEachClass.jsp';">Export All Class Basic Attendance To Excel</button>
                            </p>
                            <%                                
                                this.classBeans = DB.queryClass();
                                for (ClassBean cBeans : classBeans) {
                                    String classID = cBeans.getClassID();
                                    out.print("<div class=\"card WhiteCard centerCard\">");
                                    out.print("<table style=\"width: 100%;\">");

                                    out.println("<tr><td  colspan=\"3\">");
                                    out.println("<h1>Class Name : " + cBeans.getClassName() + "<h1><tr><td colspan=\"2\">");
                                    out.println("<hr>");
                                    this.attendanceBeans = DB.queryAttendanceSchoolDay(cBeans.getClassID());
                                    for (AttendanceBean attendanceBean : attendanceBeans) {

                                        String date = attendanceBean.getSchoolDay();

                                        if (date == null | classID == null) {
                                            out.print("<h2>Not Any Record!</h2>");
                                            break;
                                        }

                                        String attendPercentage = DB.queryAttendanceStudentPercentage(date, classID);
                                        String AbsencePercentage = DB.queryAbsenceStudentPercentage(date, classID);

                                        String numOfStudent = DB.queryAttendanceStudentNumber(date, classID);
                                        String numOfAttendStudent = DB.queryAttendanceStudentYesNumber(date, classID);
                                        String numOfAbsenceStudent = DB.queryAttendanceStudentNoNumber(date, classID);

                                        //ClassID
                                        out.println("<form  method=\"get\" action=\"ExportExcel/classAttendance.jsp\">");
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
                                        out.println("<input type=\"submit\" class=\"btnFunction btnUpdata\" value=\"Export To Excel\">");
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
                        </td>
                        <td  style="vertical-align:text-top;">
                            <h2 style="text-align: center;">All Student</h2>
                            <p style="text-align: center;">
                            <hr>
                            <div class="card WhiteCard">
                                <%
                                    this.studentBeans = DB.queryStudent();
                                    for (StudentBean studentBean : studentBeans) {

                                        String StudentID = studentBean.getStudentID();
                                        out.println("<form  method=\"get\" action=\"ExportExcel/ExportExcelByStudent.jsp\">");
                                        out.println("<table width=\"100%\">");
                                        out.println("<tr>");
                                        out.println("<td>");
                                        out.println("<h4>Teacher Name: </h3>" + studentBean.getName());
                                        out.println("<h4>Department Name: </h3>" + DB.queryDepartment(studentBean.getDepartmentID()));

                                        out.println("</td>");

                                        out.println("<td style=\"text-align: right\">");
                                        out.println("<input type=\"hidden\" name=\"StudentID\" value=\"" + StudentID + "\">");

                                        out.println("<input type=\"submit\" class=\"btnFunction btnUpdata\" value=\"Export To Excel\">");
                                        out.println("</td>");
                                        out.println("</tr>");
                                        out.println("</table>");
                                        out.println("</form>");
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
