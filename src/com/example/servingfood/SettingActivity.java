package com.example.servingfood;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		
	    SharedPreferences settings = getSharedPreferences( "SETTING_FILE" , 0);
	    String name = settings.getString("name", "null");
	    String ip = settings.getString("ip", "null");
	    String port = settings.getString("port", "null");
		
		EditText editTextIp = (EditText) findViewById(R.id.editTextIP);
		editTextIp.setText(ip);
		EditText editTextname = (EditText) findViewById(R.id.editTextName);
		editTextname.setText(name);
		EditText editTextPort = (EditText) findViewById(R.id.editTextPort);
		editTextPort.setText(port);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}
	
	public void save(View view) {
		
		EditText editTextIp = (EditText) findViewById(R.id.editTextIP);
		EditText editTextname = (EditText) findViewById(R.id.editTextName);
		EditText editTextPort = (EditText) findViewById(R.id.editTextPort);
		
		SharedPreferences preferences = getSharedPreferences("SETTING_FILE", Context.MODE_PRIVATE);
		SharedPreferences.Editor   editor = preferences.edit();
		editor.putString("name", editTextname.getText().toString());
		editor.putString("ip", editTextIp.getText().toString());
		editor.putString("port",editTextPort.getText().toString());
		editor.commit();
		
		Toast.makeText(this, "The changes have been saved...", 1).show();
		
		finish();
	}

}
