package development.ngbontsi.com.interfaces;




import java.util.List;


import development.ngbontsi.com.model.Organizer;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface OrganizerDAO {

    @FormUrlEncoded
    @GET("eventHandler/organiser.php")
    Call<List<Organizer>> getOrganizers();
    @FormUrlEncoded
    @GET("eventHandler/organiser.php")
    Call<Organizer> findByDescription(@Field("organiser") String organizer_name);
    @FormUrlEncoded
    @GET("eventHandler/organiser.php")
    Call<Organizer> findById(@Field("id") int organizer_id);
    @FormUrlEncoded
    @POST("eventHandler/organiser.php")
    Call<Organizer> insertAll(@Field("object") Organizer... commercials);

}
