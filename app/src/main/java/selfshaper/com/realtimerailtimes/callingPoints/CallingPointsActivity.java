package selfshaper.com.realtimerailtimes.callingPoints;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.stationBoard.StationBoardFragment;

public class CallingPointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling_points);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_calling_points, new CallingPointsFragment())
                    .commit();
        }
    }
}