package selfshaper.com.realtimerailtimes.stationBoard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import selfshaper.com.realtimerailtimes.R;

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
            TextView stationCodeTextView = (TextView) container.findViewById(R.id.station_code_textview);
            stationCodeTextView.setText(stationCode);
        }

        return rootView;
    }
}
