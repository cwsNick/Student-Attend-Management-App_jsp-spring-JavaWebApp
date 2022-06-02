<%-- 
    Document   : classAttendance
    Created on : 2019/12/14, 下午 07:12:51
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
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String ClassID = request.getParameter("ClassID");//Key
            String SchoolDay = request.getParameter("SchoolDay");

            this.attendanceBeans = DB.queryAttendance(SchoolDay, ClassID);
            if (attendanceBeans != null) {
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "inline; filename=" + "classAttendance.xls");
            }
        %>
        <h1><% out.print(DB.queryClass(ClassID) + "  " + SchoolDay); %> Attendance Report</h1>
        <table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
            <tr>
                <td>Student Name</td>
                <td>Attendance</td>
            </tr>
            <%
                for (AttendanceBean attendanceBean : attendanceBeans) {
            %>
            <tr>
                <td><%=DB.queryStudentName(attendanceBean.getStudentID())%></td>
                <td><%=DB.converterAttendance(attendanceBean.getAttendance())%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>