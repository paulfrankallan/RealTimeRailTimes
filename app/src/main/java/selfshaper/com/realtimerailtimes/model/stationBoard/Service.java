package selfshaper.com.realtimerailtimes.model.stationBoard;

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
public class Service {

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
    public String Origin1;

    @Element
    public String Via;

    @Element
    public String Coaches1;

    @Element
    public String Incident;*/

    @Element
    public Dest1CallingPoints Dest1CallingPoints;
}
