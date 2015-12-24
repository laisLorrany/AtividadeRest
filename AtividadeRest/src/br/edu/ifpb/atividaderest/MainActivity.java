package br.edu.ifpb.atividaderest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	Button asyncTaskButton = (Button)findViewById(R.id.enviarButton);
	asyncTaskButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("MainActivity", "Clique no botão da AsyncTask");

            EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
            String nome = nomeEditText.getText().toString();
            EditText senhaEditText = (EditText) findViewById(R.id.senhaEditText);
            String senha = senhaEditText.getText().toString();

            LoginAsyncTask loginAsyncTask = new LoginAsyncTask(v.getContext());
            String[] valores = {nome, senha};

            loginAsyncTask.execute(valores);
            
        }
    });
	

}
}