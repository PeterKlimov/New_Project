package com.example.pk.new_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUpActivity extends ActionBarActivity implements View.OnClickListener {
    private EditText et_email, et_password, et_password2, et_f_name, et_l_name, et_phone, et_city, et_street, et_street_num;
    private Button btn_submit;
    private RadioButton rb_male, rb_female;
    private DatePicker dateP_birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password_signUp);
        et_password2 = (EditText) findViewById(R.id.et_password_signUp_2);
        et_f_name = (EditText) findViewById(R.id.et_first_name);
        et_l_name = (EditText) findViewById(R.id.et_last_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_city = (EditText) findViewById(R.id.et_address_city);
        et_street = (EditText) findViewById(R.id.et_street);
        et_street_num = (EditText) findViewById(R.id.et_street_number);
        rb_male = (RadioButton) findViewById(R.id.rb_male);
        rb_female = (RadioButton) findViewById(R.id.rb_female);
        dateP_birthday = (DatePicker) findViewById(R.id.dateP_birth);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_submit) {
            checkSignUp();
        }
    }

    private void checkSignUp() {
        String email = et_email.getText().toString().trim();
        String password1 = et_password.getText().toString().trim();
        String password2 = et_password2.getText().toString().trim();
        String first_name = et_f_name.getText().toString().trim();
        String last_name = et_l_name.getText().toString().trim();
        Toast.makeText(this, email + " " + password1 + " " + password2 + " " + first_name + " " + last_name, Toast.LENGTH_LONG).show();
        boolean validationError = false;
        StringBuilder validationErrorMessage = new StringBuilder(getString(R.string.intro));

        if (0 == email.length()) {
            validationError = true;
            et_email.setHintTextColor(Color.RED);
        }
        if (0 == password1.length())
        {
            validationError = true;
            et_password.setHintTextColor(Color.RED);
        }
        if (0 == password2.length())
        {
            validationError = true;
            et_password2.setHintTextColor(Color.RED);
        }
        if (0 == first_name.length())
        {
            validationError = true;
            et_f_name.setHintTextColor(Color.RED);
        }
        if (0 == last_name.length())
        {
            validationError = true;
            et_l_name.setHintTextColor(Color.RED);
        }
        if (validationError) {
            Toast.makeText(this, "Blank required fields", Toast.LENGTH_LONG).show();
            return;
        }
        et_password2.setTextColor(Color.GREEN);
        if (!password1.equals(password2)) {
            Toast.makeText(this, "Passwords must be equal", Toast.LENGTH_LONG).show();
            et_password2.setTextColor(Color.RED);
            return;
        }

        //Set up progress dialog
        final ProgressDialog dialog = new ProgressDialog((SignUpActivity.this));
        dialog.setMessage(getString(R.string.progress_signUp));
        dialog.show();

        //Set up a new Parse user
        ParseUser user = new ParseUser();
        user.setUsername(email);
        user.setPassword(password1);

        //Call the Parse sign up method
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                dialog.dismiss();
                if (e != null) {
                    Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
       String str= user.getObjectId();
Toast.makeText(this,str, Toast.LENGTH_LONG).show();

    }
}
