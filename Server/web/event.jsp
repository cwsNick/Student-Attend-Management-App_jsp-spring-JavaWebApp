<%-- 
    Document   : event
    Created on : 2019/12/13, 上午 10:35:10
    Author     : wansichong
--%>
<%@page import="ict.bean.EventBean"%>
<%@page import="ict.bean.LocationBean"%>
<%@page import="ict.bean.TeacherBean"%>
<%@page import="ict.bean.CourseBean"%>
<%@page import="ict.bean.DepartmentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.ClassBean"%>
<%@page import="ict.db.Database"%>
<%@page import="ict.unti.converter" %>
<%!
    converter converter;
    private ArrayList<DepartmentBean> DepartmentBean = null;
    private ArrayList<CourseBean> courseBeans = null;
    private ArrayList<TeacherBean> teacherBeans = null;
    private ArrayList<LocationBean> locationBeans = null;
    private ArrayList<EventBean> eventBeans = null;
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
        <title>Event Management</title>
        <link rel="stylesheet" href="index.css" />
    </head>
    <body>
        <h1 style="text-align: center;">
            Event Management
        </h1>
        <hr>


        <div class="main">

            <div class="row">

                <div class="card WhiteCard centerCard">
                    <form method="get" action="?">
                        <table width="100%">
                            <tr>
                                <td colspan="2">
                                    Course:
                                    <div class="custom-select">
                                        <select name="CourseID">
                                            <option value="">Select Course</option>
                                            <%
                                                this.courseBeans = DB.queryCourse();
                                                for (CourseBean courseBean : courseBeans) {
                                                    if (!courseBean.getCourseID().equals("")) {
                                                        out.println("<option value=\"" + courseBean.getCourseID() + "\">" + courseBean.getCourseName() + "</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <br>
                                    Teachers-in-charge <br>
                                    <div class="custom-select">
                                        <select name="TeacherID">
                                            <option value="">Select Teacher</option>
                                            <%
                                                this.teacherBeans = DB.queryTeacher();
                                                for (TeacherBean teacherBean : teacherBeans) {
                                                    if (!teacherBean.getTeacherID().equals("")) {
                                                        out.println("<option value=\"" + teacherBean.getTeacherID() + "\">" + teacherBean.getName() + "</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <br>
                                    Class :
                                    <div class="custom-select">
                                        <select name="ClassID">
                                            <option value="">Select Class</option>
                                            <%
                                                this.classBeans = DB.queryClass();
                                                for (ClassBean classBean : classBeans) {
                                                    if (!classBean.getClassID().equals("")) {
                                                        out.println("<option value=\"" + classBean.getClassID() + "\">" + classBean.getClassName() + "</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <br>
                                    Date :
                                    <input type="date" id="eventdate" name="Date" placeholder="2014-09-18">
                                </td>
                            </tr>
                            <tr>

                            </tr>
                            <tr>
                                <td>
                                    <br>Start Time:<br>
                                    <div class="custom-select">
                                        <select name="StartPeriod">
                                            <option value="">Select Start Period</option>
                                            <option value="1">8:00 AM</option>
                                            <option value="2">8:30 AM</option>
                                            <option value="3">9:00 AM</option>
                                            <option value="4">9:30 AM</option>
                                            <option value="5">10:00 AM</option>
                                            <option value="6">10:30 AM</option>
                                            <option value="7">11:00 AM</option>
                                            <option value="8">11:30 AM</option>
                                            <option value="9">12:00 AM</option>
                                            <option value="10">12:30 PM</option>
                                            <option value="11">13:00 PM</option>
                                            <option value="12">13:30 PM</option>
                                            <option value="13">14:00 PM</option>
                                            <option value="14">14:30 PM</option>
                                            <option value="15">15:00 PM</option>
                                            <option value="16">15:30 PM</option>
                                            <option value="17">16:00 PM</option>
                                            <option value="18">16:30 PM</option>
                                            <option value="19">17:30 PM</option>
                                            <option value="20">18:00 PM</option>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <br>End Time:<br>
                                    <div class="custom-select">
                                        <select name="EndPeriod">
                                            <option value="">Select End Period</option>
                                            <option value="1">8:00 AM</option>
                                            <option value="2">8:30 AM</option>
                                            <option value="3">9:00 AM</option>
                                            <option value="4">9:30 AM</option>
                                            <option value="5">10:00 AM</option>
                                            <option value="6">10:30 AM</option>
                                            <option value="7">11:00 AM</option>
                                            <option value="8">11:30 AM</option>
                                            <option value="9">12:00 AM</option>
                                            <option value="10">12:30 AM</option>
                                            <option value="11">13:00 PM</option>
                                            <option value="12">13:30 PM</option>
                                            <option value="13">14:00 PM</option>
                                            <option value="14">14:30 PM</option>
                                            <option value="15">15:00 PM</option>
                                            <option value="16">15:30 PM</option>
                                            <option value="14">16:00 PM</option>
                                            <option value="15">16:30 PM</option>
                                            <option value="16">17:30 PM</option>
                                            <option value="17">18:00 PM</option>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <br>
                                    Event Location:                                    
                                    <div class="custom-select">
                                        <select name="LocationID">
                                            <option value="">Select Location</option>
                                            <%
                                                this.locationBeans = DB.queryLocation();
                                                for (LocationBean locationBean : locationBeans) {
                                                    if (!locationBean.getLocationID().equals("")) {
                                                        out.println("<option value=\"" + locationBean.getLocationID() + "\">" + locationBean.getLocationName() + "</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    Choose Event Color: <input type="Color" name="Color" value="#ff0000">
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right" width="100%">
                                    <input type="reset" class="btnFunction cancelBtn">
                                </td>
                                <td>    
                                    <input type="submit" class="btnFunction btnAdd" value="Add Department">
                                    <input type="hidden" name="delEventID" id="delEventID" value="">
                                    <input type="hidden" name="EventID" id="EventID" value="">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>

                <%
                    String delEventID = request.getParameter("delEventID");

                    String EventID = request.getParameter("EventID");//Key

                    String CourseID = request.getParameter("CourseID");
                    String TeacherID = request.getParameter("TeacherID");//REFERENCES DEPARTMENT(DepartmentID)
                    String ClassID = request.getParameter("ClassID");
                    String LocationID = request.getParameter("LocationID");

                    String Color = request.getParameter("Color");
                    String Date = request.getParameter("Date");
                    String StartPeriod = request.getParameter("StartPeriod");
                    String EndPeriod = request.getParameter("EndPeriod");

//ok
                    if (EventID == "") {
                        //add
                        DB.addEventRecord(CourseID, TeacherID, ClassID, LocationID, Color, Date, StartPeriod, EndPeriod);
                    } else if (delEventID != "") {
                        //del
                        DB.delEventDay(delEventID);
                    } else {
                        //edit
                        DB.editEvent(EventID, CourseID, TeacherID, ClassID, LocationID, Color, Date, StartPeriod, EndPeriod);
                    }
                    this.eventBeans = DB.queryEvent();
                %>

                <br>
                <%
                    for (EventBean eBean : eventBeans) {
                        out.print("<div class=\"card WhiteCard centerCard\">");
                        out.print("<table style=\"width: 100%;\">");
                        out.println("<form  method=\"get\" action=\"event.jsp\">");
                        out.println("Event ID: <input type=\"text\" name=\"EventID\"  width=\"20px\" style=\"text-align: left;padding: 0px ;background-color: white;box-shadow: none;border:none\" readonly value=\"" + eBean.getEventID() + "\">");
                        out.println("</td></tr>");
                        //                                               Course
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        out.println("<tr>");
                        out.println("<td>");
                        out.println("Course :");
                        out.println("</td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td colspan=\"2\">");
                        out.println("<div class=\"custom-select\">");
                        out.println("<select name=\"CourseID\">");

                        out.println("<option value=\"" + eBean.getCourseID() + "\">" + DB.queryCourse(eBean.getCourseID()) + "</option>");
                        this.courseBeans = DB.queryCourse();
                        for (CourseBean courseBean : courseBeans) {
                            if (!courseBean.getCourseID().equals("")) {
                                out.println("<option value=\"" + courseBean.getCourseID() + "\">" + courseBean.getCourseName() + "</option>");
                            }
                        }

                        out.println("</select>");
                        out.println("</div>");
                        out.println("</td>");
                        out.println("</tr>");
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                        //                                               Teacher
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        out.println("<tr>");
                        out.println("<td>");
                        out.println("Teachers-in-charge :");
                        out.println("</td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td colspan=\"2\">");
                        out.println("<div class=\"custom-select\">");
                        out.println("<select name=\"TeacherID\">");

                        out.println("<option value=\"" + eBean.getTeacherID() + "\">" + DB.queryTeacherName(eBean.getTeacherID()) + "</option>");
                        this.teacherBeans = DB.queryTeacher();
                        for (TeacherBean teacherBean : teacherBeans) {
                            if (!teacherBean.getTeacherID().equals("")) {
                                out.println("<option value=\"" + teacherBean.getTeacherID() + "\">" + teacherBean.getName() + "</option>");
                            }
                        }

                        out.println("</select>");
                        out.println("</div>");
                        out.println("</td>");
                        out.println("</tr>");
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                        //                                               Class
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        out.println("<tr>");
                        out.println("<td>");
                        out.println("Class :");
                        out.println("</td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td colspan=\"2\">");
                        out.println("<div class=\"custom-select\">");
                        out.println("<select name=\"ClassID\">");

                        out.println("<option value=\"" + eBean.getClassID() + "\">" + DB.queryClass(eBean.getClassID()) + "</option>");
                        this.courseBeans = DB.queryCourse();
                        for (ClassBean classBean : classBeans) {
                            if (!classBean.getClassID().equals("")) {
                                out.println("<option value=\"" + classBean.getClassID() + "\">" + classBean.getClassName() + "</option>");
                            }
                        }

                        out.println("</select>");
                        out.println("</div>");
                        out.println("</td>");
                        out.println("</tr>");

                        ///////////////////////////////////////////////Date///////////////////////////////////////////////////////
                        out.println("<tr>");
                        out.println("<td colspan=\"2\">");
                        out.println("Date :");
                        out.println("<input type=\"date\" id=\"eventdate\" name=\"Date\" value=\"" + eBean.getDate() + "\">");
                        out.println("</td>");
                        out.println("</tr>");
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                        //                                             Start  Time
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        out.println("<tr>");
                        out.println("<td>");

                        out.print("<br>Start Time:<br>");

                        out.print("<div class=\"custom-select\">");
                        out.print("<select name=\"StartPeriod\">");

                        String Showdate = DB.converterToDate(Integer.parseInt(eBean.getStartPeriod()));

                        out.println("<option value=\"" + eBean.getStartPeriod() + "\">" + Showdate + "</option>");
                        out.println("<option value=\"1\">8:00 AM</option>");
                        out.println("<option value=\"2\">8:30 AM</option>");
                        out.println("<option value=\"3\">9:00 AM</option>");
                        out.println("<option value=\"4\">9:30 AM</option>");
                        out.println("<option value=\"5\">10:00 AM</option>");
                        out.println("<option value=\"6\">10:30 AM</option>");
                        out.println("<option value=\"7\">11:00 AM</option>");
                        out.println("<option value=\"8\">11:30 AM</option>");
                        out.println("<option value=\"9\">12:00 AM</option>");
                        out.println("<option value=\"10\">12:30 AM</option>");
                        out.println("<option value=\"11\">13:00 AM</option>");
                        out.println("<option value=\"12\">13:30 AM</option>");
                        out.println("<option value=\"13\">14:00 AM</option>");
                        out.println("<option value=\"14\">14:30 AM</option>");
                        out.println("<option value=\"15\">15:00 AM</option>");
                        out.println("<option value=\"16\">15:30 AM</option>");
                        out.println("<option value=\"14\">16:00 AM</option>");
                        out.println("<option value=\"15\">16:30 AM</option>");
                        out.println("<option value=\"16\">17:30 AM</option>");
                        out.println("<option value=\"17\">18:00 AM</option>");

                        out.println("</select>");
                        out.println("</div>");
                        out.println("</td>");
                        //out.println("</tr>");
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        //                                             End  Time
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        //out.println("<tr>");
                        out.println("<td>");

                        out.print("<br>End Time:<br>");

                        out.print("<div class=\"custom-select\">");
                        out.print("<select name=\"EndPeriod\">");

                        String Showdate2 = DB.converterToDate(Integer.parseInt(eBean.getEndPeriod()));

                        out.println("<option value=\"" + eBean.getEndPeriod() + "\">" + Showdate2 + "</option>");
                        out.println("<option value=\"1\">8:00 AM</option>");
                        out.println("<option value=\"2\">8:30 AM</option>");
                        out.println("<option value=\"3\">9:00 AM</option>");
                        out.println("<option value=\"4\">9:30 AM</option>");
                        out.println("<option value=\"5\">10:00 AM</option>");
                        out.println("<option value=\"6\">10:30 AM</option>");
                        out.println("<option value=\"7\">11:00 AM</option>");
                        out.println("<option value=\"8\">11:30 AM</option>");
                        out.println("<option value=\"9\">12:00 AM</option>");
                        out.println("<option value=\"10\">12:30 AM</option>");
                        out.println("<option value=\"11\">13:00 AM</option>");
                        out.println("<option value=\"12\">13:30 AM</option>");
                        out.println("<option value=\"13\">14:00 AM</option>");
                        out.println("<option value=\"14\">14:30 AM</option>");
                        out.println("<option value=\"15\">15:00 AM</option>");
                        out.println("<option value=\"16\">15:30 AM</option>");
                        out.println("<option value=\"14\">16:00 AM</option>");
                        out.println("<option value=\"15\">16:30 AM</option>");
                        out.println("<option value=\"16\">17:30 AM</option>");
                        out.println("<option value=\"17\">18:00 AM</option>");

                        out.println("</select>");
                        out.println("</div>");
                        out.println("</td>");
                        out.println("</tr>");

                        //                                               Location
                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        out.println("<tr>");
                        out.println("<td>");
                        out.println("Class :");
                        out.println("</td>");
                        out.println("</tr>");

                        out.println("<tr>");
                        out.println("<td colspan=\"2\">");
                        out.println("<div class=\"custom-select\">");
                        out.println("<select name=\"LocationID\">");

                        out.println("<option value=\"" + eBean.getLocationID() + "\">" + DB.queryLocation(eBean.getLocationID()) + "</option>");
                        this.locationBeans = DB.queryLocation();
                        for (LocationBean classBean : locationBeans) {
                            if (!classBean.getLocationID().equals("")) {
                                out.println("<option value=\"" + classBean.getLocationID() + "\">" + DB.queryLocation(classBean.getLocationID()) + "</option>");
                            }
                        }

                        out.println("</select>");
                        out.println("</div>");
                        out.println("</td>");
                        out.println("</tr>");

                        //                                               Color
                        out.println("<tr>");
                        out.println("<td colspan=\"2\">");
                        out.println("Choose Event Color: <input type=\"Color\" name=\"Color\" value=\"" + eBean.getColor() + "\">");
                        out.println("</td>");
                        out.println("</tr>");

                        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        out.println("<input type=\"hidden\" name=\"delEventID\" id=\"delEventID\" value=\"\">");
                        out.println("<td width=\"900%\">"
                                + "<input type=\"button\" class=\"btnFunction cancelBtn\" onclick=\"window.location.href = 'event.jsp?delEventID=" + eBean.getEventID() + "';\" value=\"X\"/>"
                                + "</td><td>");
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
