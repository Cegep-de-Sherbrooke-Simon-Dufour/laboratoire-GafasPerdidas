package com.example.lab6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button add = findViewById(R.id.button);
        Button cancel = findViewById(R.id.button2);

        add.setOnClickListener(addOnClickListener);
        cancel.setOnClickListener(cancelOnClickListener);
    }

    View.OnClickListener addOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] newUser  = new String[]{
                    ((EditText)(findViewById(R.id.editTextText))).getText().toString()
                    ,   ((EditText)(findViewById(R.id.editTextTextEmailAddress))).getText().toString()
            };

            Intent intent = new Intent();
            intent.putExtra("newUser", newUser);

            setResult(RESULT_OK, intent);
            finish();
        }
    };

    View.OnClickListener cancelOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] newUser  = new String[]{"",""};

            Intent intent = new Intent();
            intent.putExtra("newUser", newUser);

            setResult(RESULT_OK, intent);
            finish();
        }
    };
}