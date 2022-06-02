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
public class event {
        public static void main(String[] args) throws SQLException, IOException {

        String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        String username = "APP";
        String passord = "APP";

        Database DB = new Database(url, username, passord);
        setUpDB db = new setUpDB(url, username, passord);
        
        
        System.out.println(DB.queryEvent());
        //DB.addEventRecord("1", "1", "1", "1", "MMMMS", "2018-10-12", "1", "4");//ok
        //DB.editEvent("2","1", "1", "1", "1", "AAAAAA", "2019-09-09", "2", "1");//ok
        System.out.println(DB.queryEvent());
        //DB.delEventDay("3");//ok
        //System.out.println(DB.queryEvent());
    }
}
