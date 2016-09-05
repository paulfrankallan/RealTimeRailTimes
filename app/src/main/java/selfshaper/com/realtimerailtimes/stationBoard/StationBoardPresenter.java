package selfshaper.com.realtimerailtimes.stationBoard;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.api.OpenDataTranslinkAPIService;
import selfshaper.com.realtimerailtimes.model.stationBoard.Service;
import selfshaper.com.realtimerailtimes.model.stationBoard.StationBoard;

/**
 * Created by Paul.Allan on 24/08/2016.
 */
public class StationBoardPresenter {

    private static final String TAG = StationBoardPresenter.class.getSimpleName();

    private StationBoardView stationBoardView;
    private  OpenDataTranslinkAPIService apiService;

    public StationBoardPresenter(StationBoardView stationBoardView,
                                 OpenDataTranslinkAPIService apiService) {
        this.stationBoardView = stationBoardView;
        this.apiService = apiService;
    }

    public void onCreateView(String stationCode) {

        Call<StationBoard> call = apiService.getStationBoard(stationCode);
        call.enqueue(new Callback<StationBoard>() {
            @Override
            public void onResponse(Call<StationBoard> call, Response<StationBoard> rServices) {

                stationBoardView.populateDepartsFromText(rServices.body().name);
                stationBoardView.populateLastUpdatedText(rServices.body().Timestamp);

                List<Service> services = rServices.body().Service;
                if (services != null && !services.isEmpty()) {
                    stationBoardView.populateServicesForStation(services);
                } else {
                    stationBoardView.showInfo(R.string.no_services_info);
                }
            }

            @Override
            public void onFailure(Call<StationBoard> call, Throwable t) {
                stationBoardView.showInfo(R.string.network_error);
                Log.e(TAG, t.toString());
            }
        });
    }
}