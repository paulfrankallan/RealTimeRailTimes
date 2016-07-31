package selfshaper.com.realtimerailtimes.model.stationBoard;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
@Root(name = "StationBoard", strict=false)
public class StationBoard {

    @Attribute
    private String name;

    @Attribute
    private String tiploc;

    @Attribute
    private String crs;

    @Attribute
    private String PlatformData;

    @Attribute
    private String Timestamp;

    @Element
    public String TridentId;

    @ElementList(inline = true, required = false)
    public List<Service> Service;
}