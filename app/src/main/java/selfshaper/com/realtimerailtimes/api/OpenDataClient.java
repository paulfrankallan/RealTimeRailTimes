package selfshaper.com.realtimerailtimes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public class OpenDataClient {

    public static String BASE_URL = "http://apis.opendatani.gov.uk/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(ConverterType type) {

        // Workaround Converter selection as fall-through selection isn't working. See comments below.
        switch (type) {
            case XML:
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(SimpleXmlConverterFactory.create())
                        .build();
                break;
            case JSON:
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                break;
            default:
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .build();
                break;
        }

        // According to the Retrofit2 documentation this should work by falling through to the
        // correct converter as necessary. It doesn't work though and tries to always use the
        // first Converter specified causing an exception when it gets to the second converter usage.
        /*retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();*/

        return retrofit;
    }
}