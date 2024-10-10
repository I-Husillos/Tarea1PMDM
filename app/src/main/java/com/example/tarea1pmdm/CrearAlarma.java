package com.example.tarea1pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearAlarma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_alarma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnCrearAlarma = findViewById(R.id.buttonCrearAlarma);
        EditText nombreAlarma = findViewById(R.id.editTextNombreAlarm);
        EditText horaAlarma = findViewById(R.id.editTextHora);
        EditText minutesAlarma = findViewById(R.id.editTextMinutos);

        btnCrearAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, nombreAlarma.getText().toString())
                        .putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(horaAlarma.getText().toString()))
                        .putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minutesAlarma.getText().toString()));
                startActivity(intent);



            }
        });
    }
}


