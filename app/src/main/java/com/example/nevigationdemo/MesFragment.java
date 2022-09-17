package com.example.nevigationdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;


public class MesFragment extends Fragment {
EditText updateToTime,updateFromTime,updateCal,updateDis;

    public MesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_mes, container, false);
        updateCal =(EditText) view.findViewById(R.id.updateCal);
        updateToTime =(EditText) view.findViewById(R.id.updateToTime);
        updateFromTime =(EditText) view.findViewById(R.id.updateFromTime);
        updateDis =(EditText) view.findViewById(R.id.updateDis);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int h = calendar.get(Calendar.HOUR_OF_DAY);
        final int m = calendar.get(Calendar.MINUTE);


        updateCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = i1+1;
                        String datee = i2+"/"+i1+"/"+i;
                        updateCal.setText(datee);
                    }
                },year,month,day);
                datePickerDialog.show();
                updateCal.requestFocus();

            }
        });
        updateFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String hour = ""+i;
                        String min = ""+i1;
                        updateFromTime.setText(hour+":"+min);
                    }
                },h,m,false);
                timePickerDialog.show();

            }
        });

        updateToTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String hour = ""+i;
                        String min = ""+i1;
                        updateToTime.setText(hour+":"+min);
                    }
                },h,m,false);
                timePickerDialog.show();

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}