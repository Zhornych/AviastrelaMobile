package com.example.aviastrela;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        // Инициализация кнопки
        Button buttonToTicketBuy = findViewById(R.id.btn_purchase_ticket);

        // Установка обработчика нажатия на кнопку
        buttonToTicketBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на форму покупки билета
                Intent intent = new Intent(SecondActivity.this, TicketBuyActivity.class);
                startActivity(intent);
            }
        });
    }
}