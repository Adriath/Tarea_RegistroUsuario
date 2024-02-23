package com.example.tarea3_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    // DECLARACIONES

     // Componentes de la interfaz gráfica
    TextInputEditText nombre ;
    TextInputEditText contrasena ;
    Button botonAcceder ;

    // Datos que introduce el usuario
    String usuarioIntroducido ;
    String contrasenaIntroducida ;

    // Datos válidos con los que vamos a contrastar para acceder
    final String USUARIO_VALIDO = "FEDERICO" ;
    final String CONTRASENA_VALIDA = "alumno@" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializo los componentes de la interfaz gráfica
        nombre = findViewById(R.id.usuario) ;
        contrasena = findViewById(R.id.contrasena) ;
        botonAcceder = findViewById(R.id.botonAcceder) ;

        // LISTENERS

        // Listener del botón de acceso
        botonAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuarioIntroducido = nombre.getText().toString() ;
                contrasenaIntroducida = contrasena.getText().toString() ;

                String mensaje = "";

                if (usuarioIntroducido.equals(USUARIO_VALIDO) && contrasenaIntroducida.equals(CONTRASENA_VALIDA))
                {
                    mensaje = "Acceso válido" ;

                    Intent intentoActivitySec = new Intent(MainActivity.this, SecActivity.class) ;
                    intentoActivitySec.putExtra("nombreUsuario", usuarioIntroducido) ;
                    startActivity(intentoActivitySec) ;

                }
                else
                {
                    mensaje = "Las credenciales son incorrectas" ;
                }

                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });

    }
}