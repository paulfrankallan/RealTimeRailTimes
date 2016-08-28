package selfshaper.com.realtimerailtimes.callingPoints;

import java.util.ArrayList;
import java.util.List;

import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.model.stationBoard.CallingPoint;
import selfshaper.com.realtimerailtimes.model.stationBoard.Service;

/**
 * Created by Paul.Allan on 24/08/2016.
 */
public class CallingPointsPresenter {

    CallingPointsView callingPointsView;

    public CallingPointsPresenter(CallingPointsView callingPointsView) {
        this.callingPointsView = callingPointsView;
    }

    public void onCreateView(Service service) {

        callingPointsView.populateLastReportedText(service.getLastReportedStation());
        callingPointsView.populateOriginText(service.Origin1.name);

        List<CallingPoint> callingPointList = new ArrayList<>();

        if (service.Dest1CallingPoints != null) {
            callingPointList = service.Dest1CallingPoints.callingPointList;
        }

        if (callingPointList != null && !service.Dest1CallingPoints.callingPointList.isEmpty()) {
            callingPointsView.populateCallingPointsForService(callingPointList);
        }
        else {
            callingPointsView.showInfo(R.string.no_calling_points_info);
        }
    }
}
