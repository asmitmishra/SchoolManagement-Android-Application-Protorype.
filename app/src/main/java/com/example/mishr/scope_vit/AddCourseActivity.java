
package com.example.mishr.scope_vit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.CourseDetails;
import com.example.mishr.scope_vit.Model.DatabaseHandler;

public class AddCourseActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtcoursename, edtcoursecredit, edtcoursecode, edtcoursefacid;
    Button btnback1, btnaddcourse;
    DatabaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        edtcoursename = (EditText) findViewById(R.id.edtcoursename);
        edtcoursecode = (EditText) findViewById(R.id.edtcoursecode);
        edtcoursecredit = (EditText) findViewById(R.id.edtcoursecredit);
        edtcoursefacid = (EditText) findViewById(R.id.edtcoursefacid);

        btnaddcourse = (Button) findViewById(R.id.btnaddcourse);
        btnback1 = (Button) findViewById(R.id.btnback1);

        databaseHandler = new DatabaseHandler(AddCourseActivity.this);


        btnaddcourse.setOnClickListener(AddCourseActivity.this);
        btnback1.setOnClickListener(AddCourseActivity.this);
    }

    private void addCourseObjectToDatabase(){

        String courseNameValue = edtcoursename.getText().toString();
        String courseCodeValue = edtcoursecode.getText().toString();
        String courseCreditValue = edtcoursecredit.getText().toString();
        String courseFacIDValue = edtcoursefacid.getText().toString();

        try{

            int courseCreditIntValue = Integer.parseInt(courseCreditValue);
            int courseFacIDIntValue = Integer.parseInt(courseFacIDValue);

            CourseDetails courseDetailsObject = new CourseDetails(0, courseNameValue, courseCodeValue, courseCreditIntValue, courseFacIDIntValue );

            databaseHandler.addCourse(courseDetailsObject);
            Toast.makeText(AddCourseActivity.this, courseDetailsObject.toString() + "This course is saved to your database", Toast.LENGTH_SHORT).show();


        }catch(Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btnaddcourse:
                addCourseObjectToDatabase();
                break;
            case R.id.btnback1:
                finish();
        }


    }
}
