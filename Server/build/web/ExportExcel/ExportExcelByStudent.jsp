<%-- 
    Document   : ExportExcelByStudent
    Created on : 2019/12/14, 上午 10:19:22
    Author     : wansichong
--%>
<%@page import="ict.bean.AttendanceBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.db.Database"%>

<%!
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Attendance Report</h1>
        <table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
            <tr>
                <td>Date</td>
                <td>Class ID</td>
                <td>Class Name</td>
                <td>Attendance</td>
            </tr>
            <jsp:useBean id="LoginBean" class="ict.bean.LoginBean"  scope="session" />
            <jsp:getProperty name="LoginBean" property="type" />

            <%
                String StudentID = "";

                if (request.getParameter("StudentID") != null) {
                    StudentID = request.getParameter("StudentID");
                } else {
                    StudentID = LoginBean.getUserID();//Key
                }

                this.attendanceBeans = DB.queryStudentAttendance(StudentID);
                if (attendanceBeans != null) {
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "inline; filename=" + "studentAttendance.xls");
                }
                for (AttendanceBean attendanceBean : attendanceBeans) {
            %>
            <tr>
                <td><%=attendanceBean.getSchoolDay()%></td>
                <td><%=attendanceBean.getClassID()%></td>
                <td><%=DB.queryClass(attendanceBean.getClassID())%></td>
                <td><%=DB.converterAttendance(attendanceBean.getAttendance())%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
