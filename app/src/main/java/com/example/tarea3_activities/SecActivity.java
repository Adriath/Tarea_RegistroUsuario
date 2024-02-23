package com.example.tarea3_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecActivity extends AppCompatActivity {

    TextView encabezado ;
    TextView migasDePan ;
    Button botonActividad2 ;
    Button volver ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        encabezado = findViewById(R.id.textViewCabecera) ;
        migasDePan = findViewById(R.id.tvMigasDePan) ;
        botonActividad2 = findViewById(R.id.botonActividad2) ;
        volver = findViewById(R.id.botonVolver) ;


        Intent intento = getIntent() ;

        String nombreUsuario = intento.getStringExtra("nombreUsuario") ;

        encabezado.setText("BIENVENIDO A NUESTRA PÁGINA PRINCIPAL, " + nombreUsuario) ;

        // ESCUCHADOR DEL BOTÓN PARA IR A LA ACTIVIDAD 2
        botonActividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentoActividadTer = new Intent(SecActivity.this, TerActivity.class) ;
                startActivity(intentoActividadTer) ;
            }
        });

        // ESCUCHADOR PARA EL BOTÓN VOLVER
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish() ;
            }
        });

    }


}