package com.example.nevigationdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class ChatFragment extends Fragment {
TextView  eventcalender;
TextView eventFromTime,eventToTime,eventDis;
    public ChatFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int h = calendar.get(Calendar.HOUR_OF_DAY);
        final int m = calendar.get(Calendar.MINUTE);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat,container,false);
        // Inflate the layout for this fragment
        eventcalender = (TextView) view.findViewById(R.id.eventcalender);
        eventDis = view.findViewById(R.id.eventDis);
        eventFromTime = view.findViewById(R.id.eventFromTime);
        eventToTime = view.findViewById(R.id.eventToTime);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int h = calendar.get(Calendar.HOUR_OF_DAY);
        final int m = calendar.get(Calendar.MINUTE);

        eventcalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                         new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = i1+1;
                        String datee = i2+"/"+i1+"/"+i;
                        eventcalender.setText(datee);
                    }
                },year,month,day);
                datePickerDialog.show();
                eventcalender.requestFocus();
                //eventcalender.setText("Okk");
                Toast.makeText(getActivity(), "eventcalender", Toast.LENGTH_SHORT).show();

            }
        });

        eventToTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String hour = ""+i;
                        String min = ""+i1;
                        eventToTime.setText(hour+":"+min);
                    }
                },h,m,false);
                timePickerDialog.show();


            }
        });

        eventFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String hour = ""+i;
                        String min = ""+i1;
                        eventFromTime.setText(hour+":"+min);
                    }
                },h,m,false);
                timePickerDialog.show();


            }
        });
        return view;
    }
}