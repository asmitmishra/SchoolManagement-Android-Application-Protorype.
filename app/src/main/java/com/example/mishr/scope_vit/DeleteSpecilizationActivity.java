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
import com.example.mishr.scope_vit.Model.SpecializationDetails;

import java.util.ArrayList;

public class DeleteSpecilizationActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_specilization);

        databaseHandler = new DatabaseHandler(DeleteSpecilizationActivity.this);


        updateTheUserInterface();

    }

    private void updateTheUserInterface(){

        ArrayList<SpecializationDetails> allSpecilizationObjects = databaseHandler.returnAllSpecilizationDetails();
        RelativeLayout relativeLayout = new RelativeLayout(DeleteSpecilizationActivity.this);
        ScrollView scrollView = new ScrollView(DeleteSpecilizationActivity.this);
        RadioGroup radioGroup = new RadioGroup(DeleteSpecilizationActivity.this);

        for (SpecializationDetails specializationDetails : allSpecilizationObjects){

            RadioButton currentRadioButton = new RadioButton(DeleteSpecilizationActivity.this);
            currentRadioButton.setId(specializationDetails.getSid());
            currentRadioButton.setText(specializationDetails.toString());
            radioGroup.addView(currentRadioButton);

        }

        radioGroup.setOnCheckedChangeListener(DeleteSpecilizationActivity.this);
        Button btnback4 = new Button(DeleteSpecilizationActivity.this);
        btnback4.setText("Back");
        btnback4.setOnClickListener(DeleteSpecilizationActivity.this);

        scrollView.addView(radioGroup);

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0,0,0,70);

        relativeLayout.addView(btnback4, buttonParams);

        ScrollView.LayoutParams scrollViewParams = new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT
        );

        relativeLayout.addView(scrollView, scrollViewParams);

        setContentView(relativeLayout);



    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        databaseHandler.deleteSpecilizationObjectFromDatabaseByID(checkedId);
        Toast.makeText(DeleteSpecilizationActivity.this, "Delete Successful", Toast.LENGTH_SHORT).show();
        updateTheUserInterface();

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
