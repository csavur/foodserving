package com.example.servingfood;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import android.os.AsyncTask;


class BackgroundTask  extends AsyncTask<String, Void, String> {
	
	private static Socket client;
	private DataOutputStream outToServer;
	private BufferedReader inFromServer;
	private String data = null;
	
	public boolean isConnected() {	
		return client.isConnected();	
	}
	protected String doInBackground(String... urls) {
		data = urls[0]; // data setting for other method
		
		enableConnection();	
		sendDataOverConnection();
		disableConnection();
		return "done";
	}
	
	protected void onPostExecute(String result) {
	   System.out.println(result);
	}
   
	private void initConnection( String addr) throws IOException
    {
        client = new Socket( addr, 8888);
        
        outToServer = new DataOutputStream(client.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }  
    
    private void enableConnection()
    {
        try {
            initConnection("129.21.144.153");
        } catch (IOException e) {
           System.out.println("when trying to enable connection, Error has been accored");
        }
    }
    
    private void disableConnection()
    {
        if(client != null)
        {
            try {
                client.close();
            } catch (IOException e) {
                System.out.println("Connection closed");
            }
        }   
    }
   
    private void sendDataOverConnection()
    {
        if(client != null) {
	        try { 
	            outToServer.writeBytes(data);
	        } catch (IOException e) {
	        	System.out.println("During sending data to server error has been accure");
	        }
        }
    }
	
}
