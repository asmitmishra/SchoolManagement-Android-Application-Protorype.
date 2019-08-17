package com.example.mishr.scope_vit.Model;

public class ResearchProjectsDetails {

    private int ppid;
    private String projectID;
    private String fieldofResearch;
    private String departmentID;
    private String courseCode;

    public ResearchProjectsDetails(int id, String projid, String researchdield,String deptID, String code){

        setPpid(id);
        setProjectID(projid);
        setFieldofResearch(researchdield);
        setDepartmentID(deptID);
        setCourseCode(code);


    }

    public int getPpid() {
        return ppid;
    }

    public void setPpid(int ppid) {
        this.ppid = ppid;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getFieldofResearch() {
        return fieldofResearch;
    }

    public void setFieldofResearch(String fieldofResearch) {
        this.fieldofResearch = fieldofResearch;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
}
