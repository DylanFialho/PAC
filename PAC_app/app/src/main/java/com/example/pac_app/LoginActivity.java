package com.example.pac_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText textUserView;
    private EditText textPassView;
    private Button buttonLogin;

    public static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textUserView = findViewById(R.id.textUsername);
        textPassView = findViewById(R.id.textPassword);
        buttonLogin = findViewById(R.id.button);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){
        if(userExists(textUserView.getText().toString(), textPassView.getText().toString())){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }else {
            Log.e(TAG, "Login Invalido!");;
        }
    }

    private Boolean userExists(String userName, String pass){

        Users users = AppDatabase.getInstance(LoginActivity.this).getUsersDao().getByUserAndPass(userName, pass);

        if (users != null){
            return true;
        }else{
            return false;
        }
    }
}