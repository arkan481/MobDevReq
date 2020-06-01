package com.example.mobdevrequirement.UI.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobdevrequirement.R;
import com.example.mobdevrequirement.model.UserModel;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    private Button btnSignUp;
    private EditText etUN,etPW;
    private LinearLayout lrLogin;

    private ArrayList<UserModel> userModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignUp = findViewById(R.id.btnSignUp);
        etPW = findViewById(R.id.etPWSign);
        etUN = findViewById(R.id.etUNSign);
        lrLogin = findViewById(R.id.lrLogin);

        Intent intent = getIntent();
        userModels = intent.getParcelableArrayListExtra("usermodel");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUN.getText().toString().isEmpty()||etPW.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpActivity.this,"Please fill in all the necessary field",Toast.LENGTH_SHORT).show();
                }else {
                    userModels.add(new UserModel(etUN.getText().toString(),etPW.getText().toString()));
                    Toast.makeText(SignUpActivity.this,"user created",Toast.LENGTH_SHORT).show();
                    Intent resultIntent = new Intent();
                    resultIntent.putParcelableArrayListExtra("usermodel",userModels);
                    setResult(RESULT_OK,resultIntent);
                    finish();
                }
            }
        });

        lrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
