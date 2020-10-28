import org.json.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Connection {

    private final String _url;
    int timeout = 3000;

    public Connection(String url){
        this._url = url;
    }

    public JSONObject createJsonObject(char keyInput){
        JSONObject json = new JSONObject();
        json.append("key", keyInput);
        return json;
    }

    public void postMessage(JSONObject json) throws IOException {
        HttpURLConnection connection =(HttpURLConnection)new URL(_url).openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type","application/json");
        connection.setDoOutput(true);
        connection.setConnectTimeout(timeout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        String encodedValue= encodeValue("json="+json.toString());
        bw.write(encodedValue);
        bw.flush();

        int resp_code = connection.getResponseCode();
        String resp_msg = connection.getResponseMessage();

        System.out.println("resp_code="+resp_code);
        System.out.println("resp_msg="+resp_msg);
    }
    private String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
