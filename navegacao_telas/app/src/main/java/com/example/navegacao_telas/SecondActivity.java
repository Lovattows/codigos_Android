package com.example.navegacao_telas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    Intent It;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        It = new Intent(this, MainActivity.class);
        It = getIntent();

        if (It != null) {
            Bundle params = It.getExtras();
            if (params != null) {
                String nomeCompleto = params.getString("nomeCompleto");
                int estadoCivil = params.getInt("estadoCivil");
                int genero = params.getInt("genero");
                int bebida = params.getInt("bebida");

                TextView nomeCompletoText = findViewById(R.id.textViewNomeCompleto);
                TextView telefoneText = findViewById(R.id.textViewNumero);
                TextView estadoCivilText = findViewById(R.id.textViewEstadoCivil);
                TextView generoText = findViewById(R.id.textViewGenero);
                ImageView bebidaView = findViewById(R.id.imageViewBebida);

                Random random = new Random();
                StringBuilder telefone = new StringBuilder();

                for (int i = 0; i < 8; i++) {
                    telefone.append(random.nextInt(9) % 9);
                }

                if (estadoCivil == 1) {
                    Toast.makeText(this, "A aplicação só permite pessoas solteiras", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    if (genero == 1) {
                        nomeCompletoText.setText("Nome Completo: " + nomeCompleto);
                        estadoCivilText.setText("Estado Civil: Solteiro");
                        generoText.setText("Gênero: Masculino");
                        telefoneText.setText("Telefone Parceira: 9" + telefone);
                    } else if (genero == 2) {
                        nomeCompletoText.setText("Nome Completo: " + nomeCompleto);
                        estadoCivilText.setText("Estado Civil: Solteira");
                        generoText.setText("Gênero: Feminino");
                        telefoneText.setText("Telefone Parceiro: 9" + telefone);
                    }

                    if (bebida == 1) {
                        bebidaView.setImageResource(R.drawable.vinho);
                    }
                    if (bebida == 2) {
                        bebidaView.setImageResource(R.drawable.cerveja);
                    }
                    if (bebida == 3) {
                        bebidaView.setImageResource(R.drawable.refrigerante);
                    }
                }
            }
        }
    }

    public void mainActivity(View v) {
        finish();
    }
}

