package com.example.mishr.scope_vit;

import android.graphics.Point;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.CourseDetails;
import com.example.mishr.scope_vit.Model.DatabaseHandler;

import org.w3c.dom.Text;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLDisplay;

public class UpdateCourseDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course_details);

        databaseHandler = new DatabaseHandler(UpdateCourseDetailsActivity.this);

        modifyUserInterface();


    }

    private void modifyUserInterface(){

        ArrayList<CourseDetails> courseObjects = databaseHandler.returnAllCourseDetails();
        if (courseObjects.size() > 0){

            ScrollView scrollView = new ScrollView(UpdateCourseDetailsActivity.this);
            GridLayout gridLayout = new GridLayout(UpdateCourseDetailsActivity.this);
            gridLayout.setRowCount(courseObjects.size());
            gridLayout.setColumnCount(6);

            TextView[] idTextViews = new TextView[courseObjects.size()];
            EditText[][] edtInputAllAttributes = new EditText[courseObjects.size()][4];
            Button[] modifyButtons = new Button[courseObjects.size()];

            Point screenSize = new Point();
            getWindowManager().getDefaultDisplay().getSize(screenSize);

            int screenWidth = screenSize.x;
            int index = 0;

            for (CourseDetails courseDetailsObject : courseObjects){

                idTextViews[index] = new TextView(UpdateCourseDetailsActivity.this);
                idTextViews[index].setGravity(Gravity.CENTER);
                idTextViews[index].setText(courseDetailsObject.getPid() + "");

                edtInputAllAttributes[index][0] = new EditText(UpdateCourseDetailsActivity.this);
                edtInputAllAttributes[index][1] = new EditText(UpdateCourseDetailsActivity.this);
                edtInputAllAttributes[index][2] = new EditText(UpdateCourseDetailsActivity.this);
                edtInputAllAttributes[index][3] = new EditText(UpdateCourseDetailsActivity.this);

                edtInputAllAttributes[index][0].setText(courseDetailsObject.getCourseName());
                edtInputAllAttributes[index][1].setText(courseDetailsObject.getCourseCode());
                edtInputAllAttributes[index][2].setText(courseDetailsObject.getCourseCredit() + "");  //INTEGERS INPUT TO BE CONVERTED TO STRING
                edtInputAllAttributes[index][3].setText(courseDetailsObject.getCourseFacID() + "");
                edtInputAllAttributes[index][2].setInputType(InputType.TYPE_CLASS_NUMBER);  //TO MAKE SURE INTEGER VALUE  IS ENTERED
                edtInputAllAttributes[index][3].setInputType(InputType.TYPE_CLASS_NUMBER);

                edtInputAllAttributes[index][0].setId(courseDetailsObject.getPid() + 10);
                edtInputAllAttributes[index][1].setId(courseDetailsObject.getPid() + 20);
                edtInputAllAttributes[index][2].setId(courseDetailsObject.getPid() + 30);
                edtInputAllAttributes[index][3].setId(courseDetailsObject.getPid() + 40);

                modifyButtons[index] = new Button(UpdateCourseDetailsActivity.this);
                modifyButtons[index].setText("Modify");
                modifyButtons[index].setId(courseDetailsObject.getPid());
                modifyButtons[index].setOnClickListener(UpdateCourseDetailsActivity.this);

                gridLayout.addView(idTextViews[index], (int)(screenWidth * 0.05), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtInputAllAttributes[index][0], (int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtInputAllAttributes[index][1], (int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtInputAllAttributes[index][2], (int)(screenWidth * 0.05), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtInputAllAttributes[index][3], (int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(modifyButtons[index],(int)(screenWidth * 0.35),ViewGroup.LayoutParams.WRAP_CONTENT);


                index++;
            }

            scrollView.addView(gridLayout);
            setContentView(scrollView);



        }

    }

    @Override
    public void onClick(View view) {

        int courseObjectID = view.getId();

        EditText edtCourseName = (EditText)findViewById(courseObjectID + 10);
        EditText edtCourseCode = (EditText)findViewById(courseObjectID + 20);
        EditText edtCourseCredit = (EditText)findViewById(courseObjectID + 30);
        EditText edtCourseFacID = (EditText)findViewById(courseObjectID + 40);

        String courseNameStringValue = edtCourseName.getText().toString();
        String courseCodeStringValue = edtCourseCode.getText().toString();
        String courseCreditStringValue = edtCourseCredit.getText().toString();
        String courseFacIDStringValue = edtCourseFacID.getText().toString();

        try{
            int courseCreditIntValue = Integer.parseInt(courseCreditStringValue);
            int courseFacIDIntValue = Integer.parseInt(courseFacIDStringValue);

            databaseHandler.modifyCourseObject(courseObjectID, courseNameStringValue, courseCodeStringValue , courseCreditIntValue,courseFacIDIntValue );

            Toast.makeText(UpdateCourseDetailsActivity.this, "Update Successfull", Toast.LENGTH_SHORT).show();

        }catch(NumberFormatException e){
            e.printStackTrace();
        }

        ;

    }
}
