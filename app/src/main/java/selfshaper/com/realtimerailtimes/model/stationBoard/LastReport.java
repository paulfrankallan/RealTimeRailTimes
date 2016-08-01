package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 01/08/2016.
 */

@Root(name="CallingPoint", strict = false)
public class LastReport implements Parcelable {

    protected LastReport() {}

    @Attribute
    public String tiploc;

    @Attribute
    public String time;

    @Attribute
    public String type;

    @Attribute
    public String station1;

    @Attribute
    public String station2;

    protected LastReport(Parcel in) {
        tiploc = in.readString();
        time = in.readString();
        type = in.readString();
        station1 = in.readString();
        station2 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tiploc);
        dest.writeString(time);
        dest.writeString(type);
        dest.writeString(station1);
        dest.writeString(station2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LastReport> CREATOR = new Creator<LastReport>() {
        @Override
        public LastReport createFromParcel(Parcel in) {
            return new LastReport(in);
        }

        @Override
        public LastReport[] newArray(int size) {
            return new LastReport[size];
        }
    };
}
