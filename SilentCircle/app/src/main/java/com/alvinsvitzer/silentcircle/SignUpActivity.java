package com.alvinsvitzer.silentcircle;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SignUpActivity extends ActionBarActivity {

    @InjectView(R.id.userNameField) EditText mUsername;
    @InjectView(R.id.passwordField) EditText mPassword;
    @InjectView(R.id.emailField) EditText mEmail;
    @InjectView(R.id.signUpbutton) Button mSignUpButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                String email = mEmail.getText().toString();

                username = username.trim();
                password = password.trim();
                email = email.trim();

                if (username.isEmpty() || password.isEmpty() || email.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);

                    //Set the message of the dialog box from a string resource
                    builder.setMessage(R.string.signup_error_message);
                    //Set the title of the dialog box from a string resources
                    builder.setTitle(R.string.signup_error_title);
                    //Leverage android's stock positive button for ok
                    builder.setPositiveButton(android.R.string.ok, null);

                    //Create the dialog box and show it
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else{
                    //create new user here
                    ParseUser user = new ParseUser();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);

                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null){
                                //success (no exception thrown)
                                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            }
                            else {

                                //Show data validation error as dialog box from Parse exception

                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);

                                //Set the message of the dialog box from a string resource
                                builder.setMessage(e.getMessage());
                                //Set the title of the dialog box from a string resources
                                builder.setTitle(R.string.signup_error_title);
                                //Leverage android's stock positive button for ok
                                builder.setPositiveButton(android.R.string.ok, null);

                                //Create the dialog box and show it
                                AlertDialog userDialog = builder.create();
                                userDialog.show();

                            }
                        }
                    });
                }
            }
        });
        ButterKnife.inject(this);

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
}
