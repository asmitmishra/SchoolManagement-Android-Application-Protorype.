
package com.example.mishr.scope_vit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.DepartmentDetails;

public class AddDepartmentActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtdepartmentName, edtdepartmentID, edtlocation;
    Button btnaddDepartment, btnback2;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_department);

        edtdepartmentName = (EditText) findViewById(R.id.edtdepartmentName);
        edtdepartmentID = (EditText) findViewById(R.id.edtdepartmentID);
        edtlocation = (EditText) findViewById(R.id.edtlocation);

        btnaddDepartment = (Button) findViewById(R.id.btnaddDepartment);
        btnback2 = (Button) findViewById(R.id.btnback2);
        databaseHandler = new DatabaseHandler(AddDepartmentActivity.this);

        btnaddDepartment.setOnClickListener(AddDepartmentActivity.this);
        btnback2.setOnClickListener(AddDepartmentActivity.this);

    }

    private void addDepartmentObjectToDatabase(){

        String departmentNameValue = edtdepartmentName.getText().toString();
        String departmentIDValue = edtdepartmentID.getText().toString();
        String departmentLocationValue = edtlocation.getText().toString();

        DepartmentDetails departmentDetails = new DepartmentDetails(0, departmentNameValue, departmentIDValue, departmentLocationValue);
        databaseHandler.addDepartment(departmentDetails);
        Toast.makeText(AddDepartmentActivity.this, "Department added", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.btnaddDepartment:
                addDepartmentObjectToDatabase();
                break;
            case R.id.btnback2:
                finish();


        }




    }
}
