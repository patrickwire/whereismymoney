package whereismymoney.floatec.de.whereismymoney;


import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class reciveToken extends AsyncTask<String[], Void, String> {

    public CallbackInterface mc;
    private static final String URL = "https://gentle-atoll-9160.herokuapp.com/api/login";

    @Override
    protected String doInBackground(String[]... params) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(URL);
        //parameters for send
        List namePassword = new ArrayList(1);
        namePassword.add(new BasicNameValuePair("username", params[0][0]));
        namePassword.add(new BasicNameValuePair("password", params[0][1]));
        StringBuilder sb = new StringBuilder();
        try {
            post.setEntity(new UrlEncodedFormEntity(namePassword));
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));


            //test if we get something back
            String line = "";

            while((line = rd.readLine()) != null){
                sb.append(line);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mc.callBack(sb.toString());
        return sb.toString();
    }
}
