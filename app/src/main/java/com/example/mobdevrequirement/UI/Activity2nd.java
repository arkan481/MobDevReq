package com.example.mobdevrequirement.UI;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobdevrequirement.R;

public class Activity2nd extends AppCompatActivity {

    private TextView tvShow;
    private String prevText;
    private Button btnBack;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2nd);

        Intent intent = getIntent();
        prevText = intent.getStringExtra("prevtext");

        tvShow = findViewById(R.id.tvShow);
        btnBack = findViewById(R.id.btnBack);

        tvShow.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        tvShow.setText(prevText);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
