package development.ngbontsi.com.interfaces;




import java.util.List;

import development.ngbontsi.com.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface UserDAO {
    @FormUrlEncoded
    @GET("eventHandler/user.php")
    Call<List<User>> getUsers();
    @FormUrlEncoded
    @GET("eventHandler/user.php")
    Call<User> findByName(@Field("firstname") String firstName,@Field("lastname") String lastName);

    @FormUrlEncoded
    @GET("eventHandler/user.php")
    Call<User> findById(@Field("id") int id);

    @FormUrlEncoded
    @POST("eventHandler/user.php")
    Call<User> insertAll(@Field("object") User... users);

}
