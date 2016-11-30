package com.example.armint.testtutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MoreInfo extends AppCompatActivity {

    private String   person;
    private String   info;
    private TextView title;
    private TextView description;
    private Button   contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        title       = (TextView)findViewById(R.id.person);
        description = (TextView)findViewById(R.id.description);
        contact     = (Button)findViewById(R.id.contact);
        intentHandle();

        title.setText(person);//should really be displaying the user name and not the real name.
        description.setText(info);

        contact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sendSMSMessage(person, "6048090795", "6043404297");
            }
        });
    }

    private void intentHandle() {
        Intent intent = getIntent();
        person = intent.getStringExtra("person");
        info   = intent.getStringExtra("descript");
        Toast.makeText(this, person, Toast.LENGTH_LONG);
    }

    //sends a message to the person asking for help. etc.
    private void sendSMSMessage(String name, String phoneNo, String userPhoneNo) {
        final String message;
        message = name + " " + getResources().getString(R.string.sms)
                + " " + userPhoneNo;

        try {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(this, getResources()
                    .getString(R.string.sent), Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(this, getResources()
                    .getString(R.string.fail), Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
