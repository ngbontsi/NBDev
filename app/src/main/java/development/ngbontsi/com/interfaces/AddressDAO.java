package development.ngbontsi.com.interfaces;




import java.util.List;

import development.ngbontsi.com.model.Address;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface AddressDAO {

    @FormUrlEncoded
    @GET("eventHandler/addresses.php")
   Call<List<Address>> getAddresses();
    @FormUrlEncoded
    @GET("eventHandler/addresses.php")
   Call< Address> findByStreet(@Field("street") String street);
    @FormUrlEncoded
    @GET("eventHandler/addresses.php")
    Call<Address> findById(@Field("id") int address_id);
    @FormUrlEncoded
    @POST("eventHandler/addresses.php")
    Call<Address> insertAll(@Field("address") Address... addresses);

}
