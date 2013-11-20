package com.example.servingfood;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servingfood.BackgroundTask;

public class FirstActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.FoodServing.MESSAGE";

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        
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
    
    private void showWarning() {
    	
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
   
    public void onClickedTable1(View view) {
    	Intent intent = new Intent(this, InitActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "Robot has been sent Table 1 \n Please Wait...");
    	startActivity(intent);
    	
	}
    public void onClickedTable2(View view) {
    	Intent intent = new Intent(this, InitActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "Robot has been sent Table 2 \n Please Wait...");
    	startActivity(intent);
	}
    public void onClickedTable3(View view) {
    	Intent intent = new Intent(this, InitActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "Robot has been sent Table 3 \n Please Wait...");
    	startActivity(intent);
	}
    public void onClickedTable4(View view) {
    	Intent intent = new Intent(this, InitActivity.class);
    	intent.putExtra(EXTRA_MESSAGE, "Robot has been sent Table 4 \n Please Wait...");
    	startActivity(intent);
	}
	
}
