/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;

import ict.bean.AccountBean;
import ict.db.Database;
import ict.db.setUpDB;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author wansichong
 */
public class account {

    public static void main(String[] args) throws SQLException, IOException {

        String url = "jdbc:derby://localhost:1527/ESDAssignmentDB";
        String username = "APP";
        String passord = "APP";

        Database DB = new Database(url, username, passord);
        setUpDB db = new setUpDB(url, username, passord);
        /*
        AccountBean AccountBean = new AccountBean();

        AccountBean.setAccountID("10"); //
        AccountBean.setLoginID("Wong2");
        AccountBean.setUserID("6"); //
        AccountBean.setPassword("123Wong");
        AccountBean.setType("Teacher");
        AccountBean.setDepartmentOrYears("3");
        AccountBean.setName("Tom");
        System.out.println(AccountBean.toString());

        System.out.println(DB.queryAccount());
*/
        //DB.addAccount(AccountBean);
        //DB.editAccountRecord(AccountBean);
        DB.editDepartmentRecord("38", "oneTwo", "sbhjshbhsxhbxshbx");
        System.out.println(DB.queryDepartment());
    }
}
