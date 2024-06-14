package dhthuyloi.cntt.lubuapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import dhthuyloi.cntt.lubuapp.model.Task;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> arrtask;
    private final Activity context;
    private int lastPosition = -1;
    public CustomAdapter(Activity context, ArrayList<Task> arrtask) {
        super(context, R.layout.item_row_inbox,arrtask);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.arrtask=arrtask;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_row_inbox, null,true);

        Task task = arrtask.get(position);
        TextView title =  rowView.findViewById(R.id.title);
        TextView time = (TextView) rowView.findViewById(R.id.time);
        TextView day = (TextView) rowView.findViewById(R.id.day);
        title.setText(arrtask.get(position).getTitle());
        time.setText(String.valueOf(arrtask.get(position).getTime()));
        day.setText(arrtask.get(position).getDay());
        return rowView;
    };

}
