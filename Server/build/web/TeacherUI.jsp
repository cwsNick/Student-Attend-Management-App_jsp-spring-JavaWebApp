<%-- 
    Document   : TeacherUI
    Created on : 2019/11/18, 下午 04:48:38
    Author     : kem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher</title>
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
        </style>
    </head>
    <body>
        <div class="row">
            <div class="leftcolumn">
                <h1>
                    <table width="100%">
                        <tr>
                            <td>
                                Moodle - Teacher
                                <jsp:useBean id="LoginBean" class="ict.bean.LoginBean"  scope="session" />
                                <b>
                                    <jsp:getProperty name="LoginBean" property="accountID" />
                                    <% out.println("<br>Department ID:" + LoginBean.getDepartmentID());%>
                                    <% out.println("<br>User ID :" + LoginBean.getUserID());%>
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
                </h1>
                <div class="leftPart">
                    <div>
                        <center><h2>Attendance</h2></center>
                        <ul>
                            <li>
                                <a href="attendanceViewerEachClass.jsp" target="_blank">
                                    Edit Attendance
                                </a>
                            </li>
                            <li>
                                <a href="event.jsp" target="_blank">
                                    Class Schedule
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="rightPart">
                    <div>
                        <center><h2>Report</h2></center>
                        <ul>
                            <li>
                                <a href="report.jsp" target="_blank">
                                    Attendance Report And Export To Excel
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>