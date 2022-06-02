<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IT Administrator</title>
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="row">
            <div class="leftcolumn">

                <table width="100%">
                    <tr>
                        <td>
                            <h1>Moodle - IT Administrator</h1>
                        </td>
                        <td style="text-align: right;">
                            <form method="POST" action="LoginController">
                                <input type="hidden" name="action" value="logout">
                                <input type="submit" name="Logout" value="Logout" />
                            </form>
                        </td>
                    </tr>
                </table>

                <div class="leftPart">
                    <div>
                        <center><h2>Data Management</h2></center>
                        <ul>
                            <li>
                                <a href="classManagement.jsp" target="_blank">
                                    Class Management
                                </a>
                            </li>
                            <li>
                                <a href="course.jsp" target="_blank">
                                    Course Management
                                </a>
                            </li>
                            <li>
                                <a href="departmentData.jsp" target="_blank">
                                    Department Data Management
                                </a>
                            </li>
                            <li>
                                <a href="schoolDay.jsp" target="_blank">
                                    School Day By Sem
                                </a>
                            </li>
                            <li>
                                <a href="location.jsp" target="_blank">
                                    Location Management
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="rightPart">
                    <div>
                        <center><h2>Class Management</h2></center>
                        <ul>
                            <li>
                                <a href="AccountManagementFunction/AccountManagement.jsp" target="_blank">
                                    Account Management
                                </a>
                            </li>
                            <li>
                                <a href="AccountManagementFunction/RoleManagement.jsp" target="_blank">
                                    Role Management
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="leftcolumn">
                <div class="leftPart">
                    <div>
                        <center><h2>Attendance</h2></center>
                        <ul>
                            <li>
                                <a href="attendanceViewerEachClass.jsp" target="_blank">
                                    Attendance
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