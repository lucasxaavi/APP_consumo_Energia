package com.example.calculaconsumo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonCalcular;
    EditText editTextpotencia, editTexthorasdia, editTextDiasMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalcular = findViewById(R.id.buttonCalcular);
        editTextDiasMes = findViewById(R.id.editTextDiasMes);
        editTexthorasdia = findViewById(R.id.editTexthorasdia);
        editTextpotencia = findViewById(R.id.editTextpotencia);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float consumo, potencia, dias, horas;
                String mensagem;

                horas = Float.valueOf(editTexthorasdia.getText().toString());
                dias = Float.valueOf(editTextDiasMes.getText().toString());
                potencia = Float.valueOf(editTextpotencia.getText().toString());

                consumo = (potencia * horas * dias) / 1000;

                mensagem = "consumo: " + consumo + "kWH/mes\n";
                mensagem += "consumo em reais: " + (consumo * 0.5153f);
                Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT) .show();

            }
        });
    }
}
