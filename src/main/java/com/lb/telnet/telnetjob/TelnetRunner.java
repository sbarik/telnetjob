package com.lb.telnet.telnetjob;

import java.util.Arrays;

public class TelnetRunner {

	 public static String servers[] = {"cmh-nexus-001.lbidts.com","cmh-db-001.lbidts.com",
			"ket-db-001.lbidts.com","cmh-svn-001.lbidts.com",
			"cmh-cohnwspd-001.lbidts.com","cmh-vsdpcohint-001.lbidts.com",
			"cmh-vsdpjetpd01-001.lbidts.com","cmh-db2connect-001.lbidts.com",
			"ket-vssdbd-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com",
			"ket-vsfdbqa-001.lbidts.com","ket-delpd-001.lbidts.com",
			"cmh-cdbviewpd-001.lbidts.com","ket-vsdpjetpd01-001.lbidts.com",
			"cmh-cohbbwetpd-001.lbidts.com","cmh-tc-001.lbidts.com"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] two = new String[servers.length/2];
	    String[] one = new String[servers.length - two.length];

	    for(int i=0;i<servers.length;i++){
	       
	        if(i<one.length)
	            one[i] = servers[i];
	        else
	            two[i-one.length] = servers[i];
	    }
	    System.out.println(Arrays.toString(one));
	    System.out.println(Arrays.toString(two));
	    TelnetThread t1 = new TelnetThread(one);
	    TelnetThread t2 = new TelnetThread(two);
	    t1.start();t2.start();
	}

}
