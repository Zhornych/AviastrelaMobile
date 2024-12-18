package com.example.aviastrela;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Установка макета
        setContentView(R.layout.activity_next);
        super.onCreate(savedInstanceState);

        // Инициализация компонентов интерфейса
        ImageButton closeButton = findViewById(R.id.close_button);
        Button startButton = findViewById(R.id.start_button);

        // Обработчик кнопки закрытия
        closeButton.setOnClickListener(view -> finish());

        // Обработчик кнопки "Начать работу"
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}