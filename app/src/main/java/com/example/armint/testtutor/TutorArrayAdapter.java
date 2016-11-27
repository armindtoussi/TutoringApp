package com.example.armint.testtutor;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Armin T on 2016-11-02.
 */

public class TutorArrayAdapter extends ArrayAdapter<String> {
    private Context  context;
    private String[] people;
    private String[] description;
    private Intent intent;

    public TutorArrayAdapter(Context context, int resource, String[] people, String[] description) {
        super(context, resource, people);

        this.description = description;
        this.context     = context;
        this.people      = people;
    }

    public View getView(int position, View converView, ViewGroup parent) {
        String person      = people[position];
        String info        = description[position];
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_layout, null);

        ImageView image = (ImageView)view.findViewById(R.id.icon);
        TextView text  = (TextView)view.findViewById(R.id.title);
        TextView descrip = (TextView)view.findViewById(R.id.descrip);

        text.setText(person);
        descrip.setText(info);
        return view;
    }
}
