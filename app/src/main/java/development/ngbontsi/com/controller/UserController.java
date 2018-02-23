package development.ngbontsi.com.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import development.ngbontsi.com.api.ApplicationAPI;
import development.ngbontsi.com.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ndimphiwe.bontsi on 2018/02/14.
 */

public class UserController implements Callback<List<User>> {
    static final String BASE_URL = "https://git.eclipse.org/r/";

    public void start(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApplicationAPI applicationAPI = retrofit.create(ApplicationAPI.class);
//        Call<List<User>> call = applicationAPI.insertUser("ndira");
//        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {

        if(response.isSuccessful()){
            List<User> userList = response.body();
        }else{
            response.errorBody();
        }

    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
t.printStackTrace();
    }
}
