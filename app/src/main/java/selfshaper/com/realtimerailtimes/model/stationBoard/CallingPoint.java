package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name="CallingPoint", strict = false)
public class CallingPoint implements Parcelable {

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

    protected CallingPoint(Parcel in) {
        Name = in.readString();
        tiploc = in.readString();
        crs = in.readString();
        ttarr = in.readString();
        ttdep = in.readString();
        etarr = in.readString();
        etdep = in.readString();
        type = in.readString();
    }

    public static final Creator<CallingPoint> CREATOR = new Creator<CallingPoint>() {
        @Override
        public CallingPoint createFromParcel(Parcel in) {
            return new CallingPoint(in);
        }

        @Override
        public CallingPoint[] newArray(int size) {
            return new CallingPoint[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    CallingPoint() {}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(tiploc);
        dest.writeString(crs);
        dest.writeString(ttarr);
        dest.writeString(ttdep);
        dest.writeString(etarr);
        dest.writeString(etdep);
        dest.writeString(type);
    }
}