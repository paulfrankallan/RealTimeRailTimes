package selfshaper.com.realtimerailtimes.model.stationBoard;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "DepartTime", strict=false)
public class DepartTime {

    @Attribute
    public String time;

    @Attribute
    public String timestamp;

    @Attribute
    public String sorttimestamp;
}
