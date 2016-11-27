package com.example.armint.testtutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditProfile extends AppCompatActivity {

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

    private EditText name;
    private EditText uName;
    private EditText email;
    private EditText gdCrs;
    private EditText bdCrs;
    private EditText description;
    private Button   save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name        = (EditText) findViewById(R.id.newName);
        uName       = (EditText) findViewById(R.id.newUName);
        email       = (EditText) findViewById(R.id.newEmail);
        gdCrs       = (EditText) findViewById(R.id.newGoodCrs);
        bdCrs       = (EditText) findViewById(R.id.newBadCrs);
        description = (EditText) findViewById(R.id.newDescription);
        save        = (Button)   findViewById(R.id.saveChanges);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String nameVal  = name.getText().toString();
                final String uNameVal = uName.getText().toString();
                final String emailVal = email.getText().toString();
                final String goodVal  = gdCrs.getText().toString();
                final String badVal   = bdCrs.getText().toString();
                final String descrip  = description.getText().toString();

                if (!isValidName(nameVal))
                    name.setError(getString(R.string.invalName));

                if (!isValidEmail(emailVal))
                    email.setError(getString(R.string.invalEmail));

                if (!isValidCourse(goodVal))
                    gdCrs.setError(getString(R.string.invalGCrs));

                if (!isValidCourse(badVal))
                    bdCrs.setError(getString(R.string.invalBCrs));

                if(isValidName(nameVal)
                        && isValidEmail(emailVal)
                        && isValidCourse(goodVal)
                        && isValidCourse(badVal)) {
                    //add shit to save it to database later.
                    Toast.makeText(view.getContext(), "Data saved", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });
    }


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
}
