/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;

import ict.db.Database;
import ict.db.setUpDB;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author wansichong
 */
public class classTeacher {

    public static void main(String[] args) throws SQLException, IOException {

        String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        String username = "APP";
        String passord = "APP";

        Database DB = new Database(url, username, passord);
        setUpDB db = new setUpDB(url, username, passord);

        //System.out.println(DB.queryClassTeacher());
        //System.out.println(DB.queryClassTeacher("1"));//ok

        DB.addClassTeacher("1", "13");//ok
        DB.addClassTeacher("6", "13");//ok
        //DB.addClassTeacher("7", "15");//ok
        
        

        System.out.println(DB.queryClassTeacher());//ok
        System.out.println(DB.queryClassTeacher("13"));//ok
        //DB.delStudentClassRecord("3");//ok
                //System.out.println(DB.queryClassTeacher());//ok
        System.out.println(DB.queryClassTeacher("13"));//ok
    }
}
