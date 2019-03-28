package development.ngbontsi.com.interfaces;




import java.util.List;


import development.ngbontsi.com.model.EventStatus;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface EventStatusDAO {
    @FormUrlEncoded
    @GET("eventHandler/eventStatus.php")
    Call<List<EventStatus>> getEventStatuses();
    @FormUrlEncoded
    @GET("eventHandler/eventStatus.php")
    Call<EventStatus> findByDescription(@Field("description") String description);
    @FormUrlEncoded
    @GET("eventHandler/eventStatus.php")
    Call<EventStatus> findById(@Field("id") int event_status_id);
    @FormUrlEncoded
  @POST("eventHandler/eventStatus.php")
  Call<EventStatus> insertAll(@Field("object") EventStatus... eventStatuses);

}
