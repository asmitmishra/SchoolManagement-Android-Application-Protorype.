package com.example.mishr.scope_vit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch(id){
            case R.id.add_faculty_details:
                Intent addFacultyDetailsIntent = new Intent(MainActivity.this,AddFacultyActivity.class);
                startActivity(addFacultyDetailsIntent);
                return true;

            case R.id.delete_faculty_details:
                Intent deleteFacultyDetailsIntent = new Intent(MainActivity.this,DeleteFacultyActivity.class);
                startActivity(deleteFacultyDetailsIntent);
                return true;


            case R.id.update_faculty_details:
                Intent updateFacultyDetailsIntent = new Intent(MainActivity.this, UpdateFacultyDetailsActivity.class);
                startActivity(updateFacultyDetailsIntent);
                return true;

            case R.id.search_faculty_details:
                Intent search_faculty = new Intent(MainActivity.this,SearchFacultyActivity.class);
                startActivity(search_faculty);
                return true;

            case R.id.add_course_details:
                Intent addCourseDetailsIntent = new Intent(MainActivity.this, AddCourseActivity.class);
                startActivity(addCourseDetailsIntent);
                return true;

            case R.id.delete_course_details:
                Intent delete_course = new Intent(MainActivity.this, DeleteCourseActivity.class);
                startActivity(delete_course);
                return true;

            case R.id.update_course_details:
                Intent update_course = new Intent(MainActivity.this, UpdateCourseDetailsActivity.class);
                startActivity(update_course);
                return true;

            case R.id.add_department_details:
                Intent addDepartmentDetails = new Intent(MainActivity.this, AddDepartmentActivity.class);
                startActivity(addDepartmentDetails);
                return true;

            case R.id.delete_department_details:
                Intent delete_department = new Intent(MainActivity.this,DeleteDepartmentActivity.class);
                startActivity(delete_department);
                return true;


            case R.id.update_department_details:
                Intent update_department = new Intent(MainActivity.this, UpdateDepartmentActivity.class);
                startActivity(update_department);
                return true;

            case R.id.add_specilization_details:
                Intent add_specilization = new Intent(MainActivity.this, AddSpecilizationActivity.class);
                startActivity(add_specilization);
                return true;

            case R.id.delete_specilization_details:
                Intent delete_specilization = new Intent(MainActivity.this, DeleteSpecilizationActivity.class);
                startActivity(delete_specilization);
                return true;

            case R.id.update_specilization_details:
                Intent update_specilization = new Intent(MainActivity.this, UpdateSpecilizationDetailsActivity.class);
                startActivity(update_specilization);
                return true;

            case R.id.add_project_details:
                Intent add_projects = new Intent(MainActivity.this, AddProjectActivity.class);
                startActivity(add_projects);
                return true;

            case R.id.update_project_details:
                Intent updateProjects = new Intent(MainActivity.this, UpdateProjectActivity.class);
                startActivity(updateProjects);
                return true;

            case R.id.add_student_details:
                Intent add_students = new Intent(MainActivity.this,AddStudentActivity.class);
                startActivity(add_students);
                return true;

            case R.id.add_programs_details:
                Intent add_program = new Intent(MainActivity.this,AddProgramDetails.class);
                startActivity(add_program);
                return true;

        }




        return super.onOptionsItemSelected(item);
    }


}
