package selfshaper.com.realtimerailtimes.model.stationBoard;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "Dest1CallingPoints", strict=false)
public class Dest1CallingPoints {

    @Attribute
    public String NumCallingPoints;

    @ElementList(inline = true, required=false)
    public List<CallingPoint> callingPointList = new ArrayList<>();
}
