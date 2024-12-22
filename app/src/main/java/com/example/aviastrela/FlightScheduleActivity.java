package com.example.aviastrela;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FlightScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FlightScheduleAdapter adapter;
    private List<FlightSchedule> flightSchedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_schedule);

        // Установка полноэкранного режима
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        if (getActionBar() != null) {
            getActionBar().hide();
        }

        recyclerView = findViewById(R.id.recycler_view_flight_schedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Добавление данных
        flightSchedules = new ArrayList<>();
        loadFlightData();

        adapter = new FlightScheduleAdapter(flightSchedules);
        recyclerView.setAdapter(adapter);
    }

    private void loadFlightData() {
        flightSchedules.add(new FlightSchedule("19.05.2024", "08:00-09:30", "Аврора Скай", "активен", "SP01-320", "08:00", "09:30"));
        flightSchedules.add(new FlightSchedule("19.05.2024", "10:00-12:30", "Призрачный Летун", "активен", "TF02-220", "10:00", "12:30"));
        flightSchedules.add(new FlightSchedule("19.05.2024", "13:00-15:30", "Летархия", "активен", "SS03-180", "13:00", "15:30"));
        flightSchedules.add(new FlightSchedule("19.05.2024", "16:00-17:30", "Таинственные слоники", "активен", "TW04-270", "16:00", "17:30"));
        flightSchedules.add(new FlightSchedule("19.05.2024", "18:00-20:30", "Скупые Фениксы", "активен", "SE05-200", "18:00", "20:30"));
    }
}