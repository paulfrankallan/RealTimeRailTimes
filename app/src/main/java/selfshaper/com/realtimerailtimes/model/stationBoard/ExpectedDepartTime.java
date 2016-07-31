package selfshaper.com.realtimerailtimes.model.stationBoard;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "ExpectedDepartTime", strict=false)
public class ExpectedDepartTime {

    @Attribute
    public String time;
}
