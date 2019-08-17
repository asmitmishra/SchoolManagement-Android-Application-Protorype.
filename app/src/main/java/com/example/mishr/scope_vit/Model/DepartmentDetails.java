package com.example.mishr.scope_vit.Model;

public class DepartmentDetails {

    private int Pid;
    private String deptname;
    private String deptid;
    private String location;

    public DepartmentDetails(int id, String name, String depid, String loc){

        setPid(id);
        setDeptname(name);
        setDeptid(depid);
        setLocation(loc);


    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
