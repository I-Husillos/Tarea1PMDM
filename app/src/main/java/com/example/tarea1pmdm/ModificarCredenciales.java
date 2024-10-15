package com.example.tarea1pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ModificarCredenciales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar_credenciales);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnGuardarCambios= findViewById(R.id.buttonGuardarChn);
        EditText nuevoNombre= findViewById(R.id.editTextNuevoNombre);
        EditText nuevaPassword= findViewById(R.id.editTextNuevaPasswd);

        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModificarCredenciales.this, Login.class);
                i.putExtra("NewName", nuevoNombre.getText().toString());
                i.putExtra("NewPassword", nuevaPassword.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}