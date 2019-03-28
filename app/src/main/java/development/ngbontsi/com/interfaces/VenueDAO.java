package development.ngbontsi.com.interfaces;




import java.util.List;


import development.ngbontsi.com.model.Venue;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;



/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface VenueDAO {

    @FormUrlEncoded
    @GET("eventHandler/venue.php")
    Call<List<Venue>> getVenues();
    @FormUrlEncoded
    @GET("eventHandler/venue.php")
    Call<Venue> findByDescription(@Field("description") String description);
    @FormUrlEncoded
    @GET("eventHandler/venue.php")
    Call<Venue> findById(@Field("id") int venue_id);
    @FormUrlEncoded
    @POST("eventHandler/venue.php")
    Call<Venue> insertAll(@Field("object") Venue... venues);

}
