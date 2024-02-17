package com.example.imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextPeso, editTextAltura;
    Button btnCalculoIMC;
    TextView tvResultado;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        btnCalculoIMC = findViewById(R.id.btnCalculoIMC);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalculoIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextName.getText().toString();
                double peso = Double.parseDouble(editTextPeso.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());

                double imc = peso / (altura * altura);
                String resultado;

                if (imc < 18.5) {
                    resultado = "Bajo peso";
                }
                else if (imc >= 18.5 && imc < 24.9) {
                    resultado = "Peso Normal";
                }
                else if (imc >= 25 && imc < 29.9) {
                    resultado = "Sobrepeso";
                }
                else {
                    resultado = "Obesidad";
                }

                tvResultado.setText("Que tal " + nombre + ", su índice de masa corporal es de: " + String.format("%.2f", imc) + "lo cual significa que estas en:  " + resultado + ".");

            }
        });
    }


}