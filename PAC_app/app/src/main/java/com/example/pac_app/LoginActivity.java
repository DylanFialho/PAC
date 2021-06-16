package com.example.pac_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pac_app.model.Users;

public class LoginActivity extends AppCompatActivity {

    private EditText textUserView;
    private EditText textPassView;
    private Button buttonLogin;
    public static Users loggedUser;

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
            loggedUser = AppDatabase.getInstance(LoginActivity.this).getUsersDao().getByUserAndPass(textUserView.getText().toString(), textPassView.getText().toString());
            AppDatabase.getInstance(LoginActivity.this).getUsersDao().updateUser(loggedUser);
            startActivity(new Intent(LoginActivity.this, StoreActivity.class));
        }else {
            Toast.makeText(this, "Login Errado", Toast.LENGTH_SHORT).show();

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