package selfshaper.com.realtimerailtimes.stations;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.api.OpenDataTranslinkAPIService;
import selfshaper.com.realtimerailtimes.model.stations.Station;
import selfshaper.com.realtimerailtimes.model.stations.Stations;
import selfshaper.com.realtimerailtimes.stationBoard.StationBoardActivity;

/**
 * Created by Paul.Allan on 13/08/2016.
 */
public class StationsPresenter {

    private StationsView stationsView;
    private  OpenDataTranslinkAPIService apiService;

    public StationsPresenter(StationsView stationsView, OpenDataTranslinkAPIService apiService) {
        this.stationsView = stationsView;
        this.apiService = apiService;
    }

    public void onCreateView() {
        Call<Stations> call = apiService.stations();
        call.enqueue(new Callback<Stations>() {
            @Override
            public void onResponse(Call<Stations> call, Response<Stations> rStations) {
                List<Station> stations = rStations.body().getStations();
                stationsView.populateStations(stations);
            }

            @Override
            public void onFailure(Call<Stations> call, Throwable t) {
                stationsView.showError(R.string.network_error);
            }
        });
    }
}