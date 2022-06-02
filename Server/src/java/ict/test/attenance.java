/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;

import ict.bean.StudentClassBean;
import ict.db.Database;
import ict.db.setUpDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wansichong
 */
public class attenance {

    public static void main(String[] args) throws SQLException, IOException {

        String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        String username = "APP";
        String passord = "APP";

        Database DB = new Database(url, username, passord);
        setUpDB db = new setUpDB(url, username, passord);
        //db.createTable();

        /*
        DB.addAttendanceRecord("2018-10-12", "13", "3", "0");
        System.out.println(DB.hasAttendance("2018-11-12","11"));
        
        String SchoolDay = "2018-11-12";
        String ClassID = "13";
        if(!DB.hasAttendance(SchoolDay,ClassID)){
            ArrayList<StudentClassBean> studentClassBeans = null;
            studentClassBeans = DB.queryStudentClass(ClassID);
            
            for (StudentClassBean studentClassBean : studentClassBeans){
                DB.addAttendanceRecord(SchoolDay, ClassID, studentClassBean.getStudentID() , "0");
            }
        }
         */
        //System.out.println(DB.queryAttendance("2018-10-12","13"));
        //DB.setNoAttend("7");
        //System.out.println(DB.queryAttendanceStudentNumber("2018-10-12","13"));// X
        //System.out.println(DB.queryNoAttendance("2018-10-12","13"));
        //System.out.println(DB.queryYesAttendance("2018-10-12","13"));
        //System.out.println(DB.queryAttendanceClassByDay("2018-10-12"));
        //System.out.println(DB.queryAttendanceClassByDay("2018-11-12"));
        //System.out.print(DB.queryClassBean("1"));
        System.out.println(DB.queryAttendanceStudentNumber("2018-11-12", "13"));
        System.out.println(DB.queryNoAttendance("2018-11-12", "13"));
        System.out.println(DB.queryYesAttendance("2018-11-12", "13"));

        System.out.println(DB.queryAttendanceStudentNoNumber("2018-11-12", "13"));
        System.out.println(DB.queryAttendanceStudentYesNumber("2018-11-12", "13"));

        System.out.println(DB.queryAttendanceStudentPercentage("2018-11-12", "13"));

    }
}
