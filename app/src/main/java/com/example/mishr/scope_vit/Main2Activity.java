package com.example.mishr.scope_vit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private EditText Name, Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Name = (EditText)findViewById(R.id.edtInputName);
        Password = (EditText)findViewById(R.id.edtPassword);
        Info = (TextView)findViewById(R.id.edtAtempts);
        Login = (Button)findViewById(R.id.btnProceed);
        Info.setText("Number of Attempts Remaining:5");

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });


    }

    private void validate(String username, String userPassoword){

        if((username.equals("SYSTEM"))&&(userPassoword.equals("1234"))){
            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("Number of Attempts Remaining" + String.valueOf(counter));
            if(counter==0){
                Login.setEnabled(false);
            }
        }

    }


}
