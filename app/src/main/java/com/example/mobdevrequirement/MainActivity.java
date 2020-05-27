package com.example.mobdevrequirement;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobdevrequirement.UI.Activity2nd;

public class MainActivity extends AppCompatActivity {

    private TextView tvParagraph;
    private EditText etInput;
    private Button btnMove;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvParagraph = findViewById(R.id.tvParagraph);
        etInput = findViewById(R.id.etInput);
        btnMove = findViewById(R.id.btnMove);

        tvParagraph.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tvParagraph.setText(s);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2nd.class);
                intent.putExtra("prevtext",etInput.getText().toString());
                startActivity(intent);
            }
        });
    }
}
