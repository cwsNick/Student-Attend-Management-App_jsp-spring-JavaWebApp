/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

/**
 *
 * @author wansichong
 */
public class ClassTeacherBean {

    private String ClassTeacherID;
    private String ClassID;
    private String TeacherID;

    public ClassTeacherBean() {
        this.ClassTeacherID = "";
        this.ClassID = "";
        this.TeacherID = "";
    }

    public ClassTeacherBean(String ClassTeacherID, String ClassID, String TeacherID) {
        this.ClassTeacherID = ClassTeacherID;
        this.ClassID = ClassID;
        this.TeacherID = TeacherID;
    }

    public String getClassTeacherID() {
        return ClassTeacherID;
    }

    public void setClassTeacherID(String ClassTeacherID) {
        this.ClassTeacherID = ClassTeacherID;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String TeacherID) {
        this.TeacherID = TeacherID;
    }

    @Override
    public String toString() {
        return "ClassTeacherBean{" + "ClassTeacherID=" + ClassTeacherID + ", ClassID=" + ClassID + ", TeacherID=" + TeacherID + '}';
    }

}
