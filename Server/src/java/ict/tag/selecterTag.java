/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.tag;

import ict.db.Database;
import ict.bean.CourseBean;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author wansichong
 */
public class selecterTag extends SimpleTagSupport {

    private ArrayList<CourseBean> courseBeans = null;

    String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
    String username = "APP";
    String passord = "APP";
    Database DB = new Database(url, username, passord);

    @Override
    public void doTag() {
        try {
            JspWriter out = getJspContext().getOut();

            out.print("<div class=\"custom-select\">"
                    + "<select name=\"CourseID\">"
                    + "<option value=\"\">Select Course</option>");

            this.courseBeans = DB.queryCourse();
            for (CourseBean courseBean : courseBeans) {
                if (!courseBean.getCourseID().equals("")) {
                    out.println("<option value=\"" + courseBean.getCourseID() + "\">" + courseBean.getCourseName() + "</option>");
                }
            }

            out.print("</select>"
                    + "</div>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
