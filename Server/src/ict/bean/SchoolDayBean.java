/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;

public class SchoolDayBean implements Serializable {

    private String SchoolDayID;//PRIMARY KEY
    private String SemName;
    private String StartTime;
    private String StopTime;

    public SchoolDayBean() {
        this.SchoolDayID = "";
        this.SemName = "";
        this.StartTime = "";
        this.StopTime = "";
    }
    
    
    public SchoolDayBean(String SchoolDayID, String SemName, String StartTime, String StopTime) {
        this.SchoolDayID = SchoolDayID;
        this.SemName = SemName;
        this.StartTime = StartTime;
        this.StopTime = StopTime;
    }

    public String getSchoolDayID() {
        return SchoolDayID;
    }

    public void setSchoolDayID(String SchoolDayID) {
        this.SchoolDayID = SchoolDayID;
    }

    public String getSemName() {
        return SemName;
    }

    public void setSemName(String SemName) {
        this.SemName = SemName;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getStopTime() {
        return StopTime;
    }

    public void setStopTime(String StopTime) {
        this.StopTime = StopTime;
    }

    @Override
    public String toString() {
        return "SchoolDayBean{" + "SchoolDayID=" + SchoolDayID + ", SemName=" + SemName + ", StartTime=" + StartTime + ", StopTime=" + StopTime + '}';
    }
    
}
