package com.example.mishr.scope_vit.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "facultydetailsDatabase";
    public static final int DATABASE_VERSION = 1;


    private static final String FACULTY_DETAILS_TABLE = "FacultyDetails";
    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String EMAIL_KEY = "email";
    private static final String DESIGNATION_KEY = "designation";
    private static final String CABIN_KEY = "cab_num";
    private static final String CONTACT_KEY = "contact_num";


    private static final String STUDENT_DETAILS_TABLE = "studentdetails";
    private static final String MID_KEY = "id";
    private static final String STUDENT_NAME_KEY = "Studentname";
    private static final String STUDENT_ID_KEY = "StudentID";
    private static final String STUDENT_ADDRESS_KEY = "Address";
    private static final String STUDENT_DOB_KEY = "DateOfBirth";
    private static final String JOINING_DATE_KEY = "JoiningKey";
    private static final String PROGRAM_KEY = "Program";
    private static final String STUDENT_CONTACT_KEY = "ContactNumber";




    private static final String COURSE_TABLE = "CourseDetails";
    private static final String PID_KEY = "id";
    private static final String COURSE_NAME_KEY = "name";
    private static final String COURSE_CODE_KEY = "code";
    private static final String COURSE_CREDIT_KEY = "credit";
    private static final String COURSE_FAC_ID_KEY = "facid";


    private static final String DEPARTMENT_TABLE = "DepartmentDetails";
    private static final String PID1_KEY = "id";
    private static final String DEPARTMENT_NAME_KEY = "DepartmentName";
    private static final String DEPARTMENT_ID_KEY = "DepartmentID";
    private static final String DEPARTMENT_LOCATION_KEY = "DepartmentLocation";


    private static final String SPECIALIZATION_TABLE = "Specialization";
    private static final String SID_KEY = "Sid";
    private static final String SFACULTY_ID_KEY = "FacultyID";
    private static final String SCOURSE_CODE_KEY = "CourseCode";
    private static final String PREREQUISITE_KEY = "Prerequisite";


    private static final String RESEARCHPROJECT_TABLE = "ResearchAndProjects";
    private static final String PPID_KEY = "ID";
    private static final String PROJECTID_KEY = "ProjectID";
    private static final String FIELDRESEARCH_KEY = "FieldOfResearch";
    private static final String DEPARTMENTID_KEY = "DepartmentID";
    private static final String COURSECODE_KEY = "Coursecode";





    public DatabaseHandler(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String createDatabaseSQL = "create table " + FACULTY_DETAILS_TABLE + "("
                + ID_KEY + " integer primary key autoincrement " + ", "
                + NAME_KEY + " text" + ", " + EMAIL_KEY + " text" + ", "
                + DESIGNATION_KEY + " text" + ", " + CONTACT_KEY + " integer" +", "
                + CABIN_KEY + " text" + " )";

        String createSpecializationTable = "create table " + SPECIALIZATION_TABLE + "( "
                + SID_KEY + " integer primary key autoincrement" + ", "
                + SFACULTY_ID_KEY + " integer" + ", "
                + SCOURSE_CODE_KEY + " text" + ", "
                + PREREQUISITE_KEY + " text" + " )";



        String createResearchProjectTable = "create table " + RESEARCHPROJECT_TABLE + "("
                + PPID_KEY + " integer primary key autoincrement " + ", "
                + PROJECTID_KEY + " text" + ", " + FIELDRESEARCH_KEY + " text" + ", "
                + DEPARTMENTID_KEY + " text" + ", " + COURSECODE_KEY + " text" + " )";



        String createDepartmentTable = "create table " + DEPARTMENT_TABLE + "( "
                + PID1_KEY + " integer primary key autoincrement" + ", "
                + DEPARTMENT_NAME_KEY + " text" + ", "
                + DEPARTMENT_ID_KEY + " text" + ", "
                + DEPARTMENT_LOCATION_KEY + " text" + " )";

        String createCourseTable = "create table " + COURSE_TABLE + "( "
                + PID_KEY + " integer primary key autoincrement" + ", "
                + COURSE_NAME_KEY + " text" + ", "
                + COURSE_CODE_KEY + " text" + ", "
                + COURSE_CREDIT_KEY + " integer" + ", "
                + COURSE_FAC_ID_KEY + " integer" + " )";


        String createStudentTable = "create table " + STUDENT_DETAILS_TABLE + "( "
                + MID_KEY + " integer primary key autoincrement" + ", "
                + STUDENT_NAME_KEY + " text" + ", "
                + STUDENT_ID_KEY + " integer" + ", "
                + STUDENT_ADDRESS_KEY + " text" + ", "
                + STUDENT_DOB_KEY + " text" + ", "
                + JOINING_DATE_KEY + " text" + ", "
                + PROGRAM_KEY + " text" + ", "
                + STUDENT_CONTACT_KEY + " integer" + " )";


        db.execSQL(createSpecializationTable);
        db.execSQL(createStudentTable);
        db.execSQL(createCourseTable);
        db.execSQL(createDatabaseSQL);
        db.execSQL(createDepartmentTable);
        db.execSQL(createResearchProjectTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + FACULTY_DETAILS_TABLE);
        db.execSQL("drop table if exists " + COURSE_TABLE);
        db.execSQL("drop table if exists " + DEPARTMENT_TABLE);
        db.execSQL("drop table if exists " + SPECIALIZATION_TABLE);
        db.execSQL("drop table if exists " + RESEARCHPROJECT_TABLE);
        db.execSQL("drop table if exists " + STUDENT_DETAILS_TABLE);
        onCreate(db);

    }


    public void addFaculty(FacultyDetails facultyDetailsObject){

        SQLiteDatabase database = getWritableDatabase();

        String addFacultyDetailsSQLCommand = "insert into " + FACULTY_DETAILS_TABLE +
                " values(null, '" +facultyDetailsObject.getFacultyname() +
                "', '" + facultyDetailsObject.getEmailID() +
                "', '" + facultyDetailsObject.getDesignation() +
                "', '" + facultyDetailsObject.getContact_number() +
                "', '" + facultyDetailsObject.getCabin_number() + "')";

        database.execSQL(addFacultyDetailsSQLCommand);
        database.close();

    }

    public void addCourse(CourseDetails courseDetails){

        SQLiteDatabase database = getWritableDatabase();

        String addCourseDetailsSQLCommand = "insert into " + COURSE_TABLE +
                " values(null, '" +courseDetails.getCourseName() +
                "', '" + courseDetails.getCourseCode() +
                "', '" + courseDetails.getCourseCredit() +
                "', '" + courseDetails.getCourseFacID() + "')";

        database.execSQL(addCourseDetailsSQLCommand);
        database.close();

    }


    public void addProject(ResearchProjectsDetails researchProjectsDetails){

        SQLiteDatabase database = getWritableDatabase();
        String addProjectDetailSQLCommand = "insert into " + RESEARCHPROJECT_TABLE +
                " values(null, '" + researchProjectsDetails.getProjectID() +
                "', '" + researchProjectsDetails.getFieldofResearch() +
                "', '" + researchProjectsDetails.getDepartmentID() +
                "', '" + researchProjectsDetails.getCourseCode() + "')";

        database.execSQL(addProjectDetailSQLCommand);
        database.close();



    }

    public void addStudent(StudentDetails studentDetails){

        SQLiteDatabase database = getWritableDatabase();
        String addStudentDetailsSQLCommand = "insert into " + STUDENT_DETAILS_TABLE +
                " values(null, '" + studentDetails.getStudentname() +
                "', '" + studentDetails.getStudentID() +
                "', '" + studentDetails.getAddress() +
                "', '" + studentDetails.getDob() +
                "', '" + studentDetails.getJoiningdate() +
                "', '" + studentDetails.getProgram() +
                "', '" + studentDetails.getContactnumber() +"')";

        database.execSQL(addStudentDetailsSQLCommand);
        database.close();

    }






    public void addSpecialization(SpecializationDetails specializationDetails){

        SQLiteDatabase database = getWritableDatabase();
        String addSpecializationDetailsSQLCommand = "insert into " + SPECIALIZATION_TABLE +
                " values(null, '" + specializationDetails.getSfacultyid() +
                "', '" + specializationDetails.getScoursecode() +
                "', '" + specializationDetails.getPrerequisite() + "')";
        database.execSQL(addSpecializationDetailsSQLCommand);
        database.close();



    }




    public void addDepartment(DepartmentDetails departmentDetails){

        SQLiteDatabase database = getWritableDatabase();

        String addDepartmentDetailsSQLCommand = "insert into " + DEPARTMENT_TABLE +
                " values(null, '" + departmentDetails.getDeptname() +
                "', '" + departmentDetails.getDeptid() +
                "', '" + departmentDetails.getLocation() + "')";

        database.execSQL(addDepartmentDetailsSQLCommand);
        database.close();

    }






    public void deleteCourseObjectFromDatabaseByID(int pid){

        SQLiteDatabase database = getWritableDatabase();

        String deleteCourseSQLCommand = "delete from " + COURSE_TABLE +
                " where " + PID_KEY + " = " + pid;

        database.execSQL(deleteCourseSQLCommand);
        database.close();

    }



    public void deleteSpecilizationObjectFromDatabaseByID(int sid){

        SQLiteDatabase database = getWritableDatabase();

        String deleteSpecilizationSQLCommand = "delete from " + SPECIALIZATION_TABLE +
                " where " + SID_KEY + " = " + sid;

        database.execSQL(deleteSpecilizationSQLCommand);
        database.close();


    }





    public void deleteFacultyObjectFromDatabaseByID(int id){

        SQLiteDatabase database = getWritableDatabase();
        String deleteFacultySQLCommand = "delete from " + FACULTY_DETAILS_TABLE +
                                         " where " + ID_KEY + " = " + id;
        database.execSQL(deleteFacultySQLCommand);
        database.close();

    }


    public void deleteDepartmentObjectFromDatabaseByID(int id){

        SQLiteDatabase database = getWritableDatabase();
        String deleteDepartmentSQLCommand = "delete from " + DEPARTMENT_TABLE +
                " where " + PID1_KEY + " = " + id;
        database.execSQL(deleteDepartmentSQLCommand);
        database.close();

    }




    public void modifyFacultyObject(int facultyID, String facultyname, String facultydesignation, String cabin_number,
                                    int contact_number, String email ){

        SQLiteDatabase database = getWritableDatabase();
        String modifyFacultySQLCommand = "update " + FACULTY_DETAILS_TABLE +
                " set " + NAME_KEY + " = '" + facultyname + "', " + EMAIL_KEY + "= '" + email +
                "', " + DESIGNATION_KEY + " = '" + facultydesignation +
                "', " + CABIN_KEY + " = '" + cabin_number +
                "', " + CONTACT_KEY + " = '" + contact_number +
                "' " + "where " + ID_KEY + " = " + facultyID;
        database.execSQL(modifyFacultySQLCommand);
        database.close();

    }



    public void modifyCourseObject(int course_pid, String coursename, String coursecode, int coursecredit, int course_facid){

        SQLiteDatabase database = getWritableDatabase();
        String modifyCourseSQLCommand = "update " + COURSE_TABLE +
                " set " + COURSE_NAME_KEY + " = '" + coursename + "', " + COURSE_CODE_KEY + " = '" + coursecode +
                 "', " + COURSE_CREDIT_KEY + " = '" + coursecredit + "', " + COURSE_FAC_ID_KEY + " = '" + course_facid +
                 "' " + "where " + PID_KEY + " = " + course_pid;
        database.execSQL(modifyCourseSQLCommand);
        database.close();

    }


    public void modifyProjectObject(int ppid, String projID, String field, String deptid, String courseCode){

        SQLiteDatabase database = getWritableDatabase();
        String modifyProjectSQLCommand = "update " + RESEARCHPROJECT_TABLE +
                " set " + PROJECTID_KEY + " = '" + projID + "', " + FIELDRESEARCH_KEY + " = '" + field +
                "', " + DEPARTMENTID_KEY + " = '" + deptid + "', " + COURSECODE_KEY + " = '" + courseCode +
                "' " + "where " + PPID_KEY + " = " + ppid;
        database.execSQL(modifyProjectSQLCommand);
        database.close();



    }


    public void modifySpecilizationObject(int specilization_sid, int sfacid, String scoursecode, String sprerequisite ){

        SQLiteDatabase database = getWritableDatabase();
        String modifySpecilizationSQLCommand = "update " + SPECIALIZATION_TABLE +
                " set " + SFACULTY_ID_KEY + " = '" + sfacid + "', " + SCOURSE_CODE_KEY + " = '" + scoursecode +
                "', " + PREREQUISITE_KEY + " = '" + sprerequisite + "' " + "where " + SID_KEY + " = " + specilization_sid;

        database.execSQL(modifySpecilizationSQLCommand);
        database.close();


    }




    public void modifyDepartmentObject(int department_pid, String departmentname, String departmentid, String departmentlocation){

        SQLiteDatabase database = getWritableDatabase();
        String modifyDepartmentSQLCommand = "update " + DEPARTMENT_TABLE +
                " set " + DEPARTMENT_NAME_KEY + " = '" + departmentname + "', " + DEPARTMENT_ID_KEY + " = '" + departmentid +
                "', " + DEPARTMENT_LOCATION_KEY + " = '" + departmentlocation + "' " + "where " + PID1_KEY + " = " + department_pid;
        database.execSQL(modifyDepartmentSQLCommand);
        database.close();

    }





    public ArrayList<FacultyDetails> returnAllFacultyDetails(){

        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommand = "select * from " +FACULTY_DETAILS_TABLE;
        Cursor cursor = database.rawQuery(sqlQueryCommand,null);
        ArrayList<FacultyDetails> facultyDetails = new ArrayList<>();
        while(cursor.moveToNext()){

            FacultyDetails currentFacultyDetailObject = new FacultyDetails(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getInt(4),cursor.getString(5));
            facultyDetails.add(currentFacultyDetailObject);

        }

        database.close();
        return facultyDetails;
    }



    public ArrayList<CourseDetails> returnAllCourseDetails(){

        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommand = "select * from " + COURSE_TABLE;
        Cursor cursor = database.rawQuery(sqlQueryCommand,null);
        ArrayList<CourseDetails> courseDetails = new ArrayList<>();
        while(cursor.moveToNext()){

            CourseDetails currentCourseDetailObject = new CourseDetails(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4));

            courseDetails.add(currentCourseDetailObject);


        }

        database.close();
        return courseDetails;


    }



    public ArrayList<ResearchProjectsDetails> returnAllProjectDetails(){

        SQLiteDatabase database = getWritableDatabase();
        String returnAllsqlQueryCommand = "select * from " + RESEARCHPROJECT_TABLE;
        Cursor cursor = database.rawQuery(returnAllsqlQueryCommand, null);
        ArrayList<ResearchProjectsDetails> projectDetails = new ArrayList<>();
        while(cursor.moveToNext()){

            ResearchProjectsDetails currentProjectDetailsObject = new ResearchProjectsDetails(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));


            projectDetails.add(currentProjectDetailsObject);

        }

        database.close();
        return projectDetails;


    }




    public ArrayList<SpecializationDetails> returnAllSpecilizationDetails(){

        SQLiteDatabase database = getWritableDatabase();
        String sqlReturnAllSObjectCommand = "select * from " + SPECIALIZATION_TABLE;
        Cursor cursor = database.rawQuery(sqlReturnAllSObjectCommand,null);
        ArrayList<SpecializationDetails> specializationDetails = new ArrayList<>();
        while(cursor.moveToNext()){

            SpecializationDetails currentSpecilizationDetailObject = new SpecializationDetails(Integer.parseInt(cursor.getString(0)),
                    cursor.getInt(1),cursor.getString(2),cursor.getString(3));

            specializationDetails.add(currentSpecilizationDetailObject);

        }
        database.close();
        return specializationDetails;


    }


    public ArrayList<DepartmentDetails> returnAllDepartmentDetails(){

        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommand = "select * from " + DEPARTMENT_TABLE;
        Cursor cursor = database.rawQuery(sqlQueryCommand,null);
        ArrayList<DepartmentDetails> departmentDetails = new ArrayList<>();
        while(cursor.moveToNext()){

            DepartmentDetails currentDepartmentDetails = new DepartmentDetails(Integer.parseInt(cursor.getString(0)),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3));
            departmentDetails.add(currentDepartmentDetails);


        }

        database.close();
        return departmentDetails;


    }






    public FacultyDetails returnFacultyDetailsByID(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sqlQueryCommand = "select * from " + FACULTY_DETAILS_TABLE + " where " +
                 ID_KEY + " = ?" + id;
        Cursor cursor = database.rawQuery(sqlQueryCommand,null);

        FacultyDetails facultyDetails = null;

        if (cursor.moveToFirst()){

            facultyDetails = new FacultyDetails(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3),
                    cursor.getInt(4),cursor.getString(5));

        }
        database.close();
        return facultyDetails;

    }




}
