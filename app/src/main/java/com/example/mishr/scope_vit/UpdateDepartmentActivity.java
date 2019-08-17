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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mishr.scope_vit.Model.DatabaseHandler;
import com.example.mishr.scope_vit.Model.DepartmentDetails;

import java.util.ArrayList;

public class UpdateDepartmentActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_department);

        databaseHandler = new DatabaseHandler(UpdateDepartmentActivity.this);

        modifyUserInterface();



    }

    private void modifyUserInterface(){

        ArrayList<DepartmentDetails> departmentObjects = databaseHandler.returnAllDepartmentDetails();
        if(departmentObjects.size() > 0){

            ScrollView scrollView = new ScrollView(UpdateDepartmentActivity.this);
            GridLayout gridLayout = new GridLayout(UpdateDepartmentActivity.this);
            gridLayout.setRowCount(departmentObjects.size());
            gridLayout.setColumnCount(5);

            TextView[] idTextViews = new TextView[departmentObjects.size()];
            EditText[][] edtAllAttributes = new EditText[departmentObjects.size()][3];
            Button[] modifyButtons = new Button[departmentObjects.size()];

            Point screenSize = new Point();
            getWindowManager().getDefaultDisplay().getSize(screenSize);

            int screenWidth = screenSize.x;
            int index = 0;

            for(DepartmentDetails departmentDetailsObject : departmentObjects){

                idTextViews[index] = new TextView(UpdateDepartmentActivity.this);
                idTextViews[index].setGravity(Gravity.CENTER);
                idTextViews[index].setText(departmentDetailsObject.getPid() + "");


                edtAllAttributes[index][0] = new EditText(UpdateDepartmentActivity.this);
                edtAllAttributes[index][1] = new EditText(UpdateDepartmentActivity.this);
                edtAllAttributes[index][2] = new EditText(UpdateDepartmentActivity.this);

                edtAllAttributes[index][0].setText(departmentDetailsObject.getDeptname());
                edtAllAttributes[index][1].setText(departmentDetailsObject.getDeptid());
                edtAllAttributes[index][2].setText(departmentDetailsObject.getLocation());


                edtAllAttributes[index][0].setId(departmentDetailsObject.getPid() + 10);
                edtAllAttributes[index][1].setId(departmentDetailsObject.getPid() + 20);
                edtAllAttributes[index][2].setId(departmentDetailsObject.getPid() + 30);

                modifyButtons[index] = new Button(UpdateDepartmentActivity.this);
                modifyButtons[index].setText("Modify");
                modifyButtons[index].setId(departmentDetailsObject.getPid());
                modifyButtons[index].setOnClickListener(UpdateDepartmentActivity.this);

                gridLayout.addView(idTextViews[index], (int)(screenWidth * 0.05), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtAllAttributes[index][0], (int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT );
                gridLayout.addView(edtAllAttributes[index][1],(int)(screenWidth * 0.20), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(edtAllAttributes[index][2],(int)(screenWidth * 0.22), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(modifyButtons[index],(int)(screenWidth * 0.30), ViewGroup.LayoutParams.WRAP_CONTENT);


                index++;

            }


            scrollView.addView(gridLayout);
            setContentView(scrollView);
        }


    }

    @Override
    public void onClick(View view) {
        int departmentObjectID = view.getId();
        EditText edtDepartmentName = (EditText) findViewById(departmentObjectID + 10);
        EditText edtDepartmentID = (EditText) findViewById(departmentObjectID + 20);
        EditText edtDepartmentLocation = (EditText) findViewById(departmentObjectID + 30);

        String edtDepartmentNameStringValue = edtDepartmentName.getText().toString();
        String edtDepartmentIDStringValue = edtDepartmentID.getText().toString();
        String edtDepartmentLocationStringValue = edtDepartmentLocation.getText().toString();

        databaseHandler.modifyDepartmentObject(departmentObjectID, edtDepartmentNameStringValue, edtDepartmentIDStringValue, edtDepartmentLocationStringValue);
        Toast.makeText(UpdateDepartmentActivity.this, "update Successfull", Toast.LENGTH_SHORT).show();

    }
}
