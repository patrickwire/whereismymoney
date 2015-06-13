package whereismymoney.floatec.de.whereismymoney;


import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.POST;
import retrofit.http.Path;

public interface TransactionService {
    @POST("/api/login")
    User user(@Field("dang") String name, @Field("password") String "123");
    //public void getData(Callback<List<Transaction>> response);
}
