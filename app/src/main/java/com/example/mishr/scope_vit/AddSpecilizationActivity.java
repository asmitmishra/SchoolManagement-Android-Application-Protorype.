package com.example.mishr.scope_vit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.SpecializationDetails;

public class AddSpecilizationActivity extends AppCompatActivity implements View.OnClickListener{

    private DatabaseHandler databaseHandler;


    EditText edtsfacid, edtscoursecode, edtsprerequisite;
    Button btnaddspecilization, btngoback3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_specilization);

        edtsfacid = (EditText) findViewById(R.id.edtsfacid);
        edtscoursecode = (EditText) findViewById(R.id.edtscoursecode);
        edtsprerequisite = (EditText) findViewById(R.id.edtsprerequisite);
        btnaddspecilization = (Button) findViewById(R.id.btnaddspecilization);
        btngoback3 = (Button) findViewById(R.id.btngoback3);

        databaseHandler = new DatabaseHandler(AddSpecilizationActivity.this);

        btnaddspecilization.setOnClickListener(AddSpecilizationActivity.this);
        btngoback3.setOnClickListener(AddSpecilizationActivity.this);



    }

    private void addSpecilizationObjectToDatabase(){

        String sfacIDValue = edtsfacid.getText().toString();
        String scoursecodeValue = edtscoursecode.getText().toString();
        String sprerequisiteValue = edtsprerequisite.getText().toString();

        try{

            int sfacIDIntValue = Integer.parseInt(sfacIDValue);
            SpecializationDetails specializationDetails = new SpecializationDetails(0, sfacIDIntValue, scoursecodeValue, sprerequisiteValue);

            databaseHandler.addSpecialization(specializationDetails);
            Toast.makeText(AddSpecilizationActivity.this, "Specilization Course Added ", Toast.LENGTH_SHORT).show();



        }catch(Exception e){

            e.printStackTrace();

        }



    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.btnaddspecilization:
                addSpecilizationObjectToDatabase();
                break;
            case R.id.btngoback3:
                finish();
                break;


        }

    }
}
