package whereismymoney.floatec.de.whereismymoney;


import java.util.List;

import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Path;

public interface TransactionService {
    @POST("/")
    public void getData(Callback<List<Transaction>> response);

}
