import sun.net.www.http.HttpClient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
public class Connection {

    private final String _url;
    int timeout = 3000;

    public Connection(String url){
        this._url = url;
    }

    /*public JSONObject createJsonObject(char keyInput){
        JSONObject json = new JSONObject();
    }*/

    public void postMessage(String _json) throws IOException {
        HttpURLConnection connection =(HttpURLConnection)new URL(_url).openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type","application/json");
        connection.setDoOutput(true);
        connection.setConnectTimeout(timeout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        bw.write(_json);
        bw.flush();

        int resp_code = connection.getResponseCode();
        String resp_msg = connection.getResponseMessage();

        System.out.println("resp_code="+resp_code);
        System.out.println("resp_msg="+resp_msg);
    }
}
