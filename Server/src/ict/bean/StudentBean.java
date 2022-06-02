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
public class StudentBean implements Serializable {

    private String StudentID;
    private String DepartmentID;
    private String Name;

    public StudentBean() {
        this.StudentID = "";
        this.DepartmentID = "";
        this.Name = "";
    }
    
    public StudentBean(String StudentID, String DepartmentID, String Name) {
        this.StudentID = StudentID;
        this.DepartmentID = DepartmentID;
        this.Name = Name;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
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
        return "StudentBean{" + "StudentID=" + StudentID + ", DepartmentID=" + DepartmentID + ", Name=" + Name + '}';
    }
    
    
}
