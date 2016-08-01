package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul.Allan on 30/07/2016.
 */

@Root(name = "Service", strict=false)
public class Service implements Parcelable {

    @Attribute
    private String Headcode;

    @Attribute
    private String Uid;

    @Attribute
    private String RetailID;

    @Attribute
    private String TigerID;

    @Element
    public ServiceType ServiceType;

    @Element
    public Origin1 Origin1;

    @Element
    public LastReport LastReport;

    //@Element
    //public String ArriveTime;

    @Element
    public DepartTime DepartTime;

    @Element
    public Platform Platform;

    @Element
    public Destination1 Destination1;

    //@Element
    //public String SecondaryServiceStatus;

    //@Element
    //public String ServiceStatus;

    @Element
    public ExpectedDepartTime ExpectedDepartTime;

    //@Element
    //public String ExpectedArriveTime;

    /*@Element
    public String Delay;

    @Element
    public String ExpectedDepartStatus;

    @Element
    public String ExpectedArriveStatus;

    @Element
    public String DelayCause;

    @Element
    public String LastReport;

    @Element
    public String CommentLine;

    @Element
    public String CommentLine2;

    @Element
    public String ArrivalComment1;

    @Element
    public String ArrivalComment2;

    @Element
    public String PlatformComment1;

    @Element
    public String PlatformComment2;

    @Element
    public String DepartureComment1;

    @Element
    public String DepartureComment2;

    @Element
    public String AssociatedPageNotices;

    @Element
    public String ChangeAt;

    @Element
    public String Operator;

    @Element
    public String Via;

    @Element
    public String Coaches1;

    @Element
    public String Incident;*/

    @Element
    public Dest1CallingPoints Dest1CallingPoints;

    public Service() {

    }

    protected Service(Parcel in) {
        Headcode = in.readString();
        Uid = in.readString();
        RetailID = in.readString();
        TigerID = in.readString();
        ServiceType = in.readParcelable(selfshaper.com.realtimerailtimes.model.stationBoard.ServiceType.class.getClassLoader());
        Origin1 = in.readParcelable(selfshaper.com.realtimerailtimes.model.stationBoard.Origin1.class.getClassLoader());
        LastReport = in.readParcelable(selfshaper.com.realtimerailtimes.model.stationBoard.LastReport.class.getClassLoader());
        DepartTime = in.readParcelable(selfshaper.com.realtimerailtimes.model.stationBoard.DepartTime.class.getClassLoader());
        Platform = in.readParcelable(selfshaper.com.realtimerailtimes.model.stationBoard.Platform.class.getClassLoader());
        Destination1 = in.readParcelable(selfshaper.com.realtimerailtimes.model.stationBoard.Destination1.class.getClassLoader());
        ExpectedDepartTime = in.readParcelable(selfshaper.com.realtimerailtimes.model.stationBoard.ExpectedDepartTime.class.getClassLoader());
        Dest1CallingPoints = in.readParcelable(selfshaper.com.realtimerailtimes.model.stationBoard.Dest1CallingPoints.class.getClassLoader());
    }

    public String getLastReportedStation() {
        String lastReported = LastReport.station1;

        if (TextUtils.isEmpty(lastReported)) {
            lastReported = LastReport.station2 != null
                    ? LastReport.station2
                    : "";
        }

        String lastReportedTime = TextUtils.isEmpty(LastReport.time)
                ? ""
                : " (" + LastReport.time + ")";

        return lastReported + lastReportedTime;
    }

    public static final Creator<Service> CREATOR = new Creator<Service>() {
        @Override
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        @Override
        public Service[] newArray(int size) {
            return new Service[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Headcode);
        dest.writeString(Uid);
        dest.writeString(RetailID);
        dest.writeString(TigerID);
        dest.writeParcelable(ServiceType, flags);
        dest.writeParcelable(Origin1, flags);
        dest.writeParcelable(LastReport, flags);
        dest.writeParcelable(DepartTime, flags);
        dest.writeParcelable(Platform, flags);
        dest.writeParcelable(Destination1, flags);
        dest.writeParcelable(ExpectedDepartTime, flags);
        dest.writeParcelable(Dest1CallingPoints, flags);
    }
}
