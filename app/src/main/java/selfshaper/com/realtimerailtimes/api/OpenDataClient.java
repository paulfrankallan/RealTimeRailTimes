package selfshaper.com.realtimerailtimes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public class OpenDataClient {

    public static final String BASE_URL = "http://apis.opendatani.gov.uk/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(boolean x) {

        /*retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();*/

        if(x) {
            //if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(SimpleXmlConverterFactory.create())
                        .build();
            //}
        } else {
            //if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            //}
        }

        return retrofit;
    }
}