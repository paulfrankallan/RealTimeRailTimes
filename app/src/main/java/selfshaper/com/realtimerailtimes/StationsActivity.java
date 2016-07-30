package selfshaper.com.realtimerailtimes;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import selfshaper.com.realtimerailtimes.api.OpenDataClient;
import selfshaper.com.realtimerailtimes.api.OpenDataTransLinkAPI;
import selfshaper.com.realtimerailtimes.model.Station;
import selfshaper.com.realtimerailtimes.model.Stations;

public class StationsActivity extends AppCompatActivity {

    private static final String TAG = StationsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_stations, container, false);
            getStationNames(rootView);
            return rootView;
        }

        private List<String> getStationNames(final View rootView) {

            final List<String> stationNames = new ArrayList<>();

            OpenDataTransLinkAPI apiService =
                    OpenDataClient.getClient().create(OpenDataTransLinkAPI.class);

            Call<Stations> call = apiService.stations();
            call.enqueue(new Callback<Stations>() {
                @Override
                public void onResponse(Call<Stations> call, Response<Stations> rStations) {
                    List<Station> stations = rStations.body().getStations();
                    for (Station station : stations) stationNames.add(station.getName());
                    Log.d(TAG, "Number of stations received: " + stations.size());

                    final ListView stationsListView = (ListView) rootView.findViewById(R.id.listview_stations);
                    ArrayAdapter<String> stationsAdapter = new ArrayAdapter<>(getActivity(),
                            R.layout.list_item_station,
                            R.id.list_item_station_textview,
                            stationNames);
                    stationsListView.setAdapter(stationsAdapter);
                }

                @Override
                public void onFailure(Call<Stations> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });

            return stationNames;
        }
    }
}