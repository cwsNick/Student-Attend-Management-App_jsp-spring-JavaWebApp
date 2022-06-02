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
public class AttendanceBean {

    private String AttendanceID;
    private String SchoolDay;
    private String ClassID;
    private String StudentID;
    private String Attendance;

    public AttendanceBean() {
        this.AttendanceID = "";
        this.SchoolDay = "";
        this.ClassID = "";
        this.StudentID = "";
        this.Attendance = "";
    }
    
    public AttendanceBean(String AttendanceID, String SchoolDay, String StudentClassID, String ClassID, String StudentID, String Attendance) {
        this.AttendanceID = AttendanceID;
        this.SchoolDay = SchoolDay;
        this.ClassID = ClassID;
        this.StudentID = StudentID;
        this.Attendance = Attendance;
    }

    public String getAttendanceID() {
        return AttendanceID;
    }

    public void setAttendanceID(String AttendanceID) {
        this.AttendanceID = AttendanceID;
    }

    public String getSchoolDay() {
        return SchoolDay;
    }

    public void setSchoolDay(String SchoolDay) {
        this.SchoolDay = SchoolDay;
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

    public String getAttendance() {
        return Attendance;
    }

    public void setAttendance(String Attendance) {
        this.Attendance = Attendance;
    }

    @Override
    public String toString() {
        return "AttendanceBean{" + "AttendanceID=" + AttendanceID + ", SchoolDay=" + SchoolDay + ", ClassID=" + ClassID + ", StudentID=" + StudentID + ", Attendance=" + Attendance + '}';
    }

    
}
