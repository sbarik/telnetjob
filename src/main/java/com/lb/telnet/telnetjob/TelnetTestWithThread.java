package com.lb.telnet.telnetjob;

import org.apache.commons.net.telnet.TelnetClient;

import com.lb.telnet.telnetjob.AutomatedTelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.SocketException;

public class TelnetTestWithThread extends Thread {
	public static String servers[] = {"cmh-db2connect-001.lbidts.com","cmh-nexus-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com","cmh-db2connect-001.lbidts.com","cmh-nexus-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com","cmh-db2connect-001.lbidts.com","cmh-nexus-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com","cmh-db2connect-001.lbidts.com","cmh-nexus-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com"};
	public static void main(String[] args) {
		
		 for(final String server: servers){
	      /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        
	         public void run() {
	            new AutomatedTelnetClient(server, "sbarik", "Summer15");  // Let the constructor do the job
	         }
	      });*/
			 /*System.out.println("telnet stat");
			 
			 Runnable doHelloWorld = new Runnable() {
			     public void run() {
			    	 new AutomatedTelnetClient(server, "sbarik", "Summer15");
			     }
			 };*/

			 Thread thread = new Thread(new Runnable() {
				   
				   public void run() {
				    //  for(String server: servers) {
				         try {
				        	 new AutomatedTelnetClient(server, "sbarik", "Summer15");
				            Thread.sleep(600);  
				         } catch (InterruptedException ex) {}
				      }
				  // }
				});
				thread.start();

		 }
	   }
	
}
