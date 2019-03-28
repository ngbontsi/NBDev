package development.ngbontsi.com.interfaces;




import java.util.List;


import development.ngbontsi.com.model.EventType;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
public interface EventTypeDAO {

    @FormUrlEncoded
    @GET("eventHandler/eventType.php")
    Call<List<EventType>> getEventStatuses();
    @FormUrlEncoded
    @GET("eventHandler/eventType.php")
    Call<EventType> findByDescription(@Field("description") String description);
    @FormUrlEncoded
    @GET("eventHandler/eventType.php")
    Call<EventType> findById(@Field("id") int event_type_id);
    @FormUrlEncoded
    @POST("eventHandler/eventType.php")
    Call<EventType> insertAll(@Field("object") EventType... eventTypes);

}
