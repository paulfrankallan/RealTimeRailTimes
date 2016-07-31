package selfshaper.com.realtimerailtimes.stations;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.model.Station;

/**
 * Created by Paul.Allan on 31/07/2016.
 */
public class StationsListAdapter extends ArrayAdapter<Station> {

    Context context;
    int layoutResourceId;
    List<Station> data = null;

    public StationsListAdapter(Context context, int layoutResourceId, List<Station> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        StationHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new StationHolder();
            holder.txtStationName = (TextView)row.findViewById(R.id.list_item_station_textview);

            row.setTag(holder);
        }
        else
        {
            holder = (StationHolder) row.getTag();
        }

        Station station = data.get(position);
        holder.txtStationName.setText(station.getName());

        return row;
    }

    static class StationHolder
    {
        TextView txtStationName;
        TextView txtStationCode;
    }
}