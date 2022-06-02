<%-- 
    Document   : attendanceEachClass
    Created on : 2019/12/14, 下午 07:31:35
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Attendance Report</h1>
        <table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
            <tr>
                <td>Date</td>
                <td>Class ID</td>
                <td>Class Name</td>
                <td>Student Number</td>
                <td>Attendance Number</td>
                <td>Absence Number</td>
                <td>Attendance Rate</td>
                <td>Absence Rate</td>
            </tr>
            <%
                this.classBeans = DB.queryClass();

                if (classBeans != null) {
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "inline; filename=" + "studentAttendance.xls");
                }
                for (ClassBean cBeans : classBeans) {
                    if (cBeans.getClassID() == null) {
                        break;
                    }
                    this.attendanceBeans = DB.queryAttendanceSchoolDay(cBeans.getClassID());
                    for (AttendanceBean attendanceBean : attendanceBeans) {
                        String date = attendanceBean.getSchoolDay();

                        if (date == null) {
                            break;
                        }
            %>
            <tr>
                <td><%=attendanceBean.getSchoolDay()%></td>
                <td><%=cBeans.getClassID()%></td>
                <td><%=DB.queryClass(cBeans.getClassID())%></td>
                <td><%=DB.queryAttendanceStudentNumber(date, cBeans.getClassID())%></td>
                <td><%=DB.queryAttendanceStudentYesNumber(date, cBeans.getClassID())%></td>
                <td><%=DB.queryAttendanceStudentNoNumber(date, cBeans.getClassID())%></td>
                <td><%=DB.queryAttendanceStudentPercentage(date, cBeans.getClassID())%></td>
                <td><%=DB.queryAbsenceStudentPercentage(date, cBeans.getClassID())%></td>
            </tr>
            <%      }
                }
            %>
        </table>
    </body>
</html>
