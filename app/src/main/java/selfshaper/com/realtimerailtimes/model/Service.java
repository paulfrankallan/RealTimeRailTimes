package selfshaper.com.realtimerailtimes.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 30/07/2016.
 */

@Root(name="Service")
public class Service {

    @Element
    public String ServiceType;

    @Element
    public String Origin1;

    @Element
    public String Destination1;
}
