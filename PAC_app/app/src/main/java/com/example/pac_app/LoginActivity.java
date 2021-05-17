package com.example.pac_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    TextView textUserView = (TextView) findViewById(R.id.textUsername);
    TextView textPassView = (TextView) findViewById(R.id.textPassword);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login(textUserView.getText().toString(), textPassView.getText().toString(), this);
    }

    private void login(String user, String pass, Context context){

        List<Users> users = AppDatabase.getInstance(context).getUsersDao().getAll();

        if(users.contains(user) && users.contains(pass)){

        }
    }
}