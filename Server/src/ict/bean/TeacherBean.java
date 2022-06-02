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
public class TeacherBean implements Serializable {

    private String TeacherID;
    private String DepartmentID;
    private String Name;

    public TeacherBean() {
        this.TeacherID = "";
        this.DepartmentID = "";
        this.Name = "";
    }

    public TeacherBean(String TeacherID, String DepartmentID, String Name) {
        this.TeacherID = TeacherID;
        this.DepartmentID = DepartmentID;
        this.Name = Name;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "TeacherBean{" + "TeacherID=" + TeacherID + ", DepartmentID=" + DepartmentID + ", Name=" + Name + '}';
    }

}
