<%-- 
    Document   : classManagement
    Created on : 2019/12/12, 下午 08:38:24
    Author     : wansichong
--%>
<%@page import="ict.bean.DepartmentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.ClassBean"%>
<%@page import="ict.db.Database"%>
<%!
    private ArrayList<DepartmentBean> DepartmentBean = null;
    private ArrayList<ClassBean> classBeans = null;
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
        <title>Class Management</title>
        <link rel="stylesheet" href="index.css" />
    </head>
    <body>
        <h1 style="text-align: center;">
            Class Management
        </h1>
        <hr>


        <div class="main">

            <div class="row">

                <div class="card WhiteCard centerCard">
                    <form method="get" action="?">
                        <table width="100%">
                            <tr>
                                <td colspan="2"><input type="text" name="ClassName" maxlength="10" placeholder="Class Name" required></td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="custom-select">
                                        <select name="DepartmentID">
                                            <option value="">Select Department</option>
                                            <%
                                                this.DepartmentBean = DB.queryDepartment();
                                                for (DepartmentBean departmentBean : DepartmentBean) {
                                                    if (!departmentBean.getDepartmentID().equals("")) {
                                                        out.println("<option value=\"" + departmentBean.getDepartmentID() + "\">" + departmentBean.getDepartmentName() + "</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <div class="custom-select">
                                        <select name="Years">
                                            <option value="">Select Years</option>
                                            <option value="1">Years 1</option>
                                            <option value="2">Years 2</option>
                                            <option value="3">Years 3</option>
                                            <option value="4">Years 4</option>
                                            <option value="3">Years 5</option>
                                            <option value="4">Years 6</option>                                        
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2"><textarea name="Detailed" rows="5" cols="50" placeholder="Class Detailed"></textarea></td>
                            </tr>

                            <tr>
                                <td style="text-align: right" width="100%">
                                    <input type="reset" class="btnFunction cancelBtn">
                                </td>
                                <td>    
                                    <input type="submit" class="btnFunction btnAdd" value="Add Class">
                                    <input type="hidden" name="delClassID" id="delClassID" value="">
                                    <input type="hidden" name="ClassID" id="ClassID" value="">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>

                <%
                    String delClassID = request.getParameter("delClassID");

                    String ClassID = request.getParameter("ClassID");//Key

                    String ClassName = request.getParameter("ClassName");
                    String DepartmentID = request.getParameter("DepartmentID");//REFERENCES DEPARTMENT(DepartmentID)
                    String Years = request.getParameter("Years");
                    String Detailed = request.getParameter("Detailed");
//ok
                    if (ClassID == "") {
                        //add
                        DB.addClassRecord(ClassName, DepartmentID, Years, Detailed);
                    } else if (delClassID != "") {
                        //del
                        DB.delClassRecord(delClassID);
                    } else {
                        //edit
                        DB.editClassRecord(ClassID, ClassName, DepartmentID, Years, Detailed);
                    }
                    this.classBeans = DB.queryClass();
                %>

                <br>
                <%
                    for (ClassBean cBeans : classBeans) {
                        out.print("<div class=\"card WhiteCard centerCard\">");
                        out.print("<table style=\"width: 100%;\">");
                        out.println("<form  method=\"get\" action=\"classManagement.jsp\">");

                        //ClassID
                        out.println("<tr><td  width=\"100%\" style=\"text-align: right\">");
                        out.println("Class ID: </td><td><input type=\"text\" name=\"ClassID\"  width=\"20px\" style=\"text-align: right;padding: 0px ;background-color: white;box-shadow: none;border:none\" readonly value=\"" + cBeans.getClassID() + "\">");
                        out.println("</td></tr>");

                        //ClassName
                        out.println("<tr><td  colspan=\"3\">");
                        out.println("Class Name :<tr><td>");
                        out.println("<tr><td  colspan=\"3\" ><input type=\"text\" name=\"ClassName\"  maxlength=\"10\"  value=\""
                                + cBeans.getClassName() + "\">");
                        out.println("</td></tr>");

                        //DepartmentID
                        out.println("<tr><td>");
                        out.println("<div class=\"custom-select\">");
                        out.println("<select name=\"DepartmentID\">");

                        out.println("<option value=\"" + cBeans.getDepartmentID() + "\">" + DB.queryDepartment(cBeans.getDepartmentID()) + "</option>");
                        this.DepartmentBean = DB.queryDepartment();
                        for (DepartmentBean departmentBean : DepartmentBean) {
                            if (!departmentBean.getDepartmentID().equals("")) {
                                out.println("<option value=\"" + departmentBean.getDepartmentID() + "\">" + departmentBean.getDepartmentName() + "</option>");
                            }
                        }

                        out.println("</select>");
                        out.println("</div>");
                        out.println("</td>");

                        //Years
                        out.println("<td colspan=\"2\">");
                        out.println("<div class=\"custom-select\">");
                        out.println("<select name=\"Years\">");
                        out.println("<option value=\"" + cBeans.getYears() + "\">Years " + cBeans.getYears() + "</option>");
                        out.println("<option value=\"1\">Years 1</option>");
                        out.println("<option value=\"2\">Years 2</option>");
                        out.println("<option value=\"3\">Years 3</option>");
                        out.println("<option value=\"4\">Years 4</option>");
                        out.println("<option value=\"3\">Years 5</option>");
                        out.println("<option value=\"4\">Years 6</option>");
                        out.println("</select>");
                        out.println("</div>");
                        out.println("</td>");

                        //Detailed
                        out.println("<tr><td colspan=\"3\" >");
                        out.println("Class Detailed :<br>");
                        out.println("<textarea name=\"Detailed\" rows=\"5\" cols=\"50\">"
                                + cBeans.getDetailed() + "</textarea>");

                        out.println("</td></tr>");
                        out.println("<input type=\"hidden\" name=\"delClassID\" id=\"delClassID\" value=\"\">");
                        out.println("<td style=\"text-align: right\">"
                                + "<input type=\"button\" class=\"btnFunction cancelBtn\" onclick=\"window.location.href = 'classManagement.jsp?delClassID=" + cBeans.getClassID() + "';\" value=\"X\"/>"
                                + "</td><td>");
                        out.println("<input type=\"submit\" class=\"btnFunction btnUpdata\" value=\"Edit Data\"></td>");

                        out.println("</form>");
                        out.println("</table>");
                        out.println("</div><br>");

                        out.print("<table style=\"width: 100%;\" >");
                        out.print("<tr>");
                        out.print("<td align=\"center\">");

                        out.println("<button class=\"btnFunction btnUpdata\"  onclick=\"window.location.href = 'classStudentTeacherManagement.jsp?ClassID=" + cBeans.getClassID() + "';\">Set Class Student and Teacher</button>");
                        out.print("</td>");
                        out.print("</tr>");

                        out.print("</table>");

                    }
                %>
            </div>
        </div>

    </body>
</html>
