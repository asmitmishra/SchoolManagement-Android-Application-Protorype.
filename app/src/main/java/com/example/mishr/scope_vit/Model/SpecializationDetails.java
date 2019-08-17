package com.example.mishr.scope_vit.Model;

public class SpecializationDetails {

    private int Sid;
    private int sfacultyid;
    private String scoursecode;
    private String prerequisite;

    public SpecializationDetails(int id, int facid, String code, String requisite){

        setSid(id);
        setSfacultyid(facid);
        setScoursecode(code);
        setPrerequisite(requisite);
    }

    public int getSid() {
        return Sid;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public int getSfacultyid() {
        return sfacultyid;
    }

    public void setSfacultyid(int sfacultyid) {
        this.sfacultyid = sfacultyid;
    }

    public String getScoursecode() {
        return scoursecode;
    }

    public void setScoursecode(String scoursecode) {
        this.scoursecode = scoursecode;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }
}
