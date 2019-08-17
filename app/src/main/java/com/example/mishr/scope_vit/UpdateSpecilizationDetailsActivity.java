package com.example.mishr.scope_vit;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.SpecializationDetails;

import java.util.ArrayList;

public class UpdateSpecilizationDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_specilization_details);

        databaseHandler = new DatabaseHandler(UpdateSpecilizationDetailsActivity.this);
        modifyUserInterface();

    }

    private void modifyUserInterface(){

        ArrayList<SpecializationDetails> specializationDetails = databaseHandler.returnAllSpecilizationDetails();

            if(specializationDetails.size() > 0){

                ScrollView scrollView = new ScrollView(UpdateSpecilizationDetailsActivity.this);
                GridLayout gridLayout = new GridLayout(UpdateSpecilizationDetailsActivity.this);
                gridLayout.setRowCount(specializationDetails.size());
                gridLayout.setColumnCount(5);

                TextView[] idTextViews = new TextView[specializationDetails.size()];
                EditText[][] edtAllAttributes = new EditText[specializationDetails.size()][3];
                Button[] modifyButtons = new Button[specializationDetails.size()];

                Point screenSize = new Point();
                getWindowManager().getDefaultDisplay().getSize(screenSize);

                int screenWidth = screenSize.x;
                int index = 0;

                for(SpecializationDetails specializationDetailsObject : specializationDetails) {

                    idTextViews[index] = new TextView(UpdateSpecilizationDetailsActivity.this);
                    idTextViews[index].setGravity(Gravity.CENTER);
                    idTextViews[index].setText(specializationDetailsObject.getSid() + "");

                    edtAllAttributes[index][0] = new EditText(UpdateSpecilizationDetailsActivity.this);
                    edtAllAttributes[index][1] = new EditText(UpdateSpecilizationDetailsActivity.this);
                    edtAllAttributes[index][2] = new EditText(UpdateSpecilizationDetailsActivity.this);


                    edtAllAttributes[index][0].setText(specializationDetailsObject.getSfacultyid() + "");
                    edtAllAttributes[index][0].setInputType(InputType.TYPE_CLASS_NUMBER);
                    edtAllAttributes[index][1].setText(specializationDetailsObject.getScoursecode());
                    edtAllAttributes[index][2].setText(specializationDetailsObject.getPrerequisite());

                    edtAllAttributes[index][0].setId(specializationDetailsObject.getSid() + 10);
                    edtAllAttributes[index][1].setId(specializationDetailsObject.getSid() + 20);
                    edtAllAttributes[index][2].setId(specializationDetailsObject.getSid() + 30);

                    modifyButtons[index] = new Button(UpdateSpecilizationDetailsActivity.this);
                    modifyButtons[index].setText("Modify");
                    modifyButtons[index].setId(specializationDetailsObject.getSid());
                    modifyButtons[index].setOnClickListener(UpdateSpecilizationDetailsActivity.this);

                    gridLayout.addView(idTextViews[index], (int) (screenWidth * 0.05), ViewGroup.LayoutParams.WRAP_CONTENT);
                    gridLayout.addView(edtAllAttributes[index][0], (int)(screenWidth * 0.28), ViewGroup.LayoutParams.WRAP_CONTENT);
                    gridLayout.addView(edtAllAttributes[index][1],(int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                    gridLayout.addView(edtAllAttributes[index][2],(int)(screenWidth * 0.25), ViewGroup.LayoutParams.WRAP_CONTENT);
                    gridLayout.addView(modifyButtons[index], (int)(screenWidth * 0.30),ViewGroup.LayoutParams.WRAP_CONTENT);



                    index++;


                }

                scrollView.addView(gridLayout);
                setContentView(scrollView);


            }


        }




    @Override
    public void onClick(View view) {

        int specilizationObjectID = view.getId();
        EditText edtspecilizationfacID = (EditText) findViewById(specilizationObjectID + 10);
        EditText edtspecilizationcode = (EditText) findViewById(specilizationObjectID + 20);
        EditText edtspecilizationprerequisite = (EditText) findViewById(specilizationObjectID + 30);

        String edtspecilizationfacIDStringValue = edtspecilizationfacID.getText().toString();
        String edtspecilizationcodeStringValue = edtspecilizationcode.getText().toString();
        String edtspecilizationprerequisiteStringValue = edtspecilizationprerequisite.getText().toString();

        try {

            int edtspecilizationfacIDIntegerValue = Integer.parseInt(edtspecilizationfacIDStringValue);
            databaseHandler.modifySpecilizationObject(specilizationObjectID, edtspecilizationfacIDIntegerValue, edtspecilizationcodeStringValue
                    , edtspecilizationprerequisiteStringValue);
            Toast.makeText(UpdateSpecilizationDetailsActivity.this, "Update Successful", Toast.LENGTH_SHORT).show();


        } catch (NumberFormatException e) {


        }


    }
}
