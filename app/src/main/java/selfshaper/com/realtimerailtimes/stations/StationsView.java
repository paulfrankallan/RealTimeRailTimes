package selfshaper.com.realtimerailtimes.stations;

import java.util.List;

import selfshaper.com.realtimerailtimes.model.stations.Station;

/**
 * Created by Paul.Allan on 13/08/2016.
 */
public interface StationsView {

    void populateStations(List<Station> stations);

    void showError(int resId);
}
