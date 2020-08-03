package com.dnteam.medkit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorSearchActivity extends AppCompatActivity {
Button b1 ,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_search);
b1=findViewById(R.id.b1);

 b1.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Intent i =new Intent(DoctorSearchActivity.this, byDocName.class);
         startActivity(i);
     }
 });
    b2=findViewById(R.id.b2);
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i =new Intent(DoctorSearchActivity.this, byCountry.class);
            startActivity(i);

        }
    });}
}