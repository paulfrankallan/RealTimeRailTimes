package selfshaper.com.realtimerailtimes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import selfshaper.com.realtimerailtimes.model.StationBoard;
import selfshaper.com.realtimerailtimes.model.Stations;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public interface OpenDataTransLinkAPI {

    // Example station board request
    // http://apis.opendatani.gov.uk/translink/3044C5.xml

    @GET("translink/")
    Call<Stations> stations();

    @GET("/xml/stationBoard.xml")
    StationBoard getStationBoard();
}