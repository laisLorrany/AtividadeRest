package br.edu.ifpb.atividaderest;

import java.net.HttpURLConnection;

import android.os.AsyncTask;
import android.util.Log;

public class LoginAsyncTask extends AsyncTask<String, Void, HttpURLConnection>{
	
	@Override
	protected void onPreExecute(){
		Log.i("LoginAsyncTask: ", "onPreExecute");
		
	}

	@Override
	protected HttpURLConnection doInBackground(String... params) {

		HttpURLConnection connection = null;
		Log.i("LoginAsyncTask: ", "doInBackGround");
		
		try {
			connection = HttpService.sendPostRequest("servicoservlet");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(HttpURLConnection connection){
		Log.i("LoginAsyncTask: ", "onPostExecute");
		
	}

}
