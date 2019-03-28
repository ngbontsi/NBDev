package development.ngbontsi.com.interfaces;





import java.util.List;

import development.ngbontsi.com.model.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface LoginDAO {
    @FormUrlEncoded
    @GET("eventHandler/login.php")
    Call<List<Login>> getLogins();
    @FormUrlEncoded
    @GET("eventHandler/login.php")
    Call<Login> findByUserName(@Field("username") String username);
    @FormUrlEncoded
    @GET("eventHandler/login.php")
    Call<Login> findById(@Field("id") int id);
    @FormUrlEncoded
    @POST("eventHandler/login.php")
    Call<Login> insertAll(@Field("object") Login... logins);

}
