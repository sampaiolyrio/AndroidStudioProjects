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

import br.com.lyrio.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper(this);

        final FormularioHelper helper = new FormularioHelper(this);

        /*Button botaoSalvar  = (Button) findViewById(R.id.formulario_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Aluno aluno = helper.pegaAluno();

                Toast.makeText(FormularioActivity.this, "Aluno "+ aluno.getNome()+" salvo", Toast.LENGTH_SHORT).show();
                //Toast.makeText(FormularioActivity.this,"Botão Clicado",Toast.LENGTH_SHORT).show();
                finish();
            }
        });*/
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
                   Toast.makeText(FormularioActivity.this, "Aluno "+ aluno.getNome()+" salvo", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
            }
            return super.onOptionsItemSelected(item);

    }
}

