package br.edu.ifpb.edittextlistenerapp.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import br.edu.ifpb.edittextlistenerapp.R;
import br.edu.ifpb.edittextlistenerapp.asynctask.BuscarNomesAsynctask;

public class BuscarNomesActivity extends Activity implements TextWatcher {

    private static int min = 4;

    private EditText nomeEditText;
    List<String> nomes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_nomes);
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

        try {

            if (nome.length() >= min) {
                JSONObject jsonNome = new JSONObject();
                jsonNome.put("fullName", nome);
                BuscarNomesAsynctask buscarNomeAsyncTask = new BuscarNomesAsynctask(this);
                buscarNomeAsyncTask.execute(jsonNome);
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
    
    public void buscarNome(List<String> nomes) {
        this.nomes.addAll(nomes);
        adapter.notifyDataSetChanged();
    }
}