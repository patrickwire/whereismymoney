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

/**
 * Created by Attila on 14.06.2015.
 */
public class updateListElements extends AsyncTask<String, Void, String>{
    public CallbackInterface mc;
    //nach der restapi url fragen
    private static final String URL = "https://gentle-atoll-9160.herokuapp.com/api/login";

    @Override
    protected String doInBackground(String... params) {

        return "";
    }
}
