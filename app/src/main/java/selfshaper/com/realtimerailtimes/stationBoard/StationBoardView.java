package selfshaper.com.realtimerailtimes.stationBoard;

import java.util.List;

import selfshaper.com.realtimerailtimes.model.stationBoard.Service;

/**
 * Created by Paul.Allan on 24/08/2016.
 */
public interface StationBoardView {

    void populateServicesForStation(List<Service> services);

    void populateDepartsFromText(String departsFrom);

    void populateLastUpdatedText(String lastUpdated);

    void showInfo(int resId);
}
