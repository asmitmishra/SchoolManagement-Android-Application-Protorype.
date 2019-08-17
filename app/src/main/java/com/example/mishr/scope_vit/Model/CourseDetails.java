package com.example.mishr.scope_vit.Model;

public class CourseDetails {

    private int pid;
    private String courseName;
    private String courseCode;
    private int courseCredit;
    private int courseFacID;


    public CourseDetails(int id, String name, String code, int credit, int facid){

        setPid(id);
        setCourseName(name);
        setCourseCode(code);
        setCourseCredit(credit);
        setCourseFacID(facid);


    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public int getCourseFacID() {
        return courseFacID;
    }

    public void setCourseFacID(int courseFacID) {
        this.courseFacID = courseFacID;
    }

    @Override
    public String toString() {
        return getCourseName() + " " + getCourseCode() + " " + getCourseCredit() + " " + getCourseFacID();
    }
}
