package com.example.pac_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        button = findViewById(R.id.buttonPay);
        recyclerView = findViewById(R.id.recyclerViewCart);

        Toolbar toolbar = findViewById(R.id.toolbar2);

        toolbar.setTitle("Carrinho");

        CartAdapter cartAdapter = new CartAdapter(this,
                AppDatabase.getInstance(this).getGameDao().getAllInCart());

        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(CartActivity.this, PaymentActivity.class));
            }
        });
    }
}