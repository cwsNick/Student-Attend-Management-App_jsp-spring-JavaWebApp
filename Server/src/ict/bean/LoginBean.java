package ict.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {

    private String AccountID;
    private String UserID;
    private String LoginID;
    private String password;
    private String type;
    private String Name;
    private String DepartmentID;

    public LoginBean() {
        this.AccountID = "";
        this.UserID = "";
        this.LoginID = "";
        this.password = "";
        this.type = "";
        this.Name = "";
        this.DepartmentID = "";
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getLoginID() {
        return LoginID;
    }

    public void setLoginID(String LoginID) {
        this.LoginID = LoginID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        this.AccountID = accountID;
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

    @Override
    public String toString() {
        return "LoginBean{" + "AccountID=" + AccountID + ", UserID=" + UserID + ", LoginID=" + LoginID + ", password=" + password + ", type=" + type + ", Name=" + Name + ", DepartmentID=" + DepartmentID + '}';
    }
    
    
}
