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
public class teacher {
    public static void main(String[] args) throws SQLException, IOException {
        
        String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        String username = "APP";
        String passord = "APP";
        
        Database DB = new Database(url, username, passord);
        setUpDB db = new setUpDB(url, username, passord);
        
        System.out.println(DB.queryTeacher());
        System.out.println(DB.queryTeacherName("6"));
    }
}
