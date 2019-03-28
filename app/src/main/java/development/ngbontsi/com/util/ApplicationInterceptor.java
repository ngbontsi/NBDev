package development.ngbontsi.com.util;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by ndimphiwe.bontsi on 2018/03/02.
 */

public class ApplicationInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long tl = System.nanoTime();
        String requestLog = String.format("Sending request %s on %s%n%s",request.url(),chain.connection(),request.headers());

        if(request.method().compareToIgnoreCase("post")==0){
            requestLog = "\n"+ requestLog+"\n"+bodyToString(request);
        }

        Log.d("TAG","request"+"\n"+ requestLog);

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        String responseLog = String.format("Received response for %s in %s%.lfms%n%s",response.request().url(),(t2-tl)/1e6d,response.headers());
String boodyToString = response.body().string();
        Log.d("TAG","response"+"\n"+ requestLog+"\n"+boodyToString);
        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(),boodyToString))
                .build();
    }

    private String bodyToString(Request request) {
        try{
            Request copy = request.newBuilder().build();
            Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();

        }catch (IOException e){
return "It Did not work";
        }
    }
}
