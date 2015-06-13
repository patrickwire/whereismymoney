package whereismymoney.floatec.de.whereismymoney;

import android.os.AsyncTask;
import android.util.Log;

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


public class TransactionStore extends AsyncTask<String, Void, String> {

    private static final String URL = "https://gentle-atoll-9160.herokuapp.com/api/login";
    private final String username = "dang";
    private final String password = "123";

    public List<Transaction> store=new ArrayList<Transaction>();

    public TransactionStore(){
        //addDemoData();
    }

    @Override
    protected String doInBackground(String... params) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(URL);
        //parameters for send
        List namePassword = new ArrayList(1);
        namePassword.add(new BasicNameValuePair("username", this.username));
        namePassword.add(new BasicNameValuePair("password", this.password));

        try {
            post.setEntity(new UrlEncodedFormEntity(namePassword));
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            //test if we get something back
            String line = "";
            while((line = rd.readLine()) != null){
                Log.d(line, "html");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void addDemoData(){
       for (int i = 0; i <10; i++) {
            store.add(new Transaction(i,0,0));
        }
    }

    public List getTransactionListArray(){
        return this.store;
    }

}
