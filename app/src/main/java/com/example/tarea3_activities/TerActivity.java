package com.example.tarea3_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TerActivity extends AppCompatActivity {

    Button volver ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ter);

        volver = findViewById(R.id.botonVolver) ;

        // ESCUCHADOR BOTÓN VOLVER
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish() ;
            }
        });
    }
}