package br.com.lyrio.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.lyrio.agenda.dao.AlunoDao;
import br.com.lyrio.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper= new FormularioHelper(this);

        Intent intent = getIntent();
        Aluno aluno = (Aluno)intent.getSerializableExtra("aluno");
        if(aluno != null){
            helper.preencheFormulario(aluno);
            Toast.makeText(FormularioActivity.this, "Editando o Aluno "+ aluno.getNome()+" ", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Aluno aluno = helper.pegaAluno();
                AlunoDao dao = new AlunoDao(this);
                if (aluno.getId() != null) {
                    dao.altera(aluno);
                } else {
                    dao.insere(aluno);
                }


                    dao.close();
                    Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome() + " salvo", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                }
                return super.onOptionsItemSelected(item);

        }}

