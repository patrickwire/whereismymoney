package whereismymoney.floatec.de.whereismymoney;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;


public class TransactionStore extends AsyncTask<String, Void, String>{

    public List<Transaction> store = new ArrayList<Transaction>();

    public void addDemoData(){
       for (int i = 0; i <10; i++) {
            store.add(new Transaction(i,0,0));
        }
    }

    public List getTransactionListArray(){
        return this.store;
    }

    @Override
    protected String doInBackground(String... params) {
        return null;
    }
}
