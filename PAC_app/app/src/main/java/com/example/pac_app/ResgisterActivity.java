package com.example.pac_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pac_app.model.Users;

public class ResgisterActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private EditText email;
    private EditText name;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister);

        initializeViews();

        insertData();
    }

    protected void initializeViews(){
        userName = findViewById(R.id.usernameText);
        password = findViewById(R.id.passwordText);
        email = findViewById(R.id.emailText);
        name = findViewById(R.id.fullNameText);
        button = findViewById(R.id.registerButton);
    }

    protected void insertData(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users user = new Users(0, userName.getText().toString(), password.getText().toString(), email.getText().toString(), name.getText().toString());
                AppDatabase.getInstance(ResgisterActivity.this).getUsersDao().insertUser(user);

                startActivity(new Intent(ResgisterActivity.this, LoginActivity.class));
            }
        });
    }
}