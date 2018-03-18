package com.MediApp;

/**
 * Created by honey on 18/3/18.
 */

public class Hospital {
    private String Hospital_Name;
    private String Location_Coordinates;
    private String Location;
    private String Helpline;
    private String Website;

    public Hospital() {
    }

    public Hospital(String hospital_Name, String location_Coordinates, String location, String helpline, String website) {
        Hospital_Name = hospital_Name;
        Location_Coordinates = location_Coordinates;
        Location = location;
        Helpline = helpline;
        Website = website;
    }

    public String getHospital_Name() {
        return Hospital_Name;
    }

    public void setHospital_Name(String hospital_Name) {
        Hospital_Name = hospital_Name;
    }

    public String getLocation_Coordinates() {
        return Location_Coordinates;
    }

    public void setLocation_Coordinates(String location_Coordinates) {
        Location_Coordinates = location_Coordinates;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getHelpline() {
        return Helpline;
    }

    public void setHelpline(String helpline) {
        Helpline = helpline;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }
}
