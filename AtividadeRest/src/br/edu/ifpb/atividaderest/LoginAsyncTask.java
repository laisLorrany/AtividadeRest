package br.edu.ifpb.atividaderest;

import java.net.HttpURLConnection;

import android.os.AsyncTask;

public class LoginAsyncTask extends AsyncTask<String, Void, HttpURLConnection>{
	
	@Override
	protected void onPreExecute(){
		
	}

	@Override
	protected HttpURLConnection doInBackground(String... params) {

		HttpURLConnection connection = null;
		
		try {
			connection = HttpService.sendPostRequest("servicoservlet");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(HttpURLConnection connection){
		
	}

}
