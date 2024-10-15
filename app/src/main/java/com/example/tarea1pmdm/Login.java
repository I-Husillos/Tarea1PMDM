package com.example.tarea1pmdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    String name="admin";
    String password="admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button botonIni = findViewById(R.id.buttonIniciarSesion);
        EditText nameUser = findViewById(R.id.editTextNombre);
        EditText passwUser = findViewById(R.id.editTextPasswd);



        ActivityResultLauncher<Intent> launcherDatosUsuario = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK)  {
                            Bundle extras = result.getData().getExtras();

                            String newNombre = extras.getString("NewName");
                            String newPassword = extras.getString("NewPassword");
                            nameUser.setText(newNombre);
                            passwUser.setText(newPassword);

                            name = newNombre;
                            password = newPassword;
                        }
                    }
                });

        Button botonMod = findViewById(R.id.buttonModificar);

        botonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, ModificarCredenciales.class);
                launcherDatosUsuario.launch(i);
            }
        });



        botonIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.equals(nameUser.getText().toString()) && password.equals(passwUser.getText().toString())){
                    Intent i = new Intent(Login.this, LoginCorrecto.class);
                    i.putExtra("Nombre", nameUser.getText().toString());
                    startActivity(i);
                }else {
                    Toast.makeText(Login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    Log.d("Login", "Usuario o contraseña incorrectos");
                }
            }
        });
    }
}


