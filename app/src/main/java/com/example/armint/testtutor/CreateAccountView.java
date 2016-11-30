package com.example.armint.testtutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountView extends AppCompatActivity {
    //standard email pattern
    private static final String EMAIL_PATTERN    = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //one Capital, one number and one symbol at least. min len 6
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
                                        + "(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

    //mind name len 8
    private static final int NAME_LEN   = 8;
    //min course len 4
    private static final int COURSE_LEN = 4;

    private TextView passMatcher;
    private EditText name;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmPass;
    private EditText gdCrs;
    private EditText bdCrs;
    private Button   makeAccount;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_view);

        intent = new Intent(this, UserView.class);
        //get text views
//        passMatcher = (TextView)findViewById(R.id.passMatch);


        //get the edit texts
        name        = (EditText) findViewById(R.id.enterName);
        username    = (EditText) findViewById(R.id.enterUserName);
        email       = (EditText) findViewById(R.id.enterEmail);
        password    = (EditText) findViewById(R.id.enterNewPassword);
        confirmPass = (EditText) findViewById(R.id.enterNewPasswordConfirm);
        gdCrs       = (EditText) findViewById(R.id.enterGoodCourse1);
        bdCrs       = (EditText) findViewById(R.id.enterBadCourse1);
        //get the button
        makeAccount = (Button) findViewById(R.id.makeAccountButton);

        //set button to check for validity and pass user to new intent
        makeAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String valEmail = email.getText().toString();
                final String valName = name.getText().toString();
                //*****need to add username validation with database search.*******
                final String valUname = username.getText().toString();
                final String valGdCrs = gdCrs.getText().toString();
                final String valBdCrs = bdCrs.getText().toString();
                final String valPass1 = password.getText().toString();
                final String valPass2 = password.getText().toString();


                if (!isValidName(valName))
                    name.setError(getString(R.string.invalName));

                if (!isValidEmail(valEmail))
                    email.setError(getString(R.string.invalEmail));

                if (!isValidCourse(valGdCrs))
                    gdCrs.setError(getString(R.string.invalGCrs));

                if (!isValidCourse(valBdCrs))
                    bdCrs.setError(getString(R.string.invalBCrs));

                if (!isValidPassword(valPass1))
                    password.setError(getString(R.string.invalPWord));

                ///need something tocheck that passwords match, i tried but failed
                // intially and now i jsut wanna work on someting else so im just doing this for now.
                // so i can work on IS.

                if(isValidName(valName)
                        && isValidEmail(valEmail)
                        && isValidCourse(valGdCrs)
                        && isValidCourse(valBdCrs)
                        && isValidPassword(valPass1)) {

                    final Person person;

                    person = new Person(valName, valEmail, valGdCrs, valBdCrs, valUname, valPass1);
                    Toast.makeText(view.getContext(), getResources().getString(R.string.userInfo), Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });
    }
//        confirmPass.addTextChangedListener(new TextWatcher() {
//            public void afterTextChanged(Editable s) {
//                final String valPass1;
//                final String valPass2;
//
//                valPass1 = password.getText().toString();
//                valPass2 = password.getText().toString();
//
//                if(!valPass1.equals(valPass2))
//                    passMatcher.setText(getString(R.string.pass));
//            }
//
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//            public void onTextChanged(CharSequence s, int start, int before, int count) {}
//        });




    public void cancel(View view) {
        finish();
    }


    private boolean isValidName(String name) {
        if(name.length() < NAME_LEN || name.matches(".*\\d+.*") || name == null) {
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        final Pattern pattern;
        final Matcher matcher;

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidCourse(String course) {
        if(course == null || course.length() < COURSE_LEN) {
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password) {
        final Pattern pattern;
        final Matcher matcher;

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    private boolean doPasswordsMatch(String passOne, String passTwo) {
        if(!passOne.equals(passTwo)) {
            return false;
        }
        return true;
    }
}
