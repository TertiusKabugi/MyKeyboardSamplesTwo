 package com.example.mykeyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
     private EditText birthday;
     private int mYear;
     private int mMonth;
     private int mDay;

     private String mSpinnerLabel;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthday = findViewById(R.id.birthday);
        birthday.setOnClickListener(this);



    }

     @Override
     public void onClick(View v) {
        if(v == birthday){
            final Calendar cal = Calendar.getInstance();
            mYear = cal.get(Calendar.YEAR);
            mMonth = cal.get(Calendar.MONTH);
            mDay = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    birthday.setText(dayOfMonth + '-' + (month + 1 + '-' + year));
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

     }

     @Override
     public void onItemSelected(AdapterView<?> adapterView, View view, int j, long id) {
        mSpinnerLabel = adapterView.getItemAtPosition(j).toString();
        Toast myToast = Toast.makeText(this, "Selected phone number as:" +mSpinnerLabel, Toast.LENGTH_SHORT);
        myToast.show();
     }

     @Override
     public void onNothingSelected(AdapterView<?> parent) {
         Toast toast = Toast.makeText(this, "nothing selected", Toast.LENGTH_SHORT);
         toast.show();
     }

     public void showToast(View view) {
         Toast check = Toast.makeText(this, "Accept Terms and Conditions", Toast.LENGTH_SHORT);
         check.show();
     }

     public void createAccount(View view) {
         Toast submit = Toast.makeText(this, "Account Creation Successful", Toast.LENGTH_SHORT);
         submit.show();
     }
 }