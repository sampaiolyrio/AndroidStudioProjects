package br.com.lyrio.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.lyrio.agenda.modelo.Aluno;

/**
 * Created by sampa on 03/12/2017.
 */

public class AlunoDao extends SQLiteOpenHelper{

    public AlunoDao(Context context,  int version) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "create table Alunos(id integer primary key, nome text not null, endereco text, telefone text, site text, nota real");";
                db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists alunos";
        db.execSQL(sql);
        onCreate(db);

    }

    public void insere(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("endereco",aluno.getEndereco());
        dados.put("telefone", aluno.getTelefone());
        dados.put("site", aluno.getSite());
        dados.put("nota", aluno.getNota());

        db.insert("Alunos", null, dados);



        db.insert("Alunos",null, ContentValues)
        String sql = "INSERT INTO Alunos (nome, endereco, telefone, site, nota) VALUES(" +aluno.getNome()
    }
}
