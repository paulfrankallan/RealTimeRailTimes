package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */
@Root(name = "Platform", strict=false)
public class Platform implements Parcelable {

    @Attribute
    public String Number;

    @Attribute
    public String Changed;

    @Attribute
    public String Parent;

    protected Platform() { }

    protected Platform(Parcel in) {
        Number = in.readString();
        Changed = in.readString();
        Parent = in.readString();
    }

    public static final Creator<Platform> CREATOR = new Creator<Platform>() {
        @Override
        public Platform createFromParcel(Parcel in) {
            return new Platform(in);
        }

        @Override
        public Platform[] newArray(int size) {
            return new Platform[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Number);
        dest.writeString(Changed);
        dest.writeString(Parent);
    }
}
