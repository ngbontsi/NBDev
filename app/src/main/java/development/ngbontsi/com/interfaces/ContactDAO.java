package development.ngbontsi.com.interfaces;




import java.util.List;


import development.ngbontsi.com.model.Contact;
import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by ndimphiwe.bontsi on 2018/01/31.
 */

public interface ContactDAO {
    @FormUrlEncoded
    @GET("eventHandler/contacts.php")
    Call<List<Contact>> getContacts();
    @FormUrlEncoded
    @GET("eventHandler/contacts.php")
    Call<Contact> findByUserId(@Field("organiserId") int organizer_id);
    @FormUrlEncoded
    @GET("eventHandler/contacts.php")
    Call<Contact> findById(@Field("id") int contact_id);
    @FormUrlEncoded
    @POST("eventHandler/contacts.php")
    Call<Contact> insertAll(@Field("object") Contact... addresses);

}
