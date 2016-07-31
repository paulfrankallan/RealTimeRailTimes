package selfshaper.com.realtimerailtimes.stations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import selfshaper.com.realtimerailtimes.R;

public class StationsActivity extends AppCompatActivity {

    private static final String TAG = StationsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new StationsListFragment())
                    .commit();
        }
    }
}