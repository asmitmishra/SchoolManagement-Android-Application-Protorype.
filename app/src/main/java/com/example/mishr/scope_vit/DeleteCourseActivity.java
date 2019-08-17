package com.example.mishr.scope_vit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.CourseDetails;
import com.example.mishr.scope_vit.Model.DatabaseHandler;

import java.util.ArrayList;

public class DeleteCourseActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener{

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_course);

        databaseHandler = new DatabaseHandler(DeleteCourseActivity.this);
        updateTheUserInterface();


    }

    private void updateTheUserInterface(){

        ArrayList<CourseDetails> allCourseObjects = databaseHandler.returnAllCourseDetails();
        RelativeLayout relativeLayout = new RelativeLayout(DeleteCourseActivity.this);
        ScrollView scrollView = new ScrollView(DeleteCourseActivity.this);
        RadioGroup radioGroup = new RadioGroup(DeleteCourseActivity.this);

        for(CourseDetails courseDetails : allCourseObjects){

            RadioButton currentRadioButton = new RadioButton(DeleteCourseActivity.this);
            currentRadioButton.setId(courseDetails.getPid());
            currentRadioButton.setText(courseDetails.toString());
            radioGroup.addView(currentRadioButton);


        }

        radioGroup.setOnCheckedChangeListener(DeleteCourseActivity.this);
        Button btnBack1 = new Button(DeleteCourseActivity.this);
        btnBack1.setText("Go Back");
        btnBack1.setOnClickListener(DeleteCourseActivity.this);

        scrollView.addView(radioGroup);
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0,0,0,70);

        relativeLayout.addView(btnBack1, buttonParams);
        ScrollView.LayoutParams scrollViewParams = new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT
        );

        relativeLayout.addView(scrollView, scrollViewParams);

        setContentView(relativeLayout);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        databaseHandler.deleteCourseObjectFromDatabaseByID(checkedId);
        Toast.makeText(DeleteCourseActivity.this, "This Course is removed from your list", Toast.LENGTH_SHORT).show();
        updateTheUserInterface();

    }

    @Override
    public void onClick(View v) {

        finish();

    }
}
