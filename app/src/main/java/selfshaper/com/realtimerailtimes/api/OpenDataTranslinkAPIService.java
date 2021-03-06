package selfshaper.com.realtimerailtimes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import selfshaper.com.realtimerailtimes.model.stationBoard.StationBoard;
import selfshaper.com.realtimerailtimes.model.stations.Stations;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public interface OpenDataTranslinkAPIService {

    // Example Stations request
    // Endpoint: http://apis.opendatani.gov.uk/translink/
    @GET("translink/")
    Call<Stations> stations();

    // Example StationBoard request
    // Endpoint: http://apis.opendatani.gov.uk/translink/3044C5.xml
    @GET("/translink/{stationCode}.xml")
    Call<StationBoard> getStationBoard(@Path("stationCode") String stationCode);
}