package selfshaper.com.realtimerailtimes.stations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.stationBoard.StationBoardActivity;
import selfshaper.com.realtimerailtimes.api.OpenDataClient;
import selfshaper.com.realtimerailtimes.api.OpenDataTransLinkAPI;
import selfshaper.com.realtimerailtimes.model.Station;
import selfshaper.com.realtimerailtimes.model.Stations;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public class StationsListFragment extends Fragment {

    private static final String TAG = StationsListFragment.class.getSimpleName();

    public StationsListFragment() {
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

        final OpenDataTransLinkAPI apiService =
                OpenDataClient.getClient().create(OpenDataTransLinkAPI.class);

        Call<Stations> call = apiService.stations();
        call.enqueue(new Callback<Stations>() {
            @Override
            public void onResponse(Call<Stations> call, Response<Stations> rStations) {
                List<Station> stations = rStations.body().getStations();
                for (Station station : stations) stationNames.add(station.getName());
                Log.d(TAG, "Number of getStations received: " + stations.size());

                final ListView stationsListView = (ListView)
                        rootView.findViewById(R.id.listview_stations);

                final StationsListAdapter stationsAdapter = new StationsListAdapter(getActivity(),
                        R.layout.list_item_station, stations);

                stationsListView.setAdapter(stationsAdapter);
                stationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Station station = stationsAdapter.getItem(position);
                        Intent intent = new Intent(getActivity(), StationBoardActivity.class)
                                .putExtra(Intent.EXTRA_TEXT, station.getCode());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Stations> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        return stationNames;
    }
}
