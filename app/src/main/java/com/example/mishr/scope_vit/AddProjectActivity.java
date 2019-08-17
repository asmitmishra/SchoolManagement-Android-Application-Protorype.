
package com.example.mishr.scope_vit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.ResearchProjectsDetails;
import com.example.mishr.scope_vit.Model.SpecializationDetails;

public class AddProjectActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtprojectid, edtresearchfield, edtdipid, edtcCode;
    Button btnaddproject, btngoprevious;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);


        databaseHandler = new DatabaseHandler(AddProjectActivity.this);
        edtprojectid = (EditText) findViewById(R.id.edtprojectid);
        edtresearchfield = (EditText) findViewById(R.id.edtresearchfield);
        edtdipid = (EditText) findViewById(R.id.edtdipid);
        edtcCode = (EditText) findViewById(R.id.edtcCode);
        btnaddproject = (Button) findViewById(R.id.btnaddproject);
        btngoprevious = (Button) findViewById(R.id.btngoprevious);

        btnaddproject.setOnClickListener(AddProjectActivity.this);
        btngoprevious.setOnClickListener(AddProjectActivity.this);

    }


    private void addProjectObjectToDatabase(){

        String projectidValue = edtprojectid.getText().toString();
        String researchfieldValue = edtresearchfield.getText().toString();
        String edtdipValue = edtdipid.getText().toString();
        String edtcodeValue = edtcCode.getText().toString();
        ResearchProjectsDetails researchProjectsDetails = new ResearchProjectsDetails(0, projectidValue,researchfieldValue,edtdipValue,edtcodeValue);
        databaseHandler.addProject(researchProjectsDetails);
        Toast.makeText(AddProjectActivity.this, "Project Added Successfully..", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.btnaddproject:
                addProjectObjectToDatabase();
                break;
            case R.id.btngoprevious:
                finish();
                break;


        }


    }
}
