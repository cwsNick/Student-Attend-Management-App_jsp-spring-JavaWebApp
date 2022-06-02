package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ict.bean.AttendanceBean;
import java.util.ArrayList;
import ict.db.Database;

public final class StudentUI_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private ArrayList<AttendanceBean> attendanceBeans = null;

    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Student</title>\n");
      out.write("        <style>\n");
      out.write("            a {\n");
      out.write("                color: black;\n");
      out.write("                padding: 8px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            li a {\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            a.active {\n");
      out.write("                background-color: rgb(34, 151, 247);\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            a:hover:not(.active) {\n");
      out.write("                background-color: #cccccc;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                background-color: #ecf0f1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                background-color: #b3f5fb;\n");
      out.write("                color: lightcoral;\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("            img{\n");
      out.write("                width: 50%\n");
      out.write("            }\n");
      out.write("            #menu {\n");
      out.write("                background-color: white;\n");
      out.write("                color: orange;\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("            .leftPart, .rightPart {\n");
      out.write("                border:2px white solid;\n");
      out.write("                float:left;\n");
      out.write("                width: 48%;\n");
      out.write("                height: 200px;\n");
      out.write("                margin-right:10px;\n");
      out.write("                margin-bottom:20px;\n");
      out.write("                background-color: white;\n");
      out.write("                box-shadow: 0 3px 6px 0 rgba(0, 0, 0, 0.2);\n");
      out.write("                transition: 0.3s;\n");
      out.write("                border-radius: 3px;\n");
      out.write("            }\n");
      out.write("            .leftPart:hover, .rightPart:hover {\n");
      out.write("                border-color: rgb(34, 151, 247);\n");
      out.write("                border-style: solid;\n");
      out.write("                box-shadow: 0 2px rgb(26, 143, 240);\n");
      out.write("                transition: 0.2s;\n");
      out.write("            }\n");
      out.write("            ul {\n");
      out.write("                list-style-type: none;\n");
      out.write("            }\n");
      out.write("            input[type=submit]{\n");
      out.write("                background: #4B99AD;\n");
      out.write("                padding: 15px 30px 15px 30px;\n");
      out.write("                border: none;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("            input[type=submit]:hover{\n");
      out.write("                background: #4691A4;\n");
      out.write("                box-shadow:none;\n");
      out.write("                -moz-box-shadow:none;\n");
      out.write("                -webkit-box-shadow:none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #customers {\n");
      out.write("                background-color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #customers {\n");
      out.write("                font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #customers td, #customers th {\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                padding: 8px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #customers tr:nth-child(even){background-color: #f2f2f2;}\n");
      out.write("\n");
      out.write("            #customers tr:hover {background-color: #ddd;}\n");
      out.write("\n");
      out.write("            #customers th {\n");
      out.write("                padding-top: 12px;\n");
      out.write("                padding-bottom: 12px;\n");
      out.write("                text-align: left;\n");
      out.write("                background-color: #2980b9;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"leftcolumn\">\n");
      out.write("                <h1>\n");
      out.write("                    <table width=\"100%\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                Moodle - Student\n");
      out.write("                                ");
      ict.bean.LoginBean LoginBean = null;
      synchronized (session) {
        LoginBean = (ict.bean.LoginBean) _jspx_page_context.getAttribute("LoginBean", PageContext.SESSION_SCOPE);
        if (LoginBean == null){
          LoginBean = new ict.bean.LoginBean();
          _jspx_page_context.setAttribute("LoginBean", LoginBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("                                <b>\n");
      out.write("                                    ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ict.bean.LoginBean)_jspx_page_context.findAttribute("LoginBean")).getType())));
      out.write("\n");
      out.write("                                    ");
 out.println("<br>Name :" + LoginBean.getName()); 
      out.write("\n");
      out.write("                                    ");
 out.println("<br>Department ID:" + LoginBean.getDepartmentID());
      out.write("\n");
      out.write("                                    ");
 out.println("<br>User ID :" + LoginBean.getUserID());
      out.write("\n");
      out.write("                                    ");

                                        this.attendanceBeans = DB.queryStudentAttendance(LoginBean.getUserID());
                                    
      out.write("\n");
      out.write("                                </b>\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"text-align: right;\">\n");
      out.write("                                <form method=\"POST\" action=\"LoginController\">\n");
      out.write("                                    <input type=\"hidden\" name=\"action\" value=\"logout\">\n");
      out.write("                                    <input type=\"submit\" name=\"Logout\" value=\"Logout\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </h1>\n");
      out.write("\n");
      out.write("                <table  id=\"customers\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>\n");
      out.write("                            Date\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Class ID\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Class Name\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Attendance\n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

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
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("                \n");
      out.write("                <form action=\"ExportExcel/ExportExcelByStudent.jsp\">\n");
      out.write("                    <input type=\"submit\" value=\"Export Attendance To Excel\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
