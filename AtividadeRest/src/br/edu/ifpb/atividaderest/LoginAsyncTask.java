package br.edu.ifpb.atividaderest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class LoginAsyncTask extends AsyncTask<String, Void, Response>{

	Context context;
	
	public LoginAsyncTask(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	protected void onPreExecute(){
		Log.i("LoginAsyncTask: ", "onPreExecute");
		
	}

	@Override
	protected Response doInBackground(String... params) {

		HttpURLConnection connection = null;
		Response response;
		int statusCodeHttp = 0;
		String contentValue = null;
		
		try {
			connection = HttpService.sendPostRequest("servicoservlet");
	        contentValue = HttpService.getHttpContent(connection);
	        statusCodeHttp = connection.getResponseCode();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        response = new Response(statusCodeHttp, contentValue);
        
		Log.i("LoginAsyncTask: ", "doInBackGround");
		
		try {
			System.out.println(params[0]);
			System.out.println(params[1]);
			connection = HttpService.sendPostRequest("servicoservlet");
			Log.i("LoginAsyncTask: ", "doInBackGround - connection");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("LoginAsyncTask: " + e.getMessage());
		}
		
		return response;
	}
	
	@Override
	protected void onPostExecute(Response response){
		Log.i("LoginAsyncTask: ", "onPostExecute");
				
		try {
			int status = response.getStatusCodeHttp();

            JSONObject json = new JSONObject(response.getContentValue());

            if (status == HttpURLConnection.HTTP_OK) {

                String nome = json.getString("key");
                Toast.makeText(context, nome, Toast.LENGTH_LONG).show();
            } else {

                String nome = json.getString("mensagem");
                Toast.makeText(context, nome, Toast.LENGTH_LONG).show();
            }
            
        } catch (JSONException e) {

            Log.e("LoginAsyncTask", "JSONException: " + e.getMessage());
        }
	}

}
