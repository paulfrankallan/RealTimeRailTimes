package selfshaper.com.realtimerailtimes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import selfshaper.com.realtimerailtimes.model.Stations;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public interface OpenDataTransLinkAPI {

    @GET("translink/")
    Call<Stations> stations();
}
