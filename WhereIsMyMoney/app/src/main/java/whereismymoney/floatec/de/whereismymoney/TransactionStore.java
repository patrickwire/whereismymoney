package whereismymoney.floatec.de.whereismymoney;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by floatec on 6/13/15.
 */
public class TransactionStore {
    public List<Transaction> store=new ArrayList<Transaction>();

    public void addDemoData(){
        for (int i = 0; i <10; i++) {
            store.add(new Transaction(i,0,0));
        }

    }
}
