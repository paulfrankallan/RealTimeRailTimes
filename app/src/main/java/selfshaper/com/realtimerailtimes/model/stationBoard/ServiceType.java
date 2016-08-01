package selfshaper.com.realtimerailtimes.model.stationBoard;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Paul.Allan on 31/07/2016.
 */
@Root(name = "ServiceType")
public class ServiceType implements Parcelable {

    @Attribute
    private String Type;

    protected ServiceType() {}

    protected ServiceType(Parcel in) {
        Type = in.readString();
    }

    public static final Creator<ServiceType> CREATOR = new Creator<ServiceType>() {
        @Override
        public ServiceType createFromParcel(Parcel in) {
            return new ServiceType(in);
        }

        @Override
        public ServiceType[] newArray(int size) {
            return new ServiceType[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Type);
    }
}