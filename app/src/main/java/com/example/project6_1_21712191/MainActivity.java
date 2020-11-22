package com.example.project6_1_21712191;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Chronometer timer;
    RadioButton btn_cal,btn_time;
    DatePicker datepic;
    TimePicker timepic;
    TextView  tv_year, tv_month,tv_day, tv_hour,tv_minn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("예약 시스템 21712191");

        timer = (Chronometer)findViewById(R.id.timer);

        btn_cal = (RadioButton)findViewById(R.id.btn_cal);
        btn_time = (RadioButton)findViewById(R.id.btn_time);

        datepic = (DatePicker)findViewById(R.id.datepic);
        timepic = (TimePicker)findViewById(R.id.timepic);

        tv_year = (TextView)findViewById(R.id.tv_year);
        tv_month = (TextView)findViewById(R.id.tv_month);
        tv_day = (TextView)findViewById(R.id.tv_day);
        tv_hour = (TextView)findViewById(R.id.tv_hour);
        tv_minn = (TextView)findViewById(R.id.tv_minn);


        btn_cal.setVisibility(View.INVISIBLE);
        btn_time.setVisibility(View.INVISIBLE);
        timepic.setVisibility(View.INVISIBLE);
        datepic.setVisibility(View.INVISIBLE);


        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepic.setVisibility(View.VISIBLE);
                datepic.setVisibility(View.INVISIBLE);
            }
        });

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepic.setVisibility(View.INVISIBLE);
                datepic.setVisibility(View.VISIBLE);
            }
        });

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
                timer.setTextColor(Color.RED);
                btn_cal.setVisibility(View.VISIBLE);
                btn_time.setVisibility(View.VISIBLE);
            }
        });

        tv_year.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                timer.stop();
                timer.setTextColor(Color.BLUE);


                tv_year.setText(Integer.toString(datepic.getYear()));
                tv_month.setText(Integer.toString(datepic.getMonth()));
                tv_day.setText(Integer.toString(datepic.getDayOfMonth()));

                tv_hour.setText(Integer.toString(timepic.getCurrentHour()));
                tv_minn.setText(Integer.toString(timepic.getCurrentMinute()));

                btn_cal.setVisibility(View.INVISIBLE);
                btn_time.setVisibility(View.INVISIBLE);
                timer.setVisibility(View.VISIBLE);
                datepic.setVisibility(View.INVISIBLE);
                timepic.setVisibility(View.INVISIBLE);


                return false;
            }
        });

    }
}