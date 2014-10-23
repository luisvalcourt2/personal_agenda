package com.example.personal_agenda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Notes_Activity extends Activity {



	private Button save;
	private Button clear;
	private TextView information;
	private File dir;
	Time today = new Time(Time.getCurrentTimezone());


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes_);

		information = (TextView) findViewById(R.id.information_text);
		save = (Button) findViewById(R.id.loginButton);
		clear = (Button) findViewById(R.id.clearButton);

		today.setToNow();


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notes_, menu);
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

	public void Clear(View view){
		information.setText("");


	}

	public void Save(View view){
		String filename = "Valcourt_TestFile" + today.monthDay + "_" + today.format("%k:%M:%S");
		String test = information.getText().toString();
		
		
		
		//Creates user file
		BufferedWriter output;
		dir = getAlbumStorageDir(filename);
		File file = new File(dir, filename);
		FileWriter writer;
		try {
			writer = new FileWriter(file,true);
			output = new BufferedWriter(writer);
			output.append(test.toString());
			Toast.makeText(this,"File Saved.", Toast.LENGTH_LONG).show();
			output.close();
		} catch (IOException e) {
			Toast.makeText(this,"Error, File not saved", Toast.LENGTH_LONG).show();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}

	public File getAlbumStorageDir(String albumName) {
	    // Get the directory for the user's public download directory. 
	    File file = new File(Environment.getExternalStoragePublicDirectory(
	            Environment.DIRECTORY_DOWNLOADS),"Valcourt");
	    if (!file.mkdirs()) {
	        Log.e("Error", "Directory not created");
	    }
	    return file;
	}


}
