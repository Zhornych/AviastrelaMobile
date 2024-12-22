package com.example.aviastrela;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TicketBuyActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, passportNumberEditText, dateOfBirthEditText, phoneEditText, emailEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Установка полноэкранного режима
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        if (getActionBar() != null) {
            getActionBar().hide();
        }

        setContentView(R.layout.activity_ticket_buy);

        // Инициализация полей ввода
        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        passportNumberEditText = findViewById(R.id.passport_number);
        dateOfBirthEditText = findViewById(R.id.date_of_birth);
        phoneEditText = findViewById(R.id.phone);
        emailEditText = findViewById(R.id.email);

        Button buyButton = findViewById(R.id.buy_button);
        Button backButton = findViewById(R.id.back_button);

        // Обработчик кнопки "Купить"
        buyButton.setOnClickListener(v -> {
            String firstName = firstNameEditText.getText().toString();
            String lastName = lastNameEditText.getText().toString();
            String passportNumber = passportNumberEditText.getText().toString();
            String dateOfBirth = dateOfBirthEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            String email = emailEditText.getText().toString();

            // Здесь можно добавить дополнительную проверку данных перед покупкой
            Toast.makeText(this, "Билет успешно куплен!", Toast.LENGTH_SHORT).show();
        });

        // Обработчик кнопки "Назад"
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(TicketBuyActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        });
    }
}