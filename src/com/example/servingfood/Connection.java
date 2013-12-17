package com.example.servingfood;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Connection implements Runnable {
	
	private Thread thread;
	private Socket socket;
	private DataOutputStream out;
	private BufferedReader in;
	private boolean isOutDataReady = false;
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
		System.out.println("Thread Start");
		thread.start();
	}
	
	public void connect() {
		
		try {
			socket = new Socket( ip, port );
		
	        out = new DataOutputStream(socket.getOutputStream());
	        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			
		
			e.printStackTrace();
		} 
	}
	
	@Override
	public void run() {
		
		connect();
	
		while (true) {
			
			inData = null;
				
			if (isOutDataReady) {
				sendDatatoServer();
			}
			
			try {
				if(in.ready()) {
					inData = in.readLine();
				}
			} catch (IOException e) {
				System.err.println("celal there is a error during reading");
			}
			
			if (inData != null) {
				if(inData.trim().length() != 0) {
					ui.showMessage(inData);
				}
			}
			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("listening server!!!");
		}
	}
	
	private void sendDatatoServer()
	{
		try {
			out.writeBytes(outData);
			System.out.println("Sending data!!! :" + outData);
			isOutDataReady = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getOutData() {
		return outData;
	}

	public void setOutData(String outData) {
		this.outData = outData;
		isOutDataReady = true;
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
	
	public boolean isConnected() {
		return socket.isConnected();
	}

}
