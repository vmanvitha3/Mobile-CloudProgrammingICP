package com.example.prasanna.calenderviewapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView theDate;
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theDate = (TextView)findViewById(R.id.date);
        mCalendarView = (CalendarView)findViewById(R.id.calendarView);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        theDate.setText("Date: "+simpleDateFormat.format(date));

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override

            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String mdate = "Date: " + dayOfMonth + "/" + (month+1) + "/" + year;

                theDate.setText(mdate);
            }
        });
    }
}
