package com.example.pac_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pac_app.model.Game;

import java.util.List;

public class PaymentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Toolbar toolbar = findViewById(R.id.toolbar2);

        toolbar.setTitle("Pagamento");

        Button button = findViewById(R.id.buttonPayFinal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "Pagamento Efetuado", Toast.LENGTH_SHORT).show();
                List<Game> gameList = AppDatabase.getInstance(PaymentActivity.this).getGameDao().getAllInCart();
                for (int i = 0; i < gameList.size(); i++) {
                    gameList.get(i).setInCart(false);
                    AppDatabase.getInstance(PaymentActivity.this).getGameDao().updateGame(gameList.get(i));
                }

                startActivity(new Intent(PaymentActivity.this, StoreActivity.class));
            }
        });
    }
}