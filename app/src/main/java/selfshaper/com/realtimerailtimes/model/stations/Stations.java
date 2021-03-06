package selfshaper.com.realtimerailtimes.model.stations;

/**
 * Created by Paul.Allan on 30/07/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Stations {

    @SerializedName("stations")
    @Expose
    private List<Station> stations = new ArrayList<Station>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Stations() {
    }

    /**
     *
     * @param stations
     */
    public Stations(List<Station> stations) {
        this.stations = stations;
    }

    /**
     *
     * @return
     * The stations
     */
    public List<Station> getStations() {
        return stations;
    }

    /**
     *
     * @param stations
     * The stations
     */
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
