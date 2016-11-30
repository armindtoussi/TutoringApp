package com.example.armint.testtutor;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public View getView(final int position, View converView, ViewGroup parent) {
        String person      = people[position];
        String info        = description[position];
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_layout, null);



        ImageView image  = (ImageView)view.findViewById(R.id.icon);
        TextView text    = (TextView)view.findViewById(R.id.title);
        TextView descrip = (TextView)view.findViewById(R.id.descrip);
        Button moreInfo  = (Button)view.findViewById(R.id.moreInfo);
        Button contact   = (Button)view.findViewById(R.id.contact);

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(view.getContext(), MoreInfo.class);
                intent.putExtra("person", people[position]);
                intent.putExtra("descript", description[position]);
                view.getContext().startActivity(intent);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSMessage(people[position], "6048090795", "6043404297");//dummy data, will get from clicked object.
            }

        });

        text.setText(person);
        descrip.setText(info);
        return view;
    }

    private void sendSMSMessage(String name, String phoneNo, String userPhoneNo) {
        final String message;
        message = name + " " + getContext().getResources().getString(R.string.sms)
                       + " " + userPhoneNo;

        try {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getContext(), getContext().getResources()
                    .getString(R.string.sent), Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getContext(), getContext().getResources()
                    .getString(R.string.fail), Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
