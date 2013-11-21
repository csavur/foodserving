package com.example.servingfood;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import android.provider.ContactsContract.Contacts.Data;

public class Connection implements Runnable {
	
	private Thread thread;
	private Socket socket;
	private DataOutputStream out;
	private BufferedReader in;
	private boolean sendDataFlag = false;
	private FirstActivity ui;

	private String ip;
	private int port;
	private String inData = null;
	private String outData = null;
	
	public Connection( FirstActivity ui) {
		this.ui = ui;
		thread = new Thread(this, "conn");	
	}
	
	public void strt() {
		
	
		
		thread.start();
	}
	
	@Override
	public void run() {
	
		try {
			socket = new Socket( ip, port );
	        out = new DataOutputStream(socket.getOutputStream());
	        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		while (true) {
			inData = null;
			
			try {
				inData = in.readLine();
			} catch (IOException e) {
				System.err.println("celal there is a error during reading");
			}
			
			if (inData != null) {
				ui.showMessage(inData);
			}
			
//			try {
//				thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//			// Check the flag If there is a request for sending data	
//			if (sendDataFlag) {
//				try { 
//		            out.writeBytes(outData);
//		            sendDataFlag = false;
//		        } catch (IOException e) {
//		        	System.out.println("During sending data to server error has been accure");
//		        }
//			}
			
		}
	}

	public String getOutData() {
		return outData;
	}

	public void setOutData(String outData) {
		this.outData = outData;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getData() {
		return inData;
	}

	public void setData(String data) {
		this.inData = data;
	}

}
