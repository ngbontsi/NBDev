package development.ngbontsi.com.interfaces;





import java.util.List;


import development.ngbontsi.com.model.Event;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */
public interface EventDAO {
    @FormUrlEncoded
    @GET("eventHandler/events.php")
    Call<List<Event>> getEvents();
    @FormUrlEncoded
    @GET("eventHandler/events.php")
    Call<Event> findByUserId(@Field("organiser") int organizer_id);
    @FormUrlEncoded
    @GET("eventHandler/events.php")
    Call<Event> findById(@Field("id") int event_id);
    @FormUrlEncoded
    @POST("eventHandler/events.php")
    Call<Event> insertAll(@Field("object") Event... addresses);

}
