package com.example.armint.testtutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MoreInfo extends AppCompatActivity {

    private String person;
    private String info;
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        title       = (TextView)findViewById(R.id.person);
        description = (TextView)findViewById(R.id.description);
        intentHandle();

        title.setText(person);//should really be displaying the user name and not the real name.
        description.setText(info);
    }

    public void intentHandle() {
        Intent intent = getIntent();
        person = intent.getStringExtra("person");
        info   = intent.getStringExtra("descript");
        Toast.makeText(this, person, Toast.LENGTH_LONG);
    }
}
