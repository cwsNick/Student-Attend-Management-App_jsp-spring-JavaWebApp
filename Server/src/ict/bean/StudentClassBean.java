/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;

public class StudentClassBean implements Serializable {

    private String StudentClassID;
    private String ClassID;
    private String StudentID;

    public StudentClassBean(String StudentClassID, String ClassID, String StudentID) {
        this.StudentClassID = StudentClassID;
        this.ClassID = ClassID;
        this.StudentID = StudentID;
    }

    
    public StudentClassBean() {
        this.StudentClassID = "";
        this.ClassID = "";
        this.StudentID = "";
    }

    public String getStudentClassID() {
        return StudentClassID;
    }

    public void setStudentClassID(String StudentClassID) {
        this.StudentClassID = StudentClassID;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    @Override
    public String toString() {
        return "StudentClassBean{" + "StudentClassID=" + StudentClassID + ", ClassID=" + ClassID + ", StudentID=" + StudentID + '}';
    }
    
}
