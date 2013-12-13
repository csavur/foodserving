package com.example.servingfood;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;




public class FirstActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.FoodServing.MESSAGE";

	int code = 9999; // this is for screen

	private Connection con;
	String d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);


		con = new Connection(this);

		con.setIp("172.20.10.7");
		con.setPort(8080);


		//Intent intent = new Intent(this, InitActivity.class);
		// EditText editText = (EditText) findViewById(R.id.edit_message);
		// String message = editText.getText().toString();
		//intent.putExtra(EXTRA_MESSAGE, "Trying to connect the robot...");
		//startActivity(intent);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void showWarning() {

		AlertDialog.Builder builder = new AlertDialog.Builder(FirstActivity.this);
		builder.setMessage("App cannot connecto Robot!!!\n" +
				"Please check settings").setTitle("Error");

		builder.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				System.out.println("Ok has been clicked");
			}
		});
		builder.setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				System.out.println("Cancel has been clicked");
			}
		});

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	public void onClickedConnect(View view) {
		
		//showWarning();
		con.strt();
		Button button = (Button) findViewById(R.id.button5);
		button.setVisibility(View.INVISIBLE);
	}

	public void onClickedTable1(View view) {

		Intent intent = new Intent(this, InitActivity.class);
		intent.putExtra(EXTRA_MESSAGE, "Robot has been sent Table 1 Please Wait...");
		startActivity(intent);
    	con.setOutData("1\n");
	}
	public void onClickedTable2(View view) {

		Intent intent = new Intent(this, InitActivity.class);
		intent.putExtra(EXTRA_MESSAGE, "Robot has been sent Table 2 Please Wait...");
		startActivityForResult(intent, code);
    	con.setOutData("2\n");
	}
	public void onClickedTable3(View view) {
		Intent intent = new Intent(this, InitActivity.class);
		intent.putExtra(EXTRA_MESSAGE, "Robot has been sent Table 3 Please Wait...");
		startActivityForResult(intent, code);
    	con.setOutData("3\n");
	}
	public void onClickedTable4(View view) {
		Intent intent = new Intent(this, InitActivity.class);
		intent.putExtra(EXTRA_MESSAGE, "Robot has been sent Table 4 Please Wait...");
		startActivityForResult(intent, code);
    	con.setOutData("4\n");
	}

	public void showMessage(String msg) {

		System.out.println("Message : " + msg);  	

		if( msg != null ) {
			if ( Integer.parseInt(msg) == 0 ) {
				System.out.println("I am in");
				Intent intent = new Intent(this, InitActivity.class);
				intent.putExtra(EXTRA_MESSAGE, "Robot is not available. Please Wait...");
				startActivityForResult(intent, code);
			}
			else {
				System.out.println("I am out");
				finishActivity(code);
			}
		}
	}

}
