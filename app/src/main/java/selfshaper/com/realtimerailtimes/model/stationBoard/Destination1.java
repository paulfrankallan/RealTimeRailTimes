package selfshaper.com.realtimerailtimes.model.stationBoard;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "Destination1", strict=false)
public class Destination1 {

    @Attribute
    public String name;

    @Attribute
    public String tiploc;

    @Attribute
    public String crs;

    @Attribute
    public String ttarr;

    @Attribute
    public String etarr;
}
