<%-- 
    Document   : course
    Created on : 2019/12/13, 上午 01:15:40
    Author     : wansichong
--%>
<%@page import="ict.bean.CourseBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="java.util.*" %>
<%@page  import="ict.db.Database" %>
<%!
    private ArrayList<CourseBean> courseBeans = null;
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Management</title>
        <link rel="stylesheet" href="index.css" />
    </head>

    <body>
        <h1 style="text-align: center;">
            Course Management
        </h1>
        <hr>


        <div class="main">

            <div class="row">

                <div class="card WhiteCard centerCard">
                    <form method="get" action="?">
                        <table width="100%">
                            <tr>
                                <td colspan="2"><input type="text" name="CourseName" maxlength="50" placeholder="Course Name" required></td>
                            </tr>
                            <tr>
                                <td colspan="2"><textarea name="CourseDetailed" rows="5" cols="50" placeholder="Course Detailed"></textarea></td>
                            </tr>
                            <tr>
                                <td style="text-align: right" width="100%">
                                    <input type="reset" class="btnFunction cancelBtn">
                                </td>
                                <td>    
                                    <input type="submit" class="btnFunction btnAdd" value="Add Course">
                                    <input type="hidden" name="delCourse" id="delCourse" value="">
                                    <input type="hidden" name="CourseID" id="CourseID" value="">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>

                <%
                    String delCourse = request.getParameter("delCourse");
                    String CourseID = request.getParameter("CourseID");
                    String CourseName = request.getParameter("CourseName");
                    String CourseDetailed = request.getParameter("CourseDetailed");

                    if (CourseID == "") {
                        //add
                        DB.addCourse(CourseName, CourseDetailed);
                    } else if (delCourse != "") {
                        //del
                        DB.delCourse(delCourse);
                    } else {
                        //edit
                        DB.editCourse(CourseID, CourseName, CourseDetailed);
                    }

                    this.courseBeans = DB.queryCourse();
                %>

                <br>
                <%
                    for (CourseBean cBean : courseBeans) {
                        out.print("<div class=\"card WhiteCard centerCard\">");
                        out.print("<table style=\"width: 100%;\">");
                        out.println("<form  method=\"get\" action=\"course.jsp\">");

                        //LocationID
                        out.println("<tr><td  width=\"100%\" style=\"text-align: right\">");
                        out.println("Course ID: </td><td><input type=\"text\" name=\"CourseID\"  width=\"20px\" style=\"text-align: right;padding: 0px ;background-color: white;box-shadow: none;border:none\" readonly value=\"" + cBean.getCourseID() + "\">");
                        out.println("</td></tr>");

                        //LocationName
                        out.println("<tr><td  colspan=\"2\">");
                        out.println("Course Name :<tr><td>");
                        out.println("<tr><td  colspan=\"2\" ><input type=\"text\" name=\"CourseName\" value=\""
                                + cBean.getCourseName() + "\">");
                        out.println("</td></tr>");
                        out.println("<tr><td colspan=\"2\" >");

                        //Detailed
                        out.println("Course Detailed :<br>");
                        out.println("<textarea name=\"CourseDetailed\" rows=\"5\" cols=\"50\">"
                                + cBean.getCourseDetailed() + "</textarea>");

                        out.println("</td></tr>");
                        out.println("<input type=\"hidden\" name=\"delCourse\" id=\"delCourse\" value=\"\">");

                        //delLocation //check del
                        out.println("<td style=\"text-align: right\">");
                        out.println("<input type=\"button\" class=\"btnFunction cancelBtn\" onclick=\"window.location.href = 'course.jsp?delCourse=" + cBean.getCourseID() + "';\" value=\"X\"/>");
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
