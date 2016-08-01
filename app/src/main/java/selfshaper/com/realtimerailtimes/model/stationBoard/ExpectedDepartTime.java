package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */

@Root(name = "ExpectedDepartTime", strict=false)
public class ExpectedDepartTime implements Parcelable {

    @Attribute
    public String time;

    protected ExpectedDepartTime() {}

    protected ExpectedDepartTime(Parcel in) {
        time = in.readString();
    }

    public static final Creator<ExpectedDepartTime> CREATOR = new Creator<ExpectedDepartTime>() {
        @Override
        public ExpectedDepartTime createFromParcel(Parcel in) {
            return new ExpectedDepartTime(in);
        }

        @Override
        public ExpectedDepartTime[] newArray(int size) {
            return new ExpectedDepartTime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
    }
}
