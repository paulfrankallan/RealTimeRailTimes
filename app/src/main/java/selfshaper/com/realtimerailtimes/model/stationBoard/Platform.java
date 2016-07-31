package selfshaper.com.realtimerailtimes.model.stationBoard;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */
@Root(name = "Platform", strict=false)
public class Platform {

    @Attribute
    public String Number;

    @Attribute
    public String Changed;

    @Attribute
    public String Parent;
}
