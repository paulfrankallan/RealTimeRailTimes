package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "Destination1", strict=false)
public class Destination1 implements Parcelable {

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

    Destination1() {}

    protected Destination1(Parcel in) {
        name = in.readString();
        tiploc = in.readString();
        crs = in.readString();
        ttarr = in.readString();
        etarr = in.readString();
    }

    public static final Creator<Destination1> CREATOR = new Creator<Destination1>() {
        @Override
        public Destination1 createFromParcel(Parcel in) {
            return new Destination1(in);
        }

        @Override
        public Destination1[] newArray(int size) {
            return new Destination1[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(tiploc);
        dest.writeString(crs);
        dest.writeString(ttarr);
        dest.writeString(etarr);
    }
}
