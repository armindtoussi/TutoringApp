package com.example.armint.testtutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //I'm adding this to piss armin off -justin
    //I'm adding this to piss justin off -brandon
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View v) {
        Intent i = new Intent(this, UserView.class);
        startActivity(i);
    }
}
