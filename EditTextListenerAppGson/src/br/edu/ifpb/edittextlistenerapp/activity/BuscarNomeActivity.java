package br.edu.ifpb.edittextlistenerapp.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.edu.ifpb.edittextlistenerapp.R;
import br.edu.ifpb.edittextlistenerapp.adapter.PessoasCustomAdapter;
import br.edu.ifpb.edittextlistenerapp.asynctask.BuscarNomeAsyncTask;
import br.edu.ifpb.edittextlistenerapp.callback.BuscarPessoaCallBack;
import br.edu.ifpb.edittextlistenerapp.entidade.Pessoa;
import br.edu.ifpb.edittextlistenerapp.exclusion.EstrategiaExclusaoJSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BuscarNomeActivity extends Activity implements TextWatcher,
		OnItemClickListener, BuscarPessoaCallBack {

	// Define o tamanho mínimo do texto para consulta no servidor.
	private static int TAMANHO_MINIMO_TEXTO = 4;
	private BuscarPessoaCallBack buscarNomeCallBack;
	private EditText nomeEditText;
	Pessoa pessoaDado = new Pessoa();

	List<Pessoa> pessoas;
	PessoasCustomAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Inicialização da activity e definição do layout.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar_nome);

		// Recuperando o EditText e
		nomeEditText = (EditText) findViewById(R.id.nomeEditText);
		nomeEditText.addTextChangedListener(this);

		ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
		pessoas = new ArrayList<Pessoa>();
		adapter = new PessoasCustomAdapter(this, pessoas);

		// Adapter modificado.
		nomesListView.setAdapter(adapter);

		// Evento de OnItemClickListener.
		nomesListView.setOnItemClickListener(this);

	}

	// TextWatcher
	@Override
	public void beforeTextChanged(CharSequence charSequence, int start,
			int count, int after) {

		Log.i("EditTextListener", "beforeTextChanged: " + charSequence);
	}

	@Override
	public void onTextChanged(CharSequence charSequence, int start, int before,
			int count) {

		Log.i("EditTextListener", "onTextChanged: " + charSequence);
		String nome = charSequence.toString();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		// Consultar o servidor. Criar o JSONObject e uma AsyncTask<JSONObject,
		// Void, Response>

		if (nome.length() >= TAMANHO_MINIMO_TEXTO) {
			// Gson
			Gson gson = new GsonBuilder().setExclusionStrategies(
					new EstrategiaExclusaoJSON()).create();
			String stringJSON = gson.toJson(pessoa);
			Log.i("EditTextListener", "gson: " + stringJSON);
			BuscarNomeAsyncTask buscarNomeAsyncTask = new BuscarNomeAsyncTask(
					this);
			buscarNomeAsyncTask.execute(stringJSON);
		}

	}

	@Override
	public void afterTextChanged(Editable editable) {

		Log.i("EditTextListener", "afterTextChanged: " + editable);
	}

	// OnItemClickListener
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		Log.i("EditTextListener", "Position: " + position);
		
		Pessoa pessoa = new Pessoa ();
		
		pessoa = pessoas.get(position);
		
	   adapter.getItem(position);
	   

		
		Intent it = new Intent(BuscarNomeActivity.this,
				ExibeDadosActivity.class);
		Bundle dados = new Bundle();
		dados.putString("Nome",pessoa.getNome());
		dados.putString("Email",pessoa.getEmail());
		dados.putString("Inscricao", pessoa.getDescricao());
		dados.putBoolean("Entregue", pessoa.isEntregue());
		it.putExtras(dados);
		startActivity(it);

		Toast toast = Toast.makeText(this, "Item " + (position + 1) + ": "
				+ pessoas.get(position), Toast.LENGTH_LONG);
		toast.show();
	}

	// BuscarPessoaCallBack
	@Override
	public void backBuscarNome(List<Pessoa> pessoas) {

		this.pessoas.clear();
		this.pessoas.addAll(pessoas);
		adapter.notifyDataSetChanged();
}

	@Override
	public void errorBuscarNome(String error) {

		pessoas.clear();
		adapter.notifyDataSetChanged();

		Toast.makeText(this, error, Toast.LENGTH_LONG);
	}
}