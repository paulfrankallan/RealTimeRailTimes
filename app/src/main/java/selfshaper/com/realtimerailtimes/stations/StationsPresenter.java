package selfshaper.com.realtimerailtimes.stations;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.api.OpenDataTranslinkAPIService;
import selfshaper.com.realtimerailtimes.model.stations.Station;
import selfshaper.com.realtimerailtimes.model.stations.Stations;

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

        Observable<Stations> call = apiService.stations();

        Subscription subscription = call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Stations>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        // cast to retrofit.HttpException to get the response code
                        if (e instanceof HttpException) {
                            HttpException response = (HttpException)e;
                            int code = response.code();
                            stationsView.showError(R.string.network_error);
                        }
                    }

                    @Override
                    public void onNext(Stations rStations) {
                        List<Station> stations = rStations.getStations();
                        stationsView.populateStations(stations);
                    }
                });

        // Call<Stations> call = apiService.stations();

        /*call.enqueue(new Callback<Stations>() {
            @Override
            public void onResponse(Call<Stations> call, Response<Stations> rStations) {
                List<Station> stations = rStations.body().getStations();
                stationsView.populateStations(stations);
            }

            @Override
            public void onFailure(Call<Stations> call, Throwable t) {
                stationsView.showError(R.string.network_error);
            }
        });*/
    }
}