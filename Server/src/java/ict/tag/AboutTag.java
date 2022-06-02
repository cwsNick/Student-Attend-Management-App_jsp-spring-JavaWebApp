/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.tag;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AboutTag extends SimpleTagSupport{
    private String content;
    
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void doTag() {
        try {
            JspWriter out = getJspContext().getOut();
            out.print("<p>The sum of " + content + "</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
