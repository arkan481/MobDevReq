package com.example.mobdevrequirement.UI.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mobdevrequirement.MainActivity;
import com.example.mobdevrequirement.R;
import com.example.mobdevrequirement.app.UserSessionManager;
import com.example.mobdevrequirement.model.UserModel;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    private EditText etUN,etPW;
    private LinearLayout lrSignUp;

    private ArrayList<UserModel> userModels;

    private final static int SIGNUPREQUEST = 1020;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        etUN = findViewById(R.id.etUN);
        etPW = findViewById(R.id.etPW);
        btnSignIn = findViewById(R.id.btnSignIn);
        lrSignUp = findViewById(R.id.lrSignUp);

        if (UserSessionManager.getInstance(this).isLoggedin()) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        if (userModels==null) {
            userModels = new ArrayList<>();
        }

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck(login());
            }
        });

        lrSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                intent.putParcelableArrayListExtra("usermodel",userModels);
                startActivityForResult(intent,SIGNUPREQUEST);
            }
        });


    }

    private void loginCheck(boolean login) {
        if (login==false) {
            Toast.makeText(this,"Wrong username or password",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
            UserSessionManager.getInstance(LoginActivity.this).setLogin(etUN.getText().toString());
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean login() {
        boolean login = false;
        for (int i = 0; i < userModels.size(); i++) {
            if (etUN.getText().toString().equals(userModels.get(i).getUsername())&&etPW.getText().toString().equals(userModels.get(i).getPassword())) {
                return true;
            }
        }
        return login;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SIGNUPREQUEST :
                if (resultCode==RESULT_OK) {
                    userModels = data.getParcelableArrayListExtra("usermodel");
                }
                break;
        }
    }
}
