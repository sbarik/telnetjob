package com.lb.telnet.telnetjob;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.SocketException;

public class AutomatedTelnetClient {

   // public static String servers[] = {"cmh-db2connect-001.lbidts.com","cmh-nexus-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com","cmh-db2connect-001.lbidts.com","cmh-nexus-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com","cmh-db2connect-001.lbidts.com","cmh-nexus-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com","cmh-db2connect-001.lbidts.com","cmh-nexus-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com"};

    private TelnetClient telnet = new TelnetClient();
    private InputStream in;
    private PrintStream out;
    private String prompt = "%";

    public AutomatedTelnetClient(String server, String user, String password) {
        try {
            // Connect to the specified server
			telnet.setConnectTimeout(200000);
            telnet.connect(server, 23);
            // Get input and output stream references
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());

            // Log the user on
            readUntil("Username:");
            write(user);
            readUntil("Password:");
            write(password);
        } catch (ConnectException e) {
            System.out.println("The Server is already connected : " + server);
            System.out.println("-----");
        }catch (IOException e) {
            System.out.print("The Server is already connected : "+ server);
        }
    }

    public void su(String password) {
        try {
            write("su");
            readUntil("Password: ");
            write(password);
            prompt = "#";
            readUntil(prompt + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            boolean found = false;
            char ch = (char) in.read();
            while (true) {
                System.out.print(ch);
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String value) {
        try {
            out.println(value);
            out.flush();
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendCommand(String command) {
        try {
            write(command);
            return readUntil(prompt + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect() {
        try {
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args) {
        try {
            for(String server: servers){
                System.out.println("Telnet : Connecting to "+ server);
                AutomatedTelnetClient telnet = new AutomatedTelnetClient(server, args[0], args[1]);
                telnet.disconnect();
                System.out.println("** Disconnected **"+ server);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}