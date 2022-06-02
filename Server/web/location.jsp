<%-- 
    Document   : location
    Created on : 2019/12/13, 上午 12:18:43
    Author     : wansichong
--%>

<%@page import="ict.bean.LocationBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page  import="java.util.*" %>
<%@page  import="ict.db.Database" %>
<%!
    private ArrayList<LocationBean> locationBeans = null;
    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Location Management</title>
        <link rel="stylesheet" href="index.css" />
    </head>

    <body>
        <h1 style="text-align: center;">
            Location Management
        </h1>
        <hr>


        <div class="main">

            <div class="row">

                <div class="card WhiteCard centerCard">
                    <form method="get" action="?">
                        <table width="100%">
                            <tr>
                                <td colspan="2"><input type="text" name="LocationName" maxlength="50" placeholder="Location Name" required></td>
                            </tr>
                            <tr>
                                <td colspan="2"><textarea name="Detailed" rows="5" cols="50" placeholder="Location Detailed"></textarea></td>
                            </tr>
                            <tr>
                                <td style="text-align: right" width="100%">
                                    <input type="reset" class="btnFunction cancelBtn">
                                </td>
                                <td>    
                                    <input type="submit" class="btnFunction btnAdd" value="Add Department">
                                </td>
                            <input type="hidden" name="delLocation" id="delLocation" value="">
                            <input type="hidden" name="LocationID" id="LocationID" value="">
                            </tr>
                        </table>
                    </form>
                </div>

                <%

                    String delLocation = request.getParameter("delLocation");
                    String LocationID = request.getParameter("LocationID");
                    String LocationName = request.getParameter("LocationName");
                    String Detailed = request.getParameter("Detailed");

                    if (LocationID == "") {
                        //add
                        DB.addLocation(LocationName, Detailed);
                    }
                    if (delLocation != "") {
                        //del
                        DB.delLocation(delLocation);
                    } else {
                        //edit
                        DB.editLocation(LocationID, LocationName, Detailed);
                    }
                    
                    this.locationBeans = DB.queryLocation();
                %>

                <br>
                <%
                    for (LocationBean lBeans : locationBeans) {
                        out.print("<div class=\"card WhiteCard centerCard\">");
                        out.print("<table style=\"width: 100%;\">");
                        out.println("<form  method=\"get\" action=\"location.jsp\">");

                        //LocationID
                        out.println("<tr><td  width=\"100%\" style=\"text-align: right\">");
                        out.println("Department ID: </td><td><input type=\"text\" name=\"LocationID\"  width=\"20px\" style=\"text-align: right;padding: 0px ;background-color: white;box-shadow: none;border:none\" readonly value=\"" + lBeans.getLocationID() + "\">");
                        out.println("</td></tr>");

                        //LocationName
                        out.println("<tr><td  colspan=\"2\">");
                        out.println("Location Name :<tr><td>");
                        out.println("<tr><td  colspan=\"2\" ><input type=\"text\" name=\"LocationName\" value=\""
                                + lBeans.getLocationName() + "\">");
                        out.println("</td></tr>");
                        out.println("<tr><td colspan=\"2\" >");

                        //Detailed
                        out.println("Location Detailed :<br>");
                        out.println("<textarea name=\"Detailed\" rows=\"5\" cols=\"50\">"
                                + lBeans.getCourseDetailed() + "</textarea>");

                        out.println("</td></tr>");

                        //delLocation;
                        out.println("<td style=\"text-align: right\">"
                                + "<input type=\"button\" class=\"btnFunction cancelBtn\" onclick=\"window.location.href = 'location.jsp?delLocation=" + lBeans.getLocationID() + "';\" value=\"X\"/>"
                                + "</td><td>");
                        out.println("<input type=\"hidden\" name=\"delLocation\" id=\"delLocation\" value=\"\">");
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
