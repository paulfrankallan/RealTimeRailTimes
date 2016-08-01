package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "Dest1CallingPoints", strict=false)
public class Dest1CallingPoints implements Parcelable {

    @Attribute
    public String NumCallingPoints;

    @ElementList(inline = true, required=false)
    public List<CallingPoint> callingPointList = new ArrayList<>();

    public Dest1CallingPoints() {

    }

    protected Dest1CallingPoints(Parcel in) {
        NumCallingPoints = in.readString();
        callingPointList = in.createTypedArrayList(CallingPoint.CREATOR);
    }

    public static final Creator<Dest1CallingPoints> CREATOR = new Creator<Dest1CallingPoints>() {
        @Override
        public Dest1CallingPoints createFromParcel(Parcel in) {
            return new Dest1CallingPoints(in);
        }

        @Override
        public Dest1CallingPoints[] newArray(int size) {
            return new Dest1CallingPoints[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(NumCallingPoints);
        dest.writeTypedList(callingPointList);
    }
}
