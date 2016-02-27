package br.edu.ifpb.edittextlistenerapp.activity;

import br.edu.ifpb.edittextlistenerapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.edittextlistenerapp.asynctask.BuscarNomesAsynctask;

public class BuscarNomesActivity extends Activity implements TextWatcher {

    // Define o tamanho mínimo do texto para consulta no servidor.
    private static int TAMANHO_MINIMO_TEXTO = 4;

    private EditText nomeEditText;
    List<String> nomes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inicialização da activity e definição do layout.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_nomes);

        // Recuperando o EditText e
        nomeEditText = (EditText) findViewById(R.id.nome);
        nomeEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
        nomes = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                nomes);

        nomesListView.setAdapter(adapter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        Log.i("EditTextListener","beforeTextChanged: " + charSequence);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

        Log.i("EditTextListener", "onTextChanged: " + charSequence);
        String nome = charSequence.toString();

        // Consultar o servidor. Criar o JSONObject e uma AsyncTask<JSONObject, Void, Response>
        try {

            if (nome.length() >= TAMANHO_MINIMO_TEXTO) {
                // JSON
                JSONObject json = new JSONObject();
                json.put("fullName", nome);

                BuscarNomesAsynctask buscarNomeAsyncTask = new BuscarNomesAsynctask();
                buscarNomeAsyncTask.execute(json);

                // Adicionar ao ListView.
                nomes.add(nome);
                adapter.notifyDataSetChanged();
            }

        } catch (JSONException e) {

            Log.e("EditTextListener", e.getMessage());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

        Log.i("EditTextListener","afterTextChanged: " + editable);
    }
}