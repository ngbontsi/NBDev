package development.ngbontsi.com.interfaces;




import java.util.List;


import development.ngbontsi.com.model.VenueFacility;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface VenueFacilityDAO {
    @FormUrlEncoded
    @GET("eventHandler/facility.php")
    Call<List<VenueFacility>> getVenueFacilities();
    @FormUrlEncoded
    @GET("eventHandler/facility.php")
    Call<VenueFacility> findByDescription(@Field("description") String description);
    @FormUrlEncoded
    @GET("eventHandler/facility.php")
    Call<VenueFacility> findById(@Field("id") int facility_code);
    @FormUrlEncoded
    @POST("eventHandler/facility.php")
    Call<VenueFacility> insertAll(@Field("object") VenueFacility... venueFacilities);

}
