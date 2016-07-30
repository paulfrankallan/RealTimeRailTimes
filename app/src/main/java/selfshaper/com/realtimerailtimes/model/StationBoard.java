package selfshaper.com.realtimerailtimes.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Paul.Allan on 30/07/2016.
 */
@Root(name = "StationBoard")
public class StationBoard {

    @Element
    public String TridentId;

    @ElementList(inline = true, required = false)
    public List<Service> Service;
}