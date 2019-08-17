package com.example.mishr.scope_vit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.StudentDetails;

public class AddStudentActivity extends AppCompatActivity {

    DatabaseHandler databaseHandler;
    EditText edtstudentname, edtstudentid, edtaddress, edtdob, edtjoiningdate, edtprogramenrolled, edtcontactnumber;
    Button btnADD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        edtstudentname = (EditText) findViewById(R.id.edtstudentname);
        edtstudentid = (EditText)findViewById(R.id.edtstudentid);
        edtaddress = (EditText)findViewById(R.id.edtaddress);
        edtdob = (EditText)findViewById(R.id.edtdob);
        edtjoiningdate = (EditText) findViewById(R.id.edtjoiningdate);
        edtprogramenrolled = (EditText)findViewById(R.id.edtprogramenrolled);
        edtcontactnumber = (EditText)findViewById(R.id.edtcontactnumber);

        btnADD = (Button)findViewById(R.id.btnADD);
        databaseHandler = new DatabaseHandler(AddStudentActivity.this);

    }

    private void addStudentObjectToDatabase(){

        String nameValue = edtstudentname.getText().toString();
        String idValue = edtstudentid.getText().toString();
        String addressValue = edtaddress.getText().toString();
        String dobValue = edtdob.getText().toString();
        String joinValue = edtjoiningdate.getText().toString();
        String programValue = edtprogramenrolled.getText().toString();
        String contactValue = edtcontactnumber.getText().toString();

        try{

            int idintValue = Integer.parseInt(idValue);
            int contactintValue = Integer.parseInt(contactValue);
            StudentDetails studentDetailsObject = new StudentDetails();


        }catch(Exception e){

            e.printStackTrace();

        }


    }


}
