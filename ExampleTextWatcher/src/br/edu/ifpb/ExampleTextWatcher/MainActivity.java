package br.edu.ifpb.ExampleTextWatcher;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends Activity implements TextWatcher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EditText campo = (EditText) findViewById(R.id.texto);
        campo.addTextChangedListener(this);

    }

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		Log.i("beforeTextChanged:", s.toString());
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		Log.i("onTextChanged:", s.toString());
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		Log.i("afterTextChanged:", s.toString());
		
	}
}
