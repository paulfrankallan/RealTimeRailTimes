package selfshaper.com.realtimerailtimes;

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
import selfshaper.com.realtimerailtimes.api.OpenDataClient;
import selfshaper.com.realtimerailtimes.api.OpenDataTransLinkAPI;
import selfshaper.com.realtimerailtimes.model.Station;
import selfshaper.com.realtimerailtimes.model.Stations;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public class StationBoardFragment extends Fragment {

    private static final String TAG = StationBoardFragment.class.getSimpleName();

    public StationBoardFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_station_board, container, false);
        Intent intent = getActivity().getIntent();
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String stationCode = intent.getStringExtra(Intent.EXTRA_TEXT);
            
        }
        return rootView;
    }
}
