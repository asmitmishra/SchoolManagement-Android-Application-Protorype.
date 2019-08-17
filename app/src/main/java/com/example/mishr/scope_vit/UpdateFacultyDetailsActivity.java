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
import com.example.mishr.scope_vit.Model.FacultyDetails;

import java.util.ArrayList;

public class UpdateFacultyDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty_details);

        databaseHandler = new DatabaseHandler(UpdateFacultyDetailsActivity.this);

        modifyUserInterface();
    }

    private void modifyUserInterface(){

        ArrayList<FacultyDetails> facultyDetailsObjects = databaseHandler.returnAllFacultyDetails();
        if(facultyDetailsObjects.size() >0){

            ScrollView scrollView = new ScrollView(UpdateFacultyDetailsActivity.this);
            GridLayout gridLayout = new GridLayout(UpdateFacultyDetailsActivity.this);
            gridLayout.setRowCount(facultyDetailsObjects.size());
            gridLayout.setColumnCount(7);

            TextView[] idTextViews = new TextView[facultyDetailsObjects.size()];
            EditText[][]edtNamesAllAttributes = new EditText[facultyDetailsObjects.size()][5];
            Button[] modifyButtons = new Button[facultyDetailsObjects.size()];
            Point screenSize = new Point();
            getWindowManager().getDefaultDisplay().getSize(screenSize);    //screensize holds the size of the user's device

            int screenWidth = screenSize.x;
            int index = 0;

            for(FacultyDetails facultyDetailsObject : facultyDetailsObjects){
                idTextViews[index] = new TextView(UpdateFacultyDetailsActivity.this);
                idTextViews[index].setGravity(Gravity.CENTER);
                idTextViews[index].setText(facultyDetailsObject.getFacultyID() + "");


                edtNamesAllAttributes[index][0] = new EditText(UpdateFacultyDetailsActivity.this);
                edtNamesAllAttributes[index][1] = new EditText(UpdateFacultyDetailsActivity.this);
                edtNamesAllAttributes[index][2] = new EditText(UpdateFacultyDetailsActivity.this);
                edtNamesAllAttributes[index][3] = new EditText(UpdateFacultyDetailsActivity.this);
                edtNamesAllAttributes[index][4] = new EditText(UpdateFacultyDetailsActivity.this);

                edtNamesAllAttributes[index][0].setText(facultyDetailsObject.getFacultyname());
                edtNamesAllAttributes[index][1].setText(facultyDetailsObject.getCabin_number());
                edtNamesAllAttributes[index][2].setText(facultyDetailsObject.getDesignation());
                edtNamesAllAttributes[index][3].setText(facultyDetailsObject.getEmailID());
                edtNamesAllAttributes[index][4].setText(facultyDetailsObject.getContact_number() + "");
                edtNamesAllAttributes[index][4].setInputType(InputType.TYPE_CLASS_NUMBER);  //user must enter only integer contact number input..

                edtNamesAllAttributes[index][0].setId(facultyDetailsObject.getFacultyID() + 10);//specified the id for each edittext..
                edtNamesAllAttributes[index][1].setId(facultyDetailsObject.getFacultyID() + 20);
                edtNamesAllAttributes[index][2].setId(facultyDetailsObject.getFacultyID() + 30);
                edtNamesAllAttributes[index][3].setId(facultyDetailsObject.getFacultyID() + 40);
                edtNamesAllAttributes[index][4].setId(facultyDetailsObject.getFacultyID() + 50);

                modifyButtons[index] = new Button(UpdateFacultyDetailsActivity.this);
                modifyButtons[index].setText("Modify");
                modifyButtons[index].setId(facultyDetailsObject.getFacultyID());
                modifyButtons[index].setOnClickListener(UpdateFacultyDetailsActivity.this);

                gridLayout.addView(idTextViews[index], (int) (screenWidth * 0.05), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNamesAllAttributes[index][0],(int)(screenWidth * 0.15), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNamesAllAttributes[index][1],(int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNamesAllAttributes[index][2],(int)(screenWidth * 0.25), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNamesAllAttributes[index][3],(int)(screenWidth * 0.15), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtNamesAllAttributes[index][4],(int)(screenWidth * 0.15), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(modifyButtons[index],(int)(screenWidth * 0.05), ViewGroup.LayoutParams.WRAP_CONTENT);


                        index++;
            }


            scrollView.addView(gridLayout);
            setContentView(scrollView);


        }

    }

    @Override
    public void onClick(View view) {

        int facultyObjectID = view.getId();

        EditText edtFacultyName = (EditText)findViewById(facultyObjectID + 10);
        EditText edtFacultyCabin = (EditText)findViewById(facultyObjectID + 20);
        EditText edtFacultyDesignation = (EditText)findViewById(facultyObjectID + 30);
        EditText edtFacultyEmail = (EditText)findViewById(facultyObjectID + 40);
        EditText edtFacultyContact = (EditText)findViewById(facultyObjectID + 50);

        String facultyNameStringValue = edtFacultyName.getText().toString();
        String facultyCabinStringValue = edtFacultyCabin.getText().toString();
        String facultyDesignationStringValue = edtFacultyDesignation.getText().toString();
        String facultyEmailStringValue = edtFacultyEmail.getText().toString();
        String facultyContactStringValue = edtFacultyContact.getText().toString();

        try{

            int facultyContactIntegerValue = Integer.parseInt(facultyContactStringValue);

            databaseHandler.modifyFacultyObject(facultyObjectID, facultyNameStringValue, facultyDesignationStringValue, facultyCabinStringValue,
                    facultyContactIntegerValue, facultyEmailStringValue);
            Toast.makeText(UpdateFacultyDetailsActivity.this, "Update successful", Toast.LENGTH_SHORT).show();

        }catch (NumberFormatException e){
                e.printStackTrace();
        }



    }
}
