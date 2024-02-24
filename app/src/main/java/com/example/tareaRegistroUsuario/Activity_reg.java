package com.example.tareaRegistroUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tarea3_activities.R;
import com.google.android.material.textfield.TextInputEditText;

public class Activity_reg extends AppCompatActivity {

    private TextInputEditText usuarioRegistro, passwordRegistro ;
    private Button botonRegistrar ;

    private DBHandler dbHandler ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        // Inicializo los componentes

        usuarioRegistro = findViewById(R.id.tv_usuarioRegistro) ;
        passwordRegistro = findViewById(R.id.textoPasswordRegistro) ;
        botonRegistrar = findViewById(R.id.botonRegistrar) ;

        // Conexión BBDD

        dbHandler = new DBHandler(Activity_reg.this) ;

        // Listeners

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Asignación de textos del formulario a las variables

                String usuario = usuarioRegistro.getText().toString() ;
                String password = passwordRegistro.getText().toString() ;

                // Mensaje de error si no se introduce ningún dato

                if (usuario.isEmpty() && password.isEmpty()) {
                    Toast.makeText(Activity_reg.this, "Debes introducir algún dato", Toast.LENGTH_SHORT).show();
                    return ;
                }

                // Añadir datos a la BBDD

                dbHandler.addNewUsuario(usuario, password) ;

                // Mensaje de confirmación
                Toast.makeText(Activity_reg.this, "Se han guardado los datos correctamente", Toast.LENGTH_SHORT).show() ;

                usuarioRegistro.setText("") ;
                passwordRegistro.setText("") ;
            }
        });
    }
}