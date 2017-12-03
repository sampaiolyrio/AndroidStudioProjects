package br.com.lyrio.agenda.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
