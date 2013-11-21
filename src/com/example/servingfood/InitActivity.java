package com.example.servingfood;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InitActivity extends Activity {
	
	public static String EXTRA_MESSAGE = "com.example.FoodServing.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_init);
		
	    // Get the message from the intent
	    Intent intent = getIntent();
	    String message = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE);
	    
	    
	    TextView text = (TextView) findViewById(R.id.textViewMsg);
	    text.setText(message);

		tryToConnect2Robot();

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		Toast.makeText(this, "You cannot go back until previous task is done!!!", 3).show();

		//super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.init, menu);
		return true;
	}
		
	
	private boolean tryToConnect2Robot() {
		
		
		SharedPreferences preferences = getSharedPreferences("SETTING_FILE", Context.MODE_PRIVATE);
		SharedPreferences.Editor   editor = preferences.edit();
		editor.putString("name", "my Robot");
		editor.putString("ip", "192.168.2.1");
		editor.putString("port","8888");
		editor.commit();

		

//		SharedPreferences prfs = getSharedPreferences("SETTING_FILE", Context.MODE_PRIVATE);
//		
//	
//	    String Astatus = prfs.getString("name", "");
//	    String Astatus2 = prfs.getString("ip", "");
//	    String Astatus3 = prfs.getString("port", "");
		
		
		return true;
	}
	
	public void onClicked(View view) {
		EXTRA_MESSAGE = "done";
		finish();
	}

}
