package whereismymoney.floatec.de.whereismymoney;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class TransactionStore{

    public List<Transaction> store = new ArrayList<Transaction>();
    public String jsdonData = null;
    public String token = null;

    public void addDemoData(){
       for (int i = 0; i <10; i++) {
            store.add(new Transaction(i,0,0));
        }
    }

    public List getTransactionListArray(){
        return this.store;
    }

    public void getToken(){
        String[] logindaten = {"dang", "123"};
        reciveToken t = new reciveToken();
        t.mc = new CallbackInterface() {
            @Override
            public void callBack(String myData) {
                jsdonData = myData;
                try{
                    final JSONObject obj = new JSONObject(jsdonData);
                    token = obj.get("token").toString();
                }catch (org.json.JSONException e){
                    e.printStackTrace();
                }
                Log.d("jsonData", jsdonData);
                Log.d("token", token);
            }
        };
        t.execute(logindaten);
    }


}
