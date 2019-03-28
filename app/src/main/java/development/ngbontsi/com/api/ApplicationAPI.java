package development.ngbontsi.com.api;

import development.ngbontsi.com.util.ApplicationInterceptor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ndimphiwe.bontsi on 2018/03/02.
 */

public class ApplicationAPI {

    public static final String URL = "http://mkclothingsa.co.za/";
    public static Retrofit RETROFIT = null;

    public static Retrofit getRETROFIT(){
        if(RETROFIT == null){
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new ApplicationInterceptor())
                    .build();

            RETROFIT = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return RETROFIT;
    }
}
