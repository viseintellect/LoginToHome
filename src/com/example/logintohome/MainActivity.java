package com.example.logintohome;

import java.util.regex.Pattern;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	private EditText mUsername, mPassword;
	private Button mButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	    mButton = (Button)findViewById(R.id.button1);
	    mUsername = (EditText)findViewById(R.id.editText1);
	    mPassword = (EditText)findViewById(R.id.editText2);
	    
	    mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click   
            	mUsername = (EditText)findViewById(R.id.editText1);
        	    mPassword = (EditText)findViewById(R.id.editText2);
        	    
        	    if (!Pattern.matches("^[a-zA-Z0-9]{1,6}$", mUsername.getText().toString())) {
                    mUsername.setError("Oops! Username must have only 6 alphanumeric characters");
                    return;
                }
        	    
        	    if (!Pattern.matches("^[a-zA-Z0-9]{1,6}$", mPassword.getText().toString())) {
                    mPassword.setError("Oops! Password must have only 6 alphanumeric characters");
                    return;
                }
        	    
                Intent activityChangeIntent = new Intent(MainActivity.this, HomeActivity.class);
                activityChangeIntent.putExtra("userName",mUsername.getText().toString());
                MainActivity.this.startActivity(activityChangeIntent);
            }
        });
	    
	    mUsername.addTextChangedListener(new InputValidator(mUsername));
        mPassword.addTextChangedListener(new InputValidator(mUsername));     
	}
	
	private class InputValidator implements TextWatcher {
        private EditText et;

        private InputValidator(EditText editText) {
            this.et = editText;
        }

       
        public void afterTextChanged(Editable s) {
        	
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before,
                int count) {
            if (s.length() != 0) {
                switch (et.getId()) {
                case R.id.editText1: {
                    if (!Pattern.matches("^[a-zA-Z0-9]*$", s)) {
                        et.setError("Oops! Username must have only alphanumeric characters");
                    }
                }
                    break;

                case R.id.editText2: {
                    if (!Pattern.matches("^[a-zA-Z0-9]*$", s)) {
                        et.setError("Oops! Password must have only alphanumeric characters");
                    }
                }
                    break;
                }
            }
        }
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
