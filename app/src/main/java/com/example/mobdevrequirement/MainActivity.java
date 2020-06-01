package com.example.mobdevrequirement;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobdevrequirement.UI.Activity.LoginActivity;
import com.example.mobdevrequirement.app.UserSessionManager;

public class MainActivity extends AppCompatActivity {

    private TextView tvUN;
    private Button btnLogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUN = findViewById(R.id.tvUN);
        btnLogOut = findViewById(R.id.btnLogOut);

        tvUN.setText(UserSessionManager.getInstance(this).getUsername());

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSessionManager.getInstance(MainActivity.this).setLogout();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
