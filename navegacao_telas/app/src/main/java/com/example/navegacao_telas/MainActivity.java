package com.example.navegacao_telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent It;
    RadioButton btnCasado, btnSolteiro, btnMasculino, btnFeminino, btnRefrigerante, btnCerveja, btnVinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnCasado = findViewById(R.id.btnCasado);
        btnCerveja = findViewById(R.id.btnCerveja);
        btnFeminino = findViewById(R.id.btnFeminino);
        btnMasculino = findViewById(R.id.btnMasculino);
        btnRefrigerante = findViewById(R.id.btnRefrigerante);
        btnVinho = findViewById(R.id.btnVinho);
        btnSolteiro = findViewById(R.id.btnSolteiro);
    }

    public void secondActivity(View v) {

        int estadoCivil = 0, genero = 0, bebida = 0;

        EditText nomeCompleto = findViewById(R.id.nomeCompleto);

        if (btnCasado.isChecked()) {
            estadoCivil = 1;
        } else if (btnSolteiro.isChecked()) {
            estadoCivil = 2;
        }

        if (btnMasculino.isChecked()) {
            genero = 1;
        } else if (btnFeminino.isChecked()) {
            genero = 2;
        }

        if (btnVinho.isChecked()) {
            bebida = 1;
        } else if (btnCerveja.isChecked()) {
            bebida = 2;
        } else if (btnRefrigerante.isChecked()) {
            bebida = 3;
        }

        Bundle params = new Bundle();
        params.putString("nomeCompleto", nomeCompleto.getText().toString());
        params.putInt("estadoCivil", estadoCivil);
        params.putInt("genero", genero);
        params.putInt("bebida", bebida);

        It = new Intent(this, SecondActivity.class);
        It.putExtras(params);

        if (nomeCompleto.length() == 0 || estadoCivil == 0 || genero == 0 || bebida == 0) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(It);
        }
    }
}