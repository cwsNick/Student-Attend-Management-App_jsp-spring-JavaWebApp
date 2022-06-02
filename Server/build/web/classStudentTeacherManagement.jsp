<%-- 
    Document   : classStudentTeacherManagement.jsp
    Created on : 2019/12/13, 下午 07:45:22
    Author     : wansichong
--%>
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
            <%
                String ClassID = request.getParameter("ClassID");//Key
                out.print("Class : " + DB.queryClass(ClassID) + "  Management");
            %>
        </h1>

        <hr>
        <%
            String delTeacherID = request.getParameter("delTeacherID");
            if (delTeacherID != null) {
                DB.delClassTeacher(delTeacherID);
            }
            String delStudentID = request.getParameter("delStudentID");
            if (delStudentID != null) {
                DB.delStudentClassRecord(delStudentID);
            }

            String addTeacherID = request.getParameter("addTeacherID");
            if (addTeacherID != null) {
                DB.addClassTeacher(addTeacherID, ClassID);
            }
            String addStudentID = request.getParameter("addStudentID");
            if (addStudentID != null) {
                DB.addStudentClassRecord(addStudentID, ClassID);
            }

        %>

        <div class="main">

            <div class="row">

                <table class="centerCard" style="height: 500px">
                    <tr>
                        <td  style="vertical-align:text-top;">
                            <div class="card GreenCard" style="height: 500px;overflow: scroll">
                                <h2 style="text-align: center;">Class Student</h2>
                                <hr>
                                <%                        
                                    this.studentClassBeans = DB.queryStudentClass(ClassID);
                                    for (StudentClassBean studentClassBean : studentClassBeans) {

                                        String StudentID = studentClassBean.getStudentID();
                                        out.println("<table width=\"100%\">");
                                        out.println("<tr>");
                                        out.println("<td>");
                                        out.println("<h4>Student Name: </h3>" + DB.queryStudentName(StudentID));
                                        out.println("</td>");

                                        out.println("<td style=\"text-align: right\">");
                                        out.println("<button class=\"btnFunction cancelBtn\"  onclick=\"window.location.href = 'classStudentTeacherManagement.jsp?ClassID=" + ClassID + "&delStudentID=" + StudentID + "';\">&nbsp;X&nbsp;</button>");
                                        out.println("</td>");
                                        out.println("</tr>");
                                        out.println("</table>");
                                    }
                                %>
                            </div>
                        </td>
                        <td>
                            <div class="card WhiteCard" style="height: 500px;overflow: scroll">
                                <h2 style="text-align: center;">All Student</h2>
                                <hr>
                                <%
                                    this.studentBeans = DB.queryStudent();
                                    for (StudentBean studentBean : studentBeans) {

                                        String StudentID = studentBean.getStudentID();

                                        out.println("<table width=\"100%\">");
                                        out.println("<tr>");
                                        out.println("<td>");
                                        out.println("<h4>Teacher Name: </h3>" + studentBean.getName());
                                        out.println("<h4>Department Name: </h3>" + DB.queryDepartment(studentBean.getDepartmentID()));

                                        out.println("</td>");

                                        out.println("<td style=\"text-align: right\">");
                                        out.println("<button class=\"btnFunction cancelBtn\"  onclick=\"window.location.href = 'classStudentTeacherManagement.jsp?ClassID=" + ClassID + "&addStudentID=" + StudentID + "';\">Add to class</button>");
                                        out.println("</td>");
                                        out.println("</tr>");
                                        out.println("</table>");
                                    }
                                %>
                            </div>
                        </td>
                    </tr>
                </table>
                            
                            
                <hr>

                <table class="centerCard">
                    <tr>
                        <td style="vertical-align:text-top;">

                            <div class="card GreenCard centerCard" style="height: 500px;overflow: scroll">
                            <h2 style="text-align: center;">Class Teacher</h2>
                            <hr>
                                <%                        
                                    this.classTeacherBeans = DB.queryClassTeacher(ClassID);
                                    for (ClassTeacherBean classTeacherBean : classTeacherBeans) {

                                        String TeacherID = classTeacherBean.getTeacherID();
                                        out.println("<table width=\"100%\">");
                                        out.println("<tr>");
                                        out.println("<td>");
                                        out.println("<h4>Teacher Name: </h3>" + DB.queryTeacherName(TeacherID));
                                        out.println("</td>");

                                        out.println("<td style=\"text-align: right\">");
                                        out.println("<button class=\"btnFunction cancelBtn\"  onclick=\"window.location.href = 'classStudentTeacherManagement.jsp?ClassID=" + ClassID + "&delTeacherID=" + TeacherID + "';\">&nbsp;X&nbsp;</button>");
                                        out.println("</td>");
                                        out.println("</tr>");
                                        out.println("</table>");
                                    }
                                %>
                            </div>
                        </td>
                        <td>

                            <div class="card WhiteCard centerCard" style="height: 500px;overflow: scroll">
                            <h2 style="text-align: center;">All Teacher</h2>
                            <hr>
                                <%
                                    this.teacherBeans = DB.queryTeacher();
                                    for (TeacherBean teacherBean : teacherBeans) {

                                        String TeacherID = teacherBean.getTeacherID();

                                        out.println("<table width=\"100%\">");
                                        out.println("<tr>");
                                        out.println("<td>");
                                        out.println("<h4>Teacher Name: </h3>" + teacherBean.getName());
                                        out.println("<h4>Department Name: </h3>" + DB.queryDepartment(teacherBean.getDepartmentID()));

                                        out.println("</td>");

                                        out.println("<td style=\"text-align: right\">");
                                        out.println("<button class=\"btnFunction cancelBtn\"  onclick=\"window.location.href = 'classStudentTeacherManagement.jsp?ClassID=" + ClassID + "&addTeacherID=" + TeacherID + "';\">Add to class</button>");
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
