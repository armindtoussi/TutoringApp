package com.example.armint.testtutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private DBConnection con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con = new DBConnection();
        con.jsonRequest(this);
    }

    public void toAccount(View v) {
        Intent i = new Intent(this, CreateAccountView.class);
        startActivity(i);
    }

    public void onClick(View v) {
        Intent i = new Intent(this, UserView.class);
        EditText username = (EditText)findViewById(R.id.userName);
        EditText password = (EditText)findViewById(R.id.password);
        //if (con.loginCheck(this, username.getText().toString(), password.getText().toString())) {
            startActivity(i);
        //}
    }
}
