package development.ngbontsi.com.interfaces;




import java.util.List;


import development.ngbontsi.com.model.Commercial;
import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface CommercialDAO {

    @FormUrlEncoded
    @GET("eventHandler/commercials.php")
   Call<List<Commercial>> getCommercials();
    @FormUrlEncoded
    @GET("eventHandler/commercials.php")
   Call< Commercial> findByDescription(@Field("description") String description);
    @FormUrlEncoded
    @GET("eventHandler/commercials.php")
    Call<Commercial> findById(@Field("id") int event_commercial_id);
    @FormUrlEncoded
    @POST("eventHandler/commercials.php")
    Call<Commercial> insertAll(@Field("object") Commercial... commercials);


}
