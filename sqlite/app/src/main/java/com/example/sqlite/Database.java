package com.example.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.widget.Toast;

class Database {

    private SQLiteDatabase db;
    private String BANCO = "carros.db";
    private Context ctx;

    void createDB() {
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS carro (" +
                "ID INTEGER PRIMARY KEY, " +
                "NOME TEXT, " +
                "PLACA TEXT, " +
                "ANO TEXT);");
        db.close();
    }

    Database(Context ctx) {
        this.ctx = ctx;
    }

    void insert(Editable nome, Editable placa, Editable ano) {
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        db.execSQL("INSERT INTO carro (NOME, PLACA, ANO) VALUES (" +
                "'" + nome + "','" + placa + "','" + ano + "')");
        db.close();
        Toast.makeText(ctx, "Carro cadastrado com sucesso", Toast.LENGTH_SHORT).show();
    }

    void update(Editable nome, Editable placa, Editable ano) {
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        db.execSQL("UPDATE carro SET NOME = '" + nome + "'," +
                "PLACA = '" + placa + "'," +
                "ANO = '" + ano + "' WHERE NOME = " + nome);
        db.close();
        Toast.makeText(ctx, "Carro alterado com sucesso", Toast.LENGTH_SHORT).show();
    }

    void delete(Editable nome) {
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        db.execSQL("DELETE FROM carro WHERE NOME LIKE " + "'" + nome + "'");
        db.close();
        Toast.makeText(ctx, "Carro excluído com sucesso", Toast.LENGTH_SHORT).show();
    }

    String select() {
        db = ctx.openOrCreateDatabase(BANCO, Context.MODE_PRIVATE, null);
        Cursor linhas = db.rawQuery("SELECT * FROM carro", null);

        String retorno = "";
        if (linhas.moveToFirst()) {
            do {
                String ID = linhas.getString(0);
                String NOME = linhas.getString(1);
                String PLACA = linhas.getString(2);
                String ANO = linhas.getString(3);
                retorno += ID + "," + NOME + "," + PLACA + "," + ANO + "\n";
            }
            while (linhas.moveToNext());
        }
        db.close();
        return retorno;
    }
}
