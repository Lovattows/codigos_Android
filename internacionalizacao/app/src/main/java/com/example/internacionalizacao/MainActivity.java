package com.example.internacionalizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    RadioButton male;
    RadioButton female;
    AutoCompleteTextView autoCompleteNacionalidades;
    String[] nacionalidades = new String[]{"Brasileiro", "Chileno", "Boliviano", "Argentino", "Equatoriano", "Paraguaio", "Espanhol", "Holandês", "Italiano", "Americano", "Francês"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner para as escolaridades
        Spinner spinEscolaridade;
        spinEscolaridade = findViewById(R.id.spinEscolaridades);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.escolaridade));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinEscolaridade.setAdapter(adapter);

        //autoComplete para nacionalidades
        autoCompleteNacionalidades = findViewById(R.id.autoCompleteNacionalidade);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nacionalidades);
        autoCompleteNacionalidades.setAdapter(adaptador);
    }

    public void onRadioButtonClick(View v) {
        ImageView img = findViewById(R.id.profile);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        if (male.isChecked()) {
            img.setImageResource(R.drawable.male);
        } else if (female.isChecked()) {
            img.setImageResource(R.drawable.female);
        }

    }
}
