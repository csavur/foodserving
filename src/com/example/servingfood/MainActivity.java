package com.example.servingfood;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import com.example.servingfood.BackgroundTask;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void showWarning() {
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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
    
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    	

    	
    	
//    	Intent intent = new Intent(this, DisplayMessageActivity.class);
//	   // EditText editText = (EditText) findViewById(R.id.edit_message);
//	   // String message = editText.getText().toString();
//    	intent.putExtra(EXTRA_MESSAGE, "Celal");
//	    startActivity(intent);
    }
   
    public void testConnection(View view) {
    	new BackgroundTask().execute("Selam");
	}
	
}
