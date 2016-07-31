package selfshaper.com.realtimerailtimes.model.stationBoard;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name="CallingPoint", strict = false)
public class CallingPoint {

    @Attribute
    public String Name;

    @Attribute
    public String tiploc;

    @Attribute
    public String crs;

    @Attribute
    public String ttarr;

    @Attribute
    public String ttdep;

    @Attribute
    public String etarr;

    @Attribute
    public String etdep;

    @Attribute
    public String type;
}