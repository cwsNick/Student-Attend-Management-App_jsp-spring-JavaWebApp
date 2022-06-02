package ict.bean;

import java.io.Serializable;

public class AccountBean implements Serializable {
    private String loginID;
    private String accountID;//
    private String userID;//
    private String password;
    private String type;
    private String departmentOrYears;
    private String name;

    public AccountBean() {
        loginID ="";
        accountID = "";
        userID = "";
        password = "";
        type = "";
        departmentOrYears = "";
        name = "";
    }

    @Override
    public String toString() {
        return "AccountBean{" + "LoginID=" + loginID + ", accountID=" + accountID + ", userID=" + userID + ", password=" + password + ", type=" + type + ", departmentOrYears=" + departmentOrYears + ", name=" + name + '}';
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartmentOrYears() {
        return departmentOrYears;
    }

    public void setDepartmentOrYears(String departmentOrYears) {
        this.departmentOrYears = departmentOrYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
