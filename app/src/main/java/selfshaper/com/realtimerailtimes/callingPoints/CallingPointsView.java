package selfshaper.com.realtimerailtimes.callingPoints;

import java.util.List;

import selfshaper.com.realtimerailtimes.model.stationBoard.CallingPoint;

/**
 * Created by Paul.Allan on 24/08/2016.
 */
public interface CallingPointsView {

    void populateCallingPointsForService(List<CallingPoint> callingPoints);

    void populateLastReportedText(String lastReported);

    void populateOriginText(String origin);

    void showInfo(int resId);
}
