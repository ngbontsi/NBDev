package development.ngbontsi.com.api;

import java.util.List;

import development.ngbontsi.com.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ndimphiwe.bontsi on 2018/02/14.
 */

public interface ApplicationAPI {

    @FormUrlEncoded
    @POST("/eventHandler/insert_login.php")
    public Callback<Response> insertUser(
            @Field("name")String name,
            @Field("username") String username,
            @Field("password") String password,
            Callback<Response> callback
    );
}
