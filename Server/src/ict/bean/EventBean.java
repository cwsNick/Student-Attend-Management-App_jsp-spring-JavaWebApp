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
public class EventBean implements Serializable {

    private String EventID; //PK_EVENT PRIMARY KEY
    
    private String CourseID; //REFERENCES COURSE(CourseID)
    private String TeacherID; //REFERENCES TEACHER(TeacherID)
    private String ClassID; //REFERENCES CLASS(ClassID)
    private String LocationID; //REFERENCES LOCATION(LocationID)
    
    private String Color;
    private String Date;
    private String StartPeriod;
    private String EndPeriod;
    
    private String DurationTime;//addition, not in DB

    public EventBean() {
        this.EventID = "";
        this.CourseID = "";
        this.TeacherID = "";
        this.ClassID = "";
        this.LocationID = "";
        this.Color = "";
        this.Date = "";
        this.StartPeriod = "";
        this.EndPeriod = "";
        
        this.DurationTime="";
    }

    public EventBean(String CourseID, String TeacherID, String ClassID, String LocationID, String Color, String Date, String StartPeriod, String EndPeriod) {
        this.EventID = "";
        this.CourseID = CourseID;
        this.TeacherID = TeacherID;
        this.ClassID = ClassID;
        this.LocationID = LocationID;
        this.Color = Color;
        this.Date = Date;
        this.StartPeriod = StartPeriod;
        this.EndPeriod = EndPeriod;
        
        this.DurationTime = Integer.parseInt(this.StartPeriod) + Integer.parseInt(this.EndPeriod)+"";
    }

    public String getDurationTime() {
        this.DurationTime = Integer.parseInt(this.StartPeriod) + Integer.parseInt(this.EndPeriod)+"";
        return DurationTime;
    }

    public void setDurationTime(String DurationTime) {
        this.DurationTime = DurationTime;
    }
    
    public void setDurationTime() {
        this.DurationTime = Integer.parseInt(this.StartPeriod) + Integer.parseInt(this.EndPeriod)+"";
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String EventID) {
        this.EventID = EventID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public String getLocationID() {
        return LocationID;
    }

    public void setLocationID(String LocationID) {
        this.LocationID = LocationID;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getStartPeriod() {
        return StartPeriod;
    }

    public void setStartPeriod(String StartPeriod) {
        this.StartPeriod = StartPeriod;
    }

    public String getEndPeriod() {
        return EndPeriod;
    }

    public void setEndPeriod(String EndPeriod) {
        this.EndPeriod = EndPeriod;
    }

    @Override
    public String toString() {
        return "EventBean{" + "EventID=" + EventID + ", CourseID=" + CourseID + ", TeacherID=" + TeacherID + ", ClassID=" + ClassID + ", LocationID=" + LocationID + ", Color=" + Color + ", Date=" + Date + ", StartPeriod=" + StartPeriod + ", EndPeriod=" + EndPeriod + ", DurationTime=" + DurationTime + ", DurationTime=" + getDurationTime() + '}';
    }
}
