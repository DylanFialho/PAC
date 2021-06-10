package com.example.pac_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    Button registerButton;
    Button storeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        loginButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        registerButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ResgisterActivity.class)));

        storeButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, StoreActivity.class));
        });
    }

    protected void initializeViews(){
        loginButton = (Button) findViewById(R.id.button_login);
        registerButton = findViewById(R.id.button_register);
        storeButton = findViewById(R.id.button_store);
    }
}
