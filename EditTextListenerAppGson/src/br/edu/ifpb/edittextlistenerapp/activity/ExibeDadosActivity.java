package br.edu.ifpb.edittextlistenerapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.edu.ifpb.edittextlistenerapp.R;

public class ExibeDadosActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {

		// Inicializa��o da activity e defini��o do layout.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exibe_dados);

		Intent intent = getIntent();
		Bundle dados = intent.getExtras();

		TextView nometext = (TextView) findViewById(R.id.nome);
		nometext.setText(dados.getString("Nome"));
		TextView inscricao = (TextView) findViewById(R.id.inscricao);
		inscricao.setText(dados.getString("Inscricao"));
		TextView email = (TextView) findViewById(R.id.email);
		email.setText(dados.getString("Email"));
		TextView entregue = (TextView) findViewById(R.id.entregue);
		if(dados.getBoolean("Entregue")==false){
			entregue.setText("Kit n�o entregue");
		}else{
			entregue.setText("Kit entregue");
		}
	}
}