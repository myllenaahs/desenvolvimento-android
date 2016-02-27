package br.edu.ifpb.edittextlistenerapp.asynctask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import br.edu.ifpb.edittextlistenerapp.activity.BuscarNomesActivity;
import br.edu.ifpb.edittextlistenerapp.listener.BuscarNomesListener;
import br.edu.ifpb.edittextlistenerapp.util.HttpService;
import br.edu.ifpb.edittextlistenerapp.util.Response;

/**
 * Created by Rhavy on 24/02/2016.
 */
public class BuscarNomesAsynctask extends AsyncTask<JSONObject, Void, Response> {

	private List<String> nomes;
	BuscarNomesActivity busca;
	
	

	public BuscarNomesAsynctask(BuscarNomesActivity busca) {
		super();
		this.busca = busca;
	}

	@Override
	protected Response doInBackground(JSONObject... jsons) {

		Response response = null;

		JSONObject json = jsons[0];
		Log.i("EditTextListener", "doInBackground (JSON): " + json);

		try {

			response = HttpService.sendJSONPostResquest("get-byname", json);

		} catch (MalformedURLException e) {
			Log.e("EditTextListener", e.getMessage());
		} catch (IOException e) {

			Log.e("EditTextListener", e.getMessage());
		}

		return response;
	}

	@Override
	protected void onPostExecute(Response response) {

		Log.i("EditTextListener",
				"Código HTTP: " + response.getStatusCodeHttp() + " Conteúdo: "
						+ response.getContentValue());

		nomes = new ArrayList<String>();

		try {
			JSONArray jsonarray = new JSONArray(response.getContentValue());

			for (int i=0; i < jsonarray.length(); i++) {
				JSONObject json = jsonarray.getJSONObject(i);
				String nome = json.getString("fullName");
				nomes.add(nome);
			}
			
			busca.buscarNome(nomes);
			
		} catch (JSONException e) {
			Log.e("LoginAsyncTask", "JSONException: " + e.getMessage());
		}
	}
}