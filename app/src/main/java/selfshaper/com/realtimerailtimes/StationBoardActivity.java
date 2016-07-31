package selfshaper.com.realtimerailtimes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StationBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_board);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new StationBoardFragment())
                    .commit();
        }
    }
}
