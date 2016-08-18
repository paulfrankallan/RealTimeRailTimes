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
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.api.ConverterType;
import selfshaper.com.realtimerailtimes.stationBoard.StationBoardActivity;
import selfshaper.com.realtimerailtimes.api.OpenDataClient;
import selfshaper.com.realtimerailtimes.api.OpenDataTranslinkAPIService;
import selfshaper.com.realtimerailtimes.model.stations.Station;
import selfshaper.com.realtimerailtimes.model.stations.Stations;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public class StationsListFragment extends Fragment implements StationsView {

    private static final String TAG = StationsListFragment.class.getSimpleName();

    private StationsPresenter stationsPresenter;

    @BindView(R.id.listview_stations) protected ListView stationsListView;
    @BindView(R.id.textview_error_info) TextView errorInfoTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_stations, container, false);

        ButterKnife.bind(this, rootView);

        stationsPresenter = new StationsPresenter(this,
                OpenDataClient.getClient(ConverterType.JSON).create(OpenDataTranslinkAPIService.class));
        stationsPresenter.onCreateView();

        return rootView;
    }

    @Override
    public void populateStations(List<Station> stations) {

        Log.d(TAG, "Number of stations received: " + stations.size());

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

        errorInfoTextView.setVisibility(TextView.INVISIBLE);
    }

    @Override
    public void showError(int resId) {
        errorInfoTextView.setText(getText(resId));
        errorInfoTextView.setVisibility(TextView.VISIBLE);
        Log.e(TAG, errorInfoTextView.getText().toString());
    }
}