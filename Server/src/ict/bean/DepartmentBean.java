/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;

/**
 *
 * @author wansichong
 */
public class DepartmentBean implements Serializable{

    private String DepartmentID;
    private String DepartmentName;
    private String DepartmentDetailed;

    public DepartmentBean() {
        this.DepartmentID = "";
        this.DepartmentName = "";
        this.DepartmentDetailed = "";
    }

    public DepartmentBean(String DepartmentID, String DepartmentName, String DepartmentDetailed) {
        this.DepartmentID = DepartmentID;
        this.DepartmentName = DepartmentName;
        this.DepartmentDetailed = DepartmentDetailed;
    }

    public DepartmentBean(String DepartmentName, String DepartmentDetailed) {
        this.DepartmentID = "";
        this.DepartmentName = DepartmentName;
        this.DepartmentDetailed = DepartmentDetailed;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getDepartmentDetailed() {
        return DepartmentDetailed;
    }

    public void setDepartmentDetailed(String DepartmentDetailed) {
        this.DepartmentDetailed = DepartmentDetailed;
    }    

    @Override
    public String toString() {
        return "DepartmentBean{" + "DepartmentID=" + DepartmentID + ", DepartmentName=" + DepartmentName + ", DepartmentDetailed=" + DepartmentDetailed + '}';
    }

}
