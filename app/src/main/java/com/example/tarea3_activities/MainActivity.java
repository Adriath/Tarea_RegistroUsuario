package com.example.tarea3_activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    // DECLARACIONES

     // Componentes de la interfaz gráfica
    private TextInputEditText nombre ;
    private TextInputEditText contrasena ;
    private TextView textoNuevoRegistro ;
    private Button botonAcceder ;

    // Datos que introduce el usuario
    private String usuarioIntroducido ;
    private String contrasenaIntroducida ;

    // Datos válidos con los que vamos a contrastar para acceder
    private final String USUARIO_VALIDO = "FEDERICO" ;
    private final String CONTRASENA_VALIDA = "alumno@" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializo los componentes de la interfaz gráfica
        nombre = findViewById(R.id.usuario) ;
        contrasena = findViewById(R.id.contrasena) ;
        botonAcceder = findViewById(R.id.botonAcceder) ;
        textoNuevoRegistro = findViewById(R.id.textoNuevoRegistro) ;

        String textoCompleto = String.valueOf(textoNuevoRegistro.getText()) ;
        String textoEnlace = "aquí";

        SpannableString spannableString = new SpannableString(textoCompleto);

        int startIndex = textoCompleto.indexOf(textoEnlace) ;

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Acción a realizar cuando se hace clic en el enlace
                Intent intent = new Intent(MainActivity.this, Activity_reg.class);
                startActivity(intent);
            }
        };

        // Aplicar el ClickableSpan a la parte del texto que será el enlace
        spannableString.setSpan(clickableSpan, startIndex, startIndex + textoEnlace.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) ;

        // Establecer el texto en el TextView
        textoNuevoRegistro.setText(spannableString) ;

        // Hacer que el enlace sea clickable
        textoNuevoRegistro.setMovementMethod(LinkMovementMethod.getInstance()) ;

        // LISTENERS

        // Listener del botón de acceso
        botonAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuarioIntroducido = nombre.getText().toString() ;
                contrasenaIntroducida = contrasena.getText().toString() ;

//                String mensaje = "";
//
//                if (usuarioIntroducido.equals(USUARIO_VALIDO) && contrasenaIntroducida.equals(CONTRASENA_VALIDA))
//                {
//                    mensaje = "Acceso válido" ;

                    Intent intentoActivitySec = new Intent(MainActivity.this, SecActivity.class) ;
                    intentoActivitySec.putExtra("nombreUsuario", usuarioIntroducido) ;
                    startActivity(intentoActivitySec) ;

//                }
//                else
//                {
//                    mensaje = "Las credenciales son incorrectas" ;
//                }

//                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }


        });

    }
}