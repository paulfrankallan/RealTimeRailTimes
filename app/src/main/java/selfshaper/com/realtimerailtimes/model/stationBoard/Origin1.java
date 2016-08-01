package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "Origin1", strict=false)
public class Origin1 implements Parcelable {

    @Attribute
    public String name;

    @Attribute
    public String tiploc;

    @Attribute
    public String crs;

    protected Origin1() {}

    protected Origin1(Parcel in) {
        name = in.readString();
        tiploc = in.readString();
        crs = in.readString();
    }

    public static final Creator<Origin1> CREATOR = new Creator<Origin1>() {
        @Override
        public Origin1 createFromParcel(Parcel in) {
            return new Origin1(in);
        }

        @Override
        public Origin1[] newArray(int size) {
            return new Origin1[size];
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
    }
}