package selfshaper.com.realtimerailtimes.stationBoard;

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
import selfshaper.com.realtimerailtimes.api.OpenDataClient;
import selfshaper.com.realtimerailtimes.api.OpenDataTransLinkAPI;
import selfshaper.com.realtimerailtimes.model.stationBoard.Service;
import selfshaper.com.realtimerailtimes.model.stationBoard.StationBoard;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public class StationBoardFragment extends Fragment {

    private static final String TAG = StationBoardFragment.class.getSimpleName();

    @BindView(R.id.listview_services) protected ListView servicesListView;
    @BindView(R.id.textview_departs_from) TextView departsFromTextView;
    @BindView(R.id.textview_last_updated) TextView lastUpdatedTextView;
    @BindView(R.id.textview_info) TextView infoTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_station_board, container, false);
        ButterKnife.bind(this, rootView);

        Intent intent = getActivity().getIntent();
        String stationCode;

        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            stationCode = intent.getStringExtra(Intent.EXTRA_TEXT);
            populateServicesForStation(stationCode);
        }

        return rootView;
    }

    private void populateServicesForStation(String stationCode) {

        final OpenDataTransLinkAPI apiService =
                OpenDataClient.getClient(ConverterType.XML).create(OpenDataTransLinkAPI.class);

        Call<StationBoard> call = apiService.getStationBoard(stationCode + ".xml");
        call.enqueue(new Callback<StationBoard>() {
            @Override
            public void onResponse(Call<StationBoard> call, Response<StationBoard> rServices) {

                departsFromTextView.setText(rServices.body().name);
                lastUpdatedTextView.setText(rServices.body().Timestamp);

                List<Service> services = rServices.body().Service;
                if (services != null && !services.isEmpty()) {

                    Log.d(TAG, "Number of services received: " + services.size());

                    final ServiceListAdapter serviceListAdapter = new ServiceListAdapter(getActivity(),
                            R.layout.list_item_service, services);

                    servicesListView.setAdapter(serviceListAdapter);
                    servicesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                            Service service = serviceListAdapter.getItem(position);
                            // TODO expand service info
                        }
                    });

                    infoTextView.setVisibility(TextView.INVISIBLE);

                } else {
                    infoTextView.setText(
                            "No trains are scheduled to call at this station for at least 60 minutes.");
                    infoTextView.setVisibility(TextView.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<StationBoard> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}