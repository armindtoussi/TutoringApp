package com.example.armint.testtutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateAccountView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_view);
    }

    public void cancel(View view) {
        finish();
    }

    public void createAccount(View view) {
        Intent i = new Intent(this, UserView.class);
        startActivity(i);
    }
}
