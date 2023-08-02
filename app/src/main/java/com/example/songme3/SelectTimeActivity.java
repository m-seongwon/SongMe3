package com.example.songme3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectTimeActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private Button btnDone;
    private TextView tvSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);

        timePicker = findViewById(R.id.timePicker);
        btnDone = findViewById(R.id.btnDone);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);

        String selectedDate = getIntent().getStringExtra("selected_date");
        tvSelectedDate.setText("Selected Date: " + selectedDate);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hourOfDay = timePicker.getHour();
                int minute = timePicker.getMinute();
                String selectedTime = String.format("%02d:%02d", hourOfDay, minute);
                showToast("Selected Time: " + selectedTime);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}