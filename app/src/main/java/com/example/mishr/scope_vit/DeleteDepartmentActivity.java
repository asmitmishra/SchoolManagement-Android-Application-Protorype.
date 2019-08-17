
package com.example.mishr.scope_vit;

import android.provider.MediaStore;
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
import com.example.mishr.scope_vit.Model.DepartmentDetails;

import java.util.ArrayList;

public class DeleteDepartmentActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_department_details);

        databaseHandler = new DatabaseHandler(DeleteDepartmentActivity.this);
        updateTheUserInterface();

    }

    private void updateTheUserInterface(){

        ArrayList<DepartmentDetails> allDepartmentObjects = databaseHandler.returnAllDepartmentDetails();
        RelativeLayout relativeLayout = new RelativeLayout(DeleteDepartmentActivity.this);
        ScrollView scrollView = new ScrollView(DeleteDepartmentActivity.this);
        RadioGroup radioGroup = new RadioGroup(DeleteDepartmentActivity.this);

        for(DepartmentDetails departmentDetails : allDepartmentObjects){

            RadioButton currentRadioButton = new RadioButton(DeleteDepartmentActivity.this);
            currentRadioButton.setId(departmentDetails.getPid());
            currentRadioButton.setText(departmentDetails.toString());
            radioGroup.addView(currentRadioButton);

        }

        radioGroup.setOnCheckedChangeListener(DeleteDepartmentActivity.this);

        Button btnBack = new Button(DeleteDepartmentActivity.this);
        btnBack.setText("Back");
        btnBack.setOnClickListener(DeleteDepartmentActivity.this);

        scrollView.addView(radioGroup);

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0,0,0,70);

        relativeLayout.addView(btnBack, buttonParams);
        ScrollView.LayoutParams scrollViewParams = new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.MATCH_PARENT);
        relativeLayout.addView(scrollView, scrollViewParams);


        setContentView(relativeLayout);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        databaseHandler.deleteDepartmentObjectFromDatabaseByID(checkedId);
        Toast.makeText(DeleteDepartmentActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
        updateTheUserInterface();

    }


    @Override
    public void onClick(View v) {
        finish();
    }


}
