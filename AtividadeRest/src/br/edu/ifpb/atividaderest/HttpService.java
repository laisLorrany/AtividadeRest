package br.edu.ifpb.atividaderest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Log;

public class HttpService {

    // IP da m�quina onde se encontra o servidor.
    private static final String URL_CONTEXT = "http://192.168.56.1:8080/rest-servlet-service/";

    public static HttpURLConnection sendPostRequest(String service)
            throws MalformedURLException, IOException{

        HttpURLConnection connection = null;

        try {

            URL url = new URL(URL_CONTEXT + service);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();

        } catch (Exception e){
        	System.out.println("HttpService: " + e.getMessage());
        }/*finally {
        }

            connection.disconnect();
        }*/

        return connection;
    }

    public void sendJsonPostRequest() {

    }

    public static String getHttpContent(HttpURLConnection connection) {

        StringBuilder builder = new StringBuilder();

        try {

            InputStream content = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    content, "iso-8859-1"), 8);

            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            content.close();

        } catch (IOException e) {

            Log.e("NotificationWearApp", "IOException: " + e);
        }

        return builder.toString();
    }
}