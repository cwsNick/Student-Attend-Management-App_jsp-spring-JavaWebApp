/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;

public class ClassBean implements Serializable {

    private String ClassID;//maked by system
    private String ClassName;
    private String DepartmentID;//REFERENCES DEPARTMENT(DepartmentID)
    private String Years;
    private String Detailed;

    public ClassBean(String ClassID, String ClassName, String DepartmentID, String Years, String Detailed) {
        this.ClassID = ClassID;
        this.ClassName = ClassName;
        this.DepartmentID = DepartmentID;
        this.Years = Years;
        this.Detailed = Detailed;
    }

    public ClassBean(String ClassName, String DepartmentID, String Years, String Detailed) {
        this.ClassID = "";
        this.ClassName = ClassName;
        this.DepartmentID = DepartmentID;
        this.Years = Years;
        this.Detailed = Detailed;
    }

        public ClassBean() {
        this.ClassID = "";
        this.ClassName = "";
        this.DepartmentID = "";
        this.Years = "";
        this.Detailed = "";
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getYears() {
        return Years;
    }

    public void setYears(String Years) {
        this.Years = Years;
    }

    public String getDetailed() {
        return Detailed;
    }

    public void setDetailed(String Detailed) {
        this.Detailed = Detailed;
    }

    @Override
    public String toString() {
        return "ClassBean{" + "ClassID=" + ClassID + ", ClassName=" + ClassName + ", DepartmentID=" + DepartmentID + ", Years=" + Years + ", Detailed=" + Detailed + '}';
    }

}
