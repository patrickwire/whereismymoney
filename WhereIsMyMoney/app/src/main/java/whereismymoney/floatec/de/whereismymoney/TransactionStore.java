package whereismymoney.floatec.de.whereismymoney;

import java.util.ArrayList;
import java.util.List;


public class TransactionStore {
    public static final String URL = "";
    public final String name = "test";
    public final String password = "123";

    public List<Transaction> store=new ArrayList<Transaction>();

    public void addDemoData(){
        for (int i = 0; i <10; i++) {
            store.add(new Transaction(i,0,0));
        }

    }
}
