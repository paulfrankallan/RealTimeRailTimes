package selfshaper.com.realtimerailtimes.callingPoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.model.stationBoard.CallingPoint;
import selfshaper.com.realtimerailtimes.model.stationBoard.Service;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
public class CallingPointsFragment extends Fragment implements CallingPointsView {

    private static final String TAG = CallingPointsFragment.class.getSimpleName();

    @BindView(R.id.listview_calling_points)
    protected ListView callingPointsListView;
    @BindView(R.id.textview_last_reported)
    TextView lastReportedTextView;
    @BindView(R.id.textview_origin)
    TextView originTextView;
    @BindView(R.id.textview_calling_points_info)
    TextView infoTextView;

    private CallingPointsPresenter callingPointsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_calling_points, container, false);
        ButterKnife.bind(this, rootView);

        callingPointsPresenter = new CallingPointsPresenter(this);

        Intent intent = getActivity().getIntent();
        Service service;

        if (intent != null && intent.hasExtra("service")) {
            service = intent.getParcelableExtra("service");
            callingPointsPresenter.onCreateView(service);
        }

        return rootView;
    }

    @Override
    public void populateCallingPointsForService(List<CallingPoint> callingPoints) {

            Log.d(TAG, "Number of calling points received: " + callingPoints.size());

            final CallingPointsListAdapter callingPointsListAdapter = new CallingPointsListAdapter(getActivity(),
                    R.layout.list_item_calling_point, callingPoints);

            callingPointsListView.setAdapter(callingPointsListAdapter);

            infoTextView.setVisibility(TextView.INVISIBLE);
    }

    @Override
    public void populateLastReportedText(String lastReported) {
        lastReportedTextView.setText(lastReported);
    }

    @Override
    public void populateOriginText(String origin) {
        originTextView.setText(origin);
    }

    @Override
    public void showInfo(int resId) {
        infoTextView.setText(getText(resId));
        infoTextView.setVisibility(TextView.VISIBLE);
        Log.e(TAG, infoTextView.getText().toString());
    }
}