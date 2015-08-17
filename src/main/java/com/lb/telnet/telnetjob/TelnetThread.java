package com.lb.telnet.telnetjob;

public class TelnetThread extends Thread{
	public void run()
	{
		 try {
	            for(String server: serverIPs){
	                System.out.println("Telnet : Connecting to "+ server);
	                AutomatedTelnetClient telnet = new AutomatedTelnetClient(server, "sbarik", "Summer15");
	                telnet.disconnect();
	                System.out.println("** Disconnected **"+ server);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
 TelnetThread(String servers[])
 {
	 this.serverIPs = servers;
 }
 
 String []serverIPs;
}
