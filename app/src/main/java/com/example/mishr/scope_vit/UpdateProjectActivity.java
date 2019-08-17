package com.example.mishr.scope_vit;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.ResearchProjectsDetails;

import java.util.ArrayList;

public class UpdateProjectActivity extends AppCompatActivity implements View.OnClickListener{

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_project);

        databaseHandler = new DatabaseHandler(UpdateProjectActivity.this);


        modifyUserInterface();


    }


    private void modifyUserInterface(){

        ArrayList<ResearchProjectsDetails> researchProjectsObjects = databaseHandler.returnAllProjectDetails();
        if(researchProjectsObjects.size() > 0){

            ScrollView scrollView = new ScrollView(UpdateProjectActivity.this);
            GridLayout gridLayout = new GridLayout(UpdateProjectActivity.this);
            gridLayout.setRowCount(researchProjectsObjects.size());
            gridLayout.setColumnCount(6);

            TextView[] idTextViews = new TextView[researchProjectsObjects.size()];
            EditText[][] edtAllAttributes = new EditText[researchProjectsObjects.size()][4];
            Button[] modifyButtons = new Button[researchProjectsObjects.size()];

            Point screenSize = new Point();
            getWindowManager().getDefaultDisplay().getSize(screenSize);

            int screenWidth = screenSize.x;
            int index = 0;

            for(ResearchProjectsDetails researchProjectsObject : researchProjectsObjects){

                idTextViews[index] = new TextView(UpdateProjectActivity.this);
                idTextViews[index].setGravity(Gravity.CENTER);
                idTextViews[index].setText(researchProjectsObject.getPpid() + "");
                edtAllAttributes[index][0] = new EditText(UpdateProjectActivity.this);
                edtAllAttributes[index][1] = new EditText(UpdateProjectActivity.this);
                edtAllAttributes[index][2] = new EditText(UpdateProjectActivity.this);
                edtAllAttributes[index][3] = new EditText(UpdateProjectActivity.this);

                edtAllAttributes[index][0].setText(researchProjectsObject.getProjectID());
                edtAllAttributes[index][1].setText(researchProjectsObject.getFieldofResearch());
                edtAllAttributes[index][2].setText(researchProjectsObject.getDepartmentID());
                edtAllAttributes[index][3].setText(researchProjectsObject.getCourseCode());

                edtAllAttributes[index][0].setId(researchProjectsObject.getPpid() + 10);
                edtAllAttributes[index][1].setId(researchProjectsObject.getPpid() + 20);
                edtAllAttributes[index][2].setId(researchProjectsObject.getPpid() + 30);
                edtAllAttributes[index][3].setId(researchProjectsObject.getPpid() + 40);

                modifyButtons[index] = new Button(UpdateProjectActivity.this);
                modifyButtons[index].setText("Modify");
                modifyButtons[index].setId(researchProjectsObject.getPpid());
                modifyButtons[index].setOnClickListener(UpdateProjectActivity.this);

                gridLayout.addView(idTextViews[index], (int)(screenWidth * 0.05), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtAllAttributes[index][0], (int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtAllAttributes[index][1], (int)(screenWidth * 0.15), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtAllAttributes[index][2], (int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtAllAttributes[index][3], (int)(screenWidth * 0.18), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(modifyButtons[index], (int)(screenWidth * 0.35), ViewGroup.LayoutParams.WRAP_CONTENT);

                index++;


            }

            scrollView.addView(gridLayout);
            setContentView(scrollView);


        }


    }

    @Override
    public void onClick(View view) {

        int projectObjectID = view.getId();

        EditText edtprojectID = (EditText) findViewById(projectObjectID + 10);
        EditText edtFieldID = (EditText) findViewById(projectObjectID + 20);
        EditText edtdepartmenTID = (EditText) findViewById(projectObjectID + 30);
        EditText edtcourseCodeID = (EditText) findViewById(projectObjectID + 40);

        String projectIDStringValue = edtprojectID.getText().toString();
        String FieldIDStringValue = edtFieldID.getText().toString();
        String departmentIDStringValue = edtdepartmenTID.getText().toString();
        String courseCodeStringValue = edtcourseCodeID.getText().toString();

        databaseHandler.modifyProjectObject(projectObjectID,projectIDStringValue,FieldIDStringValue,departmentIDStringValue,courseCodeStringValue);
        Toast.makeText(UpdateProjectActivity.this, "Update Successful", Toast.LENGTH_SHORT).show();




    }
}
