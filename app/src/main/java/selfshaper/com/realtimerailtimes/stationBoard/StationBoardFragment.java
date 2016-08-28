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
import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.api.ConverterType;
import selfshaper.com.realtimerailtimes.api.OpenDataClient;
import selfshaper.com.realtimerailtimes.api.OpenDataTranslinkAPIService;
import selfshaper.com.realtimerailtimes.callingPoints.CallingPointsActivity;
import selfshaper.com.realtimerailtimes.model.stationBoard.Service;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public class StationBoardFragment extends Fragment implements StationBoardView {

    private static final String TAG = StationBoardFragment.class.getSimpleName();

    @BindView(R.id.listview_services) protected ListView servicesListView;
    @BindView(R.id.textview_departs_from) TextView departsFromTextView;
    @BindView(R.id.textview_last_updated) TextView lastUpdatedTextView;
    @BindView(R.id.textview_info) TextView infoTextView;

    private StationBoardPresenter stationBoardPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_station_board, container, false);
        ButterKnife.bind(this, rootView);

        Intent intent = getActivity().getIntent();
        String stationCode = "";

        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            stationCode = intent.getStringExtra(Intent.EXTRA_TEXT);
        }

        stationBoardPresenter = new StationBoardPresenter(this,
                OpenDataClient.getClient(ConverterType.XML).create(OpenDataTranslinkAPIService.class));
        stationBoardPresenter.onCreateView(stationCode);

        return rootView;
    }

    @Override
    public void populateServicesForStation(List<Service> services) {

        Log.d(TAG, "Number of services received: " + services.size());

        final ServiceListAdapter serviceListAdapter = new ServiceListAdapter(getActivity(),
                R.layout.list_item_service, services);

        servicesListView.setAdapter(serviceListAdapter);
        servicesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Service service = serviceListAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), CallingPointsActivity.class)
                        .putExtra("service", service);
                startActivity(intent);
            }
        });

        infoTextView.setVisibility(TextView.INVISIBLE);
    }

    @Override
    public void populateDepartsFromText(String departsFrom) {
        departsFromTextView.setText(departsFrom);
    }

    @Override
    public void populateLastUpdatedText(String lastUpdated) {
        lastUpdatedTextView.setText(lastUpdated);
    }

    @Override
    public void showInfo(int resId) {
        infoTextView.setText(getText(resId));
        infoTextView.setVisibility(TextView.VISIBLE);
        Log.e(TAG, infoTextView.getText().toString());
    }
}