package br.com.lyrio.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.lyrio.agenda.dao.AlunoDao;
import br.com.lyrio.agenda.modelo.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

       listaAlunos = (ListView)findViewById(R.id.lista_alunos);

       listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> lista, View view, int position, long id) {
               Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(position);
               Toast.makeText(ListaAlunosActivity.this,"Aluno "+ aluno.getNome() + " clicado!", Toast.LENGTH_SHORT).show();
           }
       });

       listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(ListaAlunosActivity.this,"clique longo !", Toast.LENGTH_SHORT).show();
               return false;
           }
       });



        Button novoAluno = (Button) findViewById(R.id.novo_aluno);
        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProformulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intentVaiProformulario);
            }
        });

        registerForContextMenu(listaAlunos);
    }

    private void carregaLista() {
        AlunoDao dao = new AlunoDao(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        //String[] alunos ={"Daniel", "Ronaldo"};
        //ListView listaAlunos = (ListView)findViewById(R.id.lista_alunos);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, alunos);


        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this,android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Aluno aluno = (Aluno)listaAlunos.getItemAtPosition(info.position);

                AlunoDao dao =new AlunoDao(ListaAlunosActivity.this);
                dao.deleta(aluno);
                dao.close();
                carregaLista();
                Toast.makeText(ListaAlunosActivity.this,"Deletar o aluno " +aluno.getNome(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
