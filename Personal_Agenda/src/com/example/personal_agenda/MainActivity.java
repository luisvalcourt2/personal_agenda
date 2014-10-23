package com.example.personal_agenda;


import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	/* Explain Manifest File, Strings.xml, UI Tool
	 * Explain LogIn Button(onClick method)
	 * Explain Intent, Toast
	 * Explain Time, Write, Permissions, File Directory
	 * Explain File Manager
	 */
	
	private TextView username;
	private TextView password;
	private Button login;
	private Button clear;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); //Presents the view which the user will see the application starts.
		
		//Find and save the contents and values when application starts
		
		username = (TextView) findViewById(R.id.usernameText); //Explain the use of ID
		password = (TextView) findViewById(R.id.passwordText);
		login = (Button) findViewById(R.id.loginButton);
		clear = (Button) findViewById(R.id.clearButton);
		
		
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
	
	
	public void Log(View view){
		
		String my_username = "valcourt";
		String my_password = "8850";
		Intent intent = new Intent(this, Notes_Activity.class);   //Explain what and Intent is 
		if(username.getText().toString().equals(my_username) && password.getText().toString().equals(my_password)){
				Toast.makeText(this,"Existing User, loading data......", Toast.LENGTH_LONG).show();
				Log.e("User Found: ", username.getText().toString());
				startActivity(intent);
		}
		else{
			Toast.makeText(this,"Wrong Username/Password. Please Try Again", Toast.LENGTH_LONG).show();
			username.setText("");
			password.setText("");
		}
		
	}
	
	public void Clear(View view){
		username.setText("");
		password.setText("");
		
		
	}
	
}
