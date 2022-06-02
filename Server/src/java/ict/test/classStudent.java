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
public class classStudent {

    public static void main(String[] args) throws SQLException, IOException {

        String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        String username = "APP";
        String passord = "APP";

        Database DB = new Database(url, username, passord);
        setUpDB db = new setUpDB(url, username, passord);

        db.createTable();
        //DB.addStudentClassRecord("3", "1");//ok
        //DB.addStudentClassRecord("5", "1");//ok

        //DB.addStudentClassRecord("5", "13");//ok

        //System.out.println(DB.queryStudentClassbyClassID("1"));//ok
        //System.out.println(DB.queryStudentClass().toString());//ok
        
        //DB.delStudentClassRecord("3");
        
        
        //System.out.print(DB.queryStudentClassID("13", "4"));
    }
}
