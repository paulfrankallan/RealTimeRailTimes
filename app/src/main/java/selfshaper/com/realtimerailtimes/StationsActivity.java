package selfshaper.com.realtimerailtimes;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_stations, container, false);

            String[] stations = {
                    "Adelaide",
                    "Antrim",
                    "Ballycarry",
                    "Ballymena",
                    "Ballymoney",
                    "Balmoral",
                    "Bangor",
                    "Bangor West",
                    "Belfast Central",
                    "Bellarena",
                    "Botanic",
                    "Carnalea",
                    "Carrickfergus",
                    "Castlerock",
                    "City Hospital",
                    "Clipperstown",
                    "Coleraine",
                    "Cullybackey",
                    "Cultra",
                    "Derriaghy",
                    "Dhu Varren",
                    "Downshire",
                    "Drogheda",
                    "Dublin Connolly",
                    "Dundalk",
                    "Dunmurry",
                    "Finaghy",
                    "Glynn",
                    "Great Victoria St",
                    "Greenisland",
                    "Helen's Bay",
                    "Hilden",
                    "Holywood",
                    "Jordanstown",
                    "Lambeg",
                    "Larne Harbour",
                    "Larne Town",
                    "Lisburn",
                    "Londonderry",
                    "Lurgan",
                    "Magheramorne",
                    "Marino",
                    "Moira",
                    "Mossley West",
                    "Newry",
                    "Portadown",
                    "Portrush",
                    "Poyntzpass",
                    "Scarva",
                    "Seahill",
                    "Sydenham",
                    "Titanic Quarter",
                    "Trooperslane",
                    "University",
                    "Whiteabbey",
                    "Whitehead",
                    "Yorkgate"
            };

            List<String> stationsList = new ArrayList<>(Arrays.asList(stations));

            ArrayAdapter<String> stationsAdapter = new ArrayAdapter<>(getActivity(),
                                                                            R.layout.list_item_station,
                                                                            R.id.list_item_station_textview,
                                                                            stationsList);

            ListView stationsListView = (ListView) rootView.findViewById(R.id.listview_stations);
            stationsListView.setAdapter(stationsAdapter);

            return rootView;
        }
    }
}