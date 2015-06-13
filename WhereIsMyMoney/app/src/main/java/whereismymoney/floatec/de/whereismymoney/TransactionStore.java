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


public class TransactionStore {

    public List<Transaction> store=new ArrayList<Transaction>();

    public void addDemoData(){
       for (int i = 0; i <10; i++) {
            store.add(new Transaction(i,0,0));
        }
    }

    public List getTransactionListArray(){
        return this.store;
    }

}
