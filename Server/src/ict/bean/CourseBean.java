/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;

/**
 *
 * @author wansichong
 */
public class CourseBean implements Serializable {
    
    private String CourseID;// NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT PK_COURSE PRIMARY KEY,"
    private String CourseName;
    private String CourseDetailed;

    public CourseBean() {
        this.CourseID = "";
        this.CourseName = "";
        this.CourseDetailed = "";
    }
    
        
    public CourseBean(String CourseName, String CourseDetailed) {
        this.CourseID = "";
        this.CourseName = CourseName;
        this.CourseDetailed = CourseDetailed;
    }
    
    public CourseBean(String CourseID, String CourseName, String CourseDetailed) {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.CourseDetailed = CourseDetailed;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getCourseDetailed() {
        return CourseDetailed;
    }

    public void setCourseDetailed(String CourseDetailed) {
        this.CourseDetailed = CourseDetailed;
    }

    @Override
    public String toString() {
        return "courseBean{" + "CourseID=" + CourseID + ", CourseName=" + CourseName + ", CourseDetailed=" + CourseDetailed + '}';
    }
}
