package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "DepartTime", strict=false)
public class DepartTime implements Parcelable {

    @Attribute
    public String time;

    @Attribute
    public String timestamp;

    @Attribute
    public String sorttimestamp;

    protected DepartTime() { }

    protected DepartTime(Parcel in) {
        time = in.readString();
        timestamp = in.readString();
        sorttimestamp = in.readString();
    }

    public static final Creator<DepartTime> CREATOR = new Creator<DepartTime>() {
        @Override
        public DepartTime createFromParcel(Parcel in) {
            return new DepartTime(in);
        }

        @Override
        public DepartTime[] newArray(int size) {
            return new DepartTime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeString(timestamp);
        dest.writeString(sorttimestamp);
    }
}
