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
public class testLocation {

    public static void main(String[] args) throws SQLException, IOException {

        String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        String username = "APP";
        String passord = "APP";

        Database DB = new Database(url, username, passord);
        setUpDB db = new setUpDB(url, username, passord);

        //DB.addClassRecord("IT99", "1", "3", "Hi");
        //System.out.println(DB.queryClass());
        //DB.delClassRecord("2");
        //System.out.println(DB.queryClass());
        //DB.editClassRecord("1", "IT114105-1C", "2", "4", "Hi");
        System.out.println(DB.queryLocation());//s
        DB.addLocation("C-777", "Poloy");//s
        //DB.delLocation("2");//s
        System.out.println(DB.queryLocation());
        System.out.println(DB.queryLocation("1"));//s
        
        DB.editLocation("1", "HKU", "Konu");
        System.out.println(DB.queryLocation());//s
        System.out.println(DB.queryLocation("1"));//s

        //DB.editDepartmentRecord(passord, username, username);
    }
}
