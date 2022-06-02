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
public class LocationBean implements Serializable {

    private String LocationID;//maked by system
    private String LocationName;
    private String CourseDetailed;

    public LocationBean() {
        this.LocationID = "";
        this.LocationName = "";
        this.CourseDetailed = "";
    }

    public LocationBean(String LocationID, String LocationName, String CourseDetailed) {
        this.LocationID = LocationID;
        this.LocationName = LocationName;
        this.CourseDetailed = CourseDetailed;
    }

    public String getLocationID() {
        return LocationID;
    }

    public void setLocationID(String LocationID) {
        this.LocationID = LocationID;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String LocationName) {
        this.LocationName = LocationName;
    }

    public String getCourseDetailed() {
        return CourseDetailed;
    }

    public void setCourseDetailed(String CourseDetailed) {
        this.CourseDetailed = CourseDetailed;
    }

    @Override
    public String toString() {
        return "locationBean{" + "LocationID=" + LocationID + ", LocationName=" + LocationName + ", CourseDetailed=" + CourseDetailed + '}';
    }

}
