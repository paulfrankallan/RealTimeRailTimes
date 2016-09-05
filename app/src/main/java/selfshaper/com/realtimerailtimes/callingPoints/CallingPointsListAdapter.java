package selfshaper.com.realtimerailtimes.callingPoints;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import selfshaper.com.realtimerailtimes.R;
import selfshaper.com.realtimerailtimes.model.stationBoard.CallingPoint;

/**
 * Created by Paul.Allan on 31/07/2016.
 */
public class CallingPointsListAdapter extends ArrayAdapter<CallingPoint> {

    Context context;
    int layoutResourceId;
    List<CallingPoint> data = null;

    public CallingPointsListAdapter(Context context, int layoutResourceId, List<CallingPoint> data) {
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
            holder.txtCallingAtTime = (TextView) row.findViewById(R.id.list_item_calling_at_time_textview);
            holder.txtCallingAt = (TextView) row.findViewById(R.id.list_item_calling_at_textview);

            row.setTag(holder);
        } else {
            holder = (ServiceHolder) row.getTag();
        }

        CallingPoint callingPoint = data.get(position);
        holder.txtCallingAtTime.setText(callingPoint.etdep);
        holder.txtCallingAt.setText(callingPoint.Name);

        return row;
    }

    static class ServiceHolder {

        TextView txtCallingAtTime;
        TextView txtCallingAt;
    }
}