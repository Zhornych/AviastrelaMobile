package com.example.aviastrela;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FlightScheduleAdapter extends RecyclerView.Adapter<FlightScheduleAdapter.ViewHolder> {

    private List<FlightSchedule> flightSchedules;

    public FlightScheduleAdapter(List<FlightSchedule> flightSchedules) {
        this.flightSchedules = flightSchedules;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_flight_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FlightSchedule flightSchedule = flightSchedules.get(position);
        holder.bind(flightSchedule);
    }

    @Override
    public int getItemCount() {
        return flightSchedules.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView flightTimeTextView;
        TextView airlineTextView;
        TextView statusTextView;
        TextView flightNumberTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.text_view_date);
            flightTimeTextView = itemView.findViewById(R.id.text_view_flight_time);
            airlineTextView = itemView.findViewById(R.id.text_view_airline);
            statusTextView = itemView.findViewById(R.id.text_view_status);
            flightNumberTextView = itemView.findViewById(R.id.text_view_flight_number);
        }

        public void bind(FlightSchedule flightSchedule) {
            dateTextView.setText(flightSchedule.getDepartureDate());
            flightTimeTextView.setText(flightSchedule.getFlightTime());
            airlineTextView.setText(flightSchedule.getAirline());
            statusTextView.setText(flightSchedule.getStatus());
            flightNumberTextView.setText(flightSchedule.getFlightNumber());
        }
    }
}