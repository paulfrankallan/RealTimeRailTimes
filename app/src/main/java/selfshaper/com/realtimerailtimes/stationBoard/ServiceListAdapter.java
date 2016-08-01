package selfshaper.com.realtimerailtimes.stationBoard;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.model.stationBoard.Service;

/**
 * Created by Paul.Allan on 31/07/2016.
 */
public class ServiceListAdapter extends ArrayAdapter<Service> {

    Context context;
    int layoutResourceId;
    List<Service> data = null;

    public ServiceListAdapter(Context context, int layoutResourceId, List<Service> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ServiceHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ServiceHolder();
            holder.txtServiceTime = (TextView) row.findViewById(R.id.list_item_service_time_textview);
            holder.txtServiceDestination = (TextView) row.findViewById(R.id.list_item_service_destination_textview);
            holder.txtServicePlatform = (TextView) row.findViewById(R.id.list_item_service_platform_textview);
            holder.txtServiceExpected = (TextView) row.findViewById(R.id.list_item_service_expected_textview);

            row.setTag(holder);
        } else {
            holder = (ServiceHolder) row.getTag();
        }

        Service service = data.get(position);
        holder.txtServiceTime.setText(service.DepartTime.time);
        holder.txtServicePlatform.setText(service.Platform.Number);
        holder.txtServiceDestination.setText(service.Destination1.name);
        holder.txtServiceExpected.setText(service.ExpectedDepartTime.time);

        return row;
    }

    static class ServiceHolder {

        // Collapsed view data
        TextView txtServiceTime;
        TextView txtServiceDestination;
        TextView txtServicePlatform;
        TextView txtServiceExpected;

        // Expanded view data

    }
}