package com.example.aviastrela;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    private CheckBox skipCheckbox;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Инициализация SharedPreferences
        sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE);

        // Проверка состояния чекбокса
        if (sharedPreferences.getBoolean("skip_welcome", false)) {
            openSecondScreen(); // Открываем SecondActivity, если чекбокс отмечен
            return; // Завершаем текущую активность
        }

        setContentView(R.layout.activity_next);

        // Инициализация компонентов интерфейса
        ImageButton closeButton = findViewById(R.id.close_button);
        Button startButton = findViewById(R.id.start_button);
        skipCheckbox = findViewById(R.id.skip_checkbox);

        // Обработчик кнопки закрытия
        closeButton.setOnClickListener(view -> finish()); // Закрывает приложение

        // Обработчик кнопки "Начать работу"
        startButton.setOnClickListener(view -> {
            if (skipCheckbox.isChecked()) {
                sharedPreferences.edit().putBoolean("skip_welcome", false).apply(); // Сохраняем состояние чекбокса
            }
            openSecondScreen(); // Открываем SecondActivity
        });
    }

    private void openSecondScreen() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
}