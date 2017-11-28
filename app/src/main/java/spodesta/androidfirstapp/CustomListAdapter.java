package spodesta.androidfirstapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> itemname;
    private final int[] imgid;
    private final ArrayList<String> teamsDescription;

    public CustomListAdapter(Activity context, ArrayList<String> itemname, int[] imgid, ArrayList<String> teamsDescription) {
        super(context, R.layout.teamlist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.teamsDescription = teamsDescription;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.teamlist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.teamName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView txtDescription = (TextView) rowView.findViewById(R.id.teamCity);

        txtTitle.setText(itemname.get(position));
        imageView.setImageResource(imgid[position]);
        txtDescription.setText(teamsDescription.get(position));

        return rowView;

    };
}