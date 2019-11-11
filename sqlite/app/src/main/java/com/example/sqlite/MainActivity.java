package com.example.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Database db;
    TextView res;
    EditText nome, placa, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);
        db.createDB();

        nome = findViewById(R.id.nome);
        placa = findViewById(R.id.placa);
        ano = findViewById(R.id.ano);
        res = findViewById(R.id.resultados);
    }

    public void inserir(View v) {
        if (nome.getText().length() != 0 && placa.getText().length() != 0 && ano.getText().length() != 0) {
            db.insert(nome.getText(), placa.getText(), ano.getText());
            nome.setText("");
            placa.setText("");
            ano.setText("");
        } else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }
    }

    public void alterar(View v) {
        if (nome.getText().length() != 0 && placa.getText().length() != 0 && ano.getText().length() != 0) {
            db.update(nome.getText(), placa.getText(), ano.getText());
            nome.setText("");
            placa.setText("");
            ano.setText("");
        } else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }
    }

    public void excluir(View v) {
        if (nome.getText().length() != 0) {
            db.delete(nome.getText());
            nome.setText("");
            placa.setText("");
            ano.setText("");
        } else {
            Toast.makeText(this, "Preencha o nome do carro!", Toast.LENGTH_SHORT).show();
        }
    }

    public void consultar(View v) {
        String returnDb = db.select();
        res.setText(returnDb);
    }
}