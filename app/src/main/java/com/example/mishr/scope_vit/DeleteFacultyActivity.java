package com.example.mishr.scope_vit;

import android.support.annotation.IdRes;
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

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.FacultyDetails;

import java.util.ArrayList;

public class DeleteFacultyActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener{

    private DatabaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_faculty);

        databaseHandler = new DatabaseHandler(DeleteFacultyActivity.this);
        updateTheUserInterface();
    }

    private void updateTheUserInterface(){

        ArrayList<FacultyDetails> allFacultyObjects = databaseHandler.returnAllFacultyDetails();
        RelativeLayout relativeLayout = new RelativeLayout(DeleteFacultyActivity.this);
        ScrollView scrollView = new ScrollView(DeleteFacultyActivity.this);
        RadioGroup radioGroup = new RadioGroup(DeleteFacultyActivity.this);

        for(FacultyDetails facultyDetails : allFacultyObjects){

            RadioButton currentRadioButton = new RadioButton(DeleteFacultyActivity.this);
            currentRadioButton.setId(facultyDetails.getFacultyID());
            currentRadioButton.setText(facultyDetails.toString());
            radioGroup.addView(currentRadioButton);

        }

        radioGroup.setOnCheckedChangeListener(DeleteFacultyActivity.this);

        Button btnBack = new Button(DeleteFacultyActivity.this);
        btnBack.setText("Go Back");
        btnBack.setOnClickListener(DeleteFacultyActivity.this);

        scrollView.addView(radioGroup);

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0, 0, 0 ,70);

        relativeLayout.addView(btnBack, buttonParams);
        ScrollView.LayoutParams scrollViewParams = new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.MATCH_PARENT
        );

        relativeLayout.addView(scrollView,scrollViewParams);


        setContentView(relativeLayout);


    }

    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){

        databaseHandler.deleteFacultyObjectFromDatabaseByID(checkedId);
        Toast.makeText(DeleteFacultyActivity.this, "The selected faculty details is removed...", Toast.LENGTH_SHORT).show();
        updateTheUserInterface();

    }

    @Override
    public void onClick(View v) {
        finish();  //delete activity class gonna finish...// activity below this activity is gonna shown to the user..
    }
}
