package br.com.lyrio.agenda;

import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import br.com.lyrio.agenda.modelo.Aluno;

/**
 * Created by sampa on 30/11/2017.
 */

public class FormularioHelper {
    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    //private final EditText campoNota;

    public FormularioHelper(FormularioActivity activity){
       campoNome= activity.findViewById(R.id.formulario_nome);
       campoEndereco= activity.findViewById(R.id.formulario_endereco);
       campoTelefone= activity.findViewById(R.id.formulario_telefone);
       campoSite= activity.findViewById(R.id.formulario_site);
        //RatingBar campoNota= activity.findViewById(R.id.formulario_nota);
    }

    public Aluno pegaAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        return aluno;
    }
}
