package com.example.aviastrela;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView loadingText;
    private String[] phrases = {
            "Проверка файлов!",
            "Расставляем ваш багаж и файлы по местам...",
            "Готовы к взлету? Багаж, документы, хорошее настроение? Всё на месте? :)",
            "Всё готово для взлёта! Авиастрела проведёт вас к новым горизонтам."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingText = findViewById(R.id.loading_text);

        // Запускаем асинхронную задачу для проверки файлов
        new FileCheckTask().execute();
    }

    private class FileCheckTask extends AsyncTask<Void, String, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Random random = new Random();
            for (int i = 0; i < phrases.length; i++) {
                publishProgress(phrases[i]);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            // Анимация затухания
            loadingText.setAlpha(0f);
            loadingText.setText(values[0]);
            loadingText.animate()
                    .alpha(1f)
                    .setDuration(500) // Длительность анимации
                    .start(); // Запуск анимацию
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // Переход на следующий экран после завершения проверки
            Intent intent = new Intent(MainActivity.this, NextActivity.class);
            startActivity(intent);
            finish();
        }
    }
}