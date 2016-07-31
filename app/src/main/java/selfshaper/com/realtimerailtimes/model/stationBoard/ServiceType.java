package selfshaper.com.realtimerailtimes.model.stationBoard;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */
@Root(name = "ServiceType")
public class ServiceType {
    @Attribute
    private String Type;
}