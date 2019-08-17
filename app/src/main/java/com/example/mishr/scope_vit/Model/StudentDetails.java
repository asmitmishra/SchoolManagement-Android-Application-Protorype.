package com.example.mishr.scope_vit.Model;

public class StudentDetails {

    private static int mid;
    private static String studentname;
    private static int studentID;
    private static String address;
    private static String dob;
    private static String joiningdate;
    private static String program;
    private static int contactnumber;

    public void StudentDetails(int id,String name, int sid, String addr, String dateofbirth, String joindate, String progrm, int contact){

        setMid(id);
        setStudentname(name);
        setStudentID(sid);
        setAddress(addr);
        setDob(dateofbirth);
        setJoiningdate(joindate);
        setProgram(progrm);
        setContactnumber(contact);

    }

    public static int getMid() {
        return mid;
    }

    public static void setMid(int mid) {
        StudentDetails.mid = mid;
    }

    public static String getStudentname() {
        return studentname;
    }

    public static void setStudentname(String studentname) {
        StudentDetails.studentname = studentname;
    }

    public static int getStudentID() {
        return studentID;
    }

    public static void setStudentID(int studentID) {
        StudentDetails.studentID = studentID;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        StudentDetails.address = address;
    }

    public static String getDob() {
        return dob;
    }

    public static void setDob(String dob) {
        StudentDetails.dob = dob;
    }

    public static String getJoiningdate() {
        return joiningdate;
    }

    public static void setJoiningdate(String joiningdate) {
        StudentDetails.joiningdate = joiningdate;
    }

    public static String getProgram() {
        return program;
    }

    public static void setProgram(String program) {
        StudentDetails.program = program;
    }

    public static int getContactnumber() {
        return contactnumber;
    }

    public static void setContactnumber(int contactnumber) {
        StudentDetails.contactnumber = contactnumber;
    }
}
