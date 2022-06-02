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
        <title>Student</title>
        <style>
            a {
                color: black;
                padding: 8px 16px;
                text-decoration: none;
            }
            li a {
                display: block;
            }
            a.active {
                background-color: rgb(34, 151, 247);
                color: white;
            }
            a:hover:not(.active) {
                background-color: #cccccc;
                color: black;
            }
            body{
                background-color: #ecf0f1;
            }

            h1 {
                background-color: #b3f5fb;
                color: lightcoral;
                padding: 10px;
            }
            img{
                width: 50%
            }
            #menu {
                background-color: white;
                color: orange;
                padding: 10px;
            }
            .leftPart, .rightPart {
                border:2px white solid;
                float:left;
                width: 48%;
                height: 200px;
                margin-right:10px;
                margin-bottom:20px;
                background-color: white;
                box-shadow: 0 3px 6px 0 rgba(0, 0, 0, 0.2);
                transition: 0.3s;
                border-radius: 3px;
            }
            .leftPart:hover, .rightPart:hover {
                border-color: rgb(34, 151, 247);
                border-style: solid;
                box-shadow: 0 2px rgb(26, 143, 240);
                transition: 0.2s;
            }
            ul {
                list-style-type: none;
            }
            input[type=submit]{
                background: #4B99AD;
                padding: 15px 30px 15px 30px;
                border: none;
                color: #fff;
            }
            input[type=submit]:hover{
                background: #4691A4;
                box-shadow:none;
                -moz-box-shadow:none;
                -webkit-box-shadow:none;
            }

            #customers {
                background-color: white;
            }

            #customers {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr:nth-child(even){background-color: #f2f2f2;}

            #customers tr:hover {background-color: #ddd;}

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #2980b9;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="leftcolumn">

                <table width="100%">
                    <tr>
                        <td>
                            Moodle - Student
                            <jsp:useBean id="LoginBean" class="ict.bean.LoginBean"  scope="session" />
                            <b>
                                <jsp:getProperty name="LoginBean" property="type" />
                                <% out.println("<br>Name :" + LoginBean.getName()); %>
                                <% out.println("<br>Department ID:" + LoginBean.getDepartmentID());%>
                                <% out.println("<br>User ID :" + LoginBean.getUserID());%>
                                <%
                                    this.attendanceBeans = DB.queryStudentAttendance(LoginBean.getUserID());
                                %>
                            </b>
                        </td>
                        <td style="text-align: right;">
                            <form method="POST" action="LoginController">
                                <input type="hidden" name="action" value="logout">
                                <input type="submit" name="Logout" value="Logout" />
                            </form>
                        </td>
                    </tr>
                </table>


                <table  id="customers">
                    <tr>
                        <th>
                            Date
                        </th>
                        <th>
                            Class ID
                        </th>
                        <th>
                            Class Name
                        </th>
                        <th>
                            Attendance
                        </th>
                    </tr>
                    <%
                        for (AttendanceBean attendanceBean : attendanceBeans) {
                            out.println("<tr>");
                            out.println("<td>");
                            out.println(attendanceBean.getSchoolDay());
                            out.println("</td>");
                            out.println("<td>");
                            out.println(attendanceBean.getClassID());
                            out.println("</td>");
                            out.println("<td>");
                            out.println(DB.queryClass(attendanceBean.getClassID()));
                            out.println("</td>");
                            out.println("<td>");
                            out.println(DB.converterAttendance(attendanceBean.getAttendance()));
                            out.println("</td>");
                            out.println("</tr>");
                        }
                    %>
                </table>

                <form action="ExportExcel/ExportExcelByStudent.jsp">
                    <input type="submit" value="Export Attendance To Excel">
                </form>
            </div>
        </div>
    </body>
</html>