package com.example.tarea1pmdm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginCorrecto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_correcto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView bienvenida = findViewById(R.id.textViewBienvenida);

        Bundle extras = getIntent().getExtras();

        String nombre = extras.getString("Nombre");
        bienvenida.setText("Bienvenido " + nombre);


        ImageButton imgBtn = findViewById(R.id.imageButton);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.tutorialspoint.com/android/android_intents_filters.htm";

                Intent urlInternet = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(urlInternet);

            }
        });


        Button btnAlarma= findViewById(R.id.buttonAlarma);

        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginCorrecto.this, CrearAlarma.class);
                startActivity(i);
            }
        });
    }
}

