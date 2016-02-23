package br.edu.ifpb.ExampleTextWatcher;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements TextWatcher {
	
	private List<String> nomes;
	private ArrayAdapter<String> adapter;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EditText campo = (EditText) findViewById(R.id.texto);    
        campo.addTextChangedListener(this);
        
        ListView list = (ListView) findViewById (R.id.list);    
        
        
        nomes = new ArrayList<String> ();
        
        adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, nomes);
        
        list.setAdapter(adapter);
            

    }

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		Log.i("TextWatcher","beforeTextChanged:" +s);
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		Log.i("TextWatcher","onTextChanged:" +s);
		
		String nome = s.toString();
		nomes.add(nome);
		adapter.notifyDataSetChanged();
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		Log.i("TextWatcher","afterTextChanged:" +s);
		
	}
}
