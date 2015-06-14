package whereismymoney.floatec.de.whereismymoney;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class TransactionStore{

    public List<Transaction> store = new ArrayList<Transaction>();
    private String jsdonData = null;
    public String token = null;
    private JSONArray tmpTrans = null;


    public void addDemoData(){
       for (int i = 0; i <10; i++) {
            store.add(new Transaction(i,0,0));
        }
    }

    public void addData(JSONArray tmpData){
        if(tmpData != null) {
            //wenn daten vorhanden generiere alle Objekte
            try{
                for (int i = 0; i < tmpData.length(); i++) {
                    JSONObject listEntry = tmpData.getJSONObject(i);
                    double tmpVal = listEntry.getDouble("amount");
                    //ka ob das so gut ist....
                    double tmpLat = 0.0;
                    double tmpLong = 0.0;
                    if(!listEntry.isNull("latitude")){
                        tmpLat = listEntry.getDouble("latitude");
                    }
                    if(!listEntry.isNull("longitude")){
                        tmpLong = listEntry.getDouble("longitude");
                    }
                    store.add(new Transaction((float) tmpVal, tmpLat, tmpLong));
                }
            }catch (org.json.JSONException e){
                e.printStackTrace();
            }
            for(Transaction k : store){
                Log.e("sonListeneintrag: ", k.getLat() + " " + k.getLng() + " " + k.getValue());
            }
        }
    }

    public List getTransactionListArray(){
        return this.store;
    }

    public void getData(){
        String[] logindaten = {"dang", "123"};
        reciveToken t = new reciveToken();
        t.mc = new CallbackInterface() {
            @Override
            public void callBack(String myData) {
                jsdonData = myData;
                try{
                    final JSONObject obj = new JSONObject(jsdonData);
                    token = obj.get("token").toString();
                    tmpTrans = obj.getJSONArray("transactions");

                }catch (org.json.JSONException e){
                    e.printStackTrace();
                }
                Log.d("jsonData", jsdonData);
                Log.d("token", token);
                addData(tmpTrans);
            }
        };
        t.execute(logindaten);
    }


}
