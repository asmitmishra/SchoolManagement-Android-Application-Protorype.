package com.example.mishr.scope_vit.Model;

public class FacultyDetails {

    private int facultyID;
    private String facultyname;
    private String Designation;
    private String cabin_number;
    private long contact_number;
    private String emailID;


    public FacultyDetails(int id,String name, String designation,String cab_num, long contact_num,String email){
        setFacultyID(id);
        setFacultyname(name);
        setDesignation(designation);
        setCabin_number(cab_num);
        setContact_number(contact_num);
        setEmailID(email);
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getCabin_number() {
        return cabin_number;
    }

    public void setCabin_number(String cabin_number) {
        this.cabin_number = cabin_number;
    }

    public long getContact_number() {
        return contact_number;
    }

    public void setContact_number(long contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    @Override
    public String toString() {
        return getFacultyname() + " " + getFacultyID() + " " + getDesignation() + " " + getContact_number() + " " + getEmailID() + " " + getCabin_number();
    }
}
