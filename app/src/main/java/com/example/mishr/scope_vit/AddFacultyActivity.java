package com.example.mishr.scope_vit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.FacultyDetails;

public class AddFacultyActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtCabin,edtName,edtDesignation,edtemail,edtcontact_num;
    Button btnAddFaculty,btnGoBack;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);

        edtName = (EditText)findViewById(R.id.edtName);
        edtCabin = (EditText)findViewById(R.id.edtCabin);
        edtDesignation = (EditText)findViewById(R.id.edtDesignation);
        edtemail = (EditText)findViewById(R.id.edtemail);
        edtcontact_num = (EditText)findViewById(R.id.edtcontact_num);

        btnAddFaculty = (Button) findViewById(R.id.btnAddFaculty);
        btnGoBack = (Button) findViewById(R.id.btnGoBack);

        btnAddFaculty.setOnClickListener(AddFacultyActivity.this);
        btnGoBack.setOnClickListener(AddFacultyActivity.this);

        databaseHandler = new DatabaseHandler(AddFacultyActivity.this);
    }


    private void addFacultyObjectToDatabase(){

        String nameValue = edtName.getText().toString();
        String cabinValue = edtCabin.getText().toString();
        String designationValue = edtDesignation.getText().toString();
        String emailValue = edtemail.getText().toString();
        String contact_numValue = edtcontact_num.getText().toString();

        try{

            Integer contact_Int_num_Value = Integer.parseInt(contact_numValue);

            FacultyDetails facultyDetailsObject = new FacultyDetails(0,nameValue,designationValue,cabinValue,
                    contact_Int_num_Value,emailValue);
            databaseHandler.addFaculty(facultyDetailsObject);
            Toast.makeText(AddFacultyActivity.this, facultyDetailsObject + "Your information is added to the database", Toast.LENGTH_LONG).show();

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btnAddFaculty:
                addFacultyObjectToDatabase();
                break;

            case R.id.btnGoBack:
                this.finish();
                break;

        }

    }
}
