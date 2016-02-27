package br.edu.ifpb.edittextlistenerapp.listener;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import br.edu.ifpb.edittextlistenerapp.asynctask.BuscarNomesAsynctask;

public class BuscarNomesListener implements TextWatcher {
	
	 
	public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        Log.i("EditTextListener","beforeTextChanged: " + charSequence);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

       
    }

    @Override
    public void afterTextChanged(Editable editable) {

        Log.i("EditTextListener","afterTextChanged: " + editable);
    }
    
}
