package com.lb.telnet.telnetjob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TelnetRunnerWithServerSpliter {
	private static List<String[]> splitArray(String[] originalArray, int chunkSize) {
		List<String[]> listOfArrays = new ArrayList<String[]>();
		int totalSize = originalArray.length;
		if(totalSize < chunkSize ){
		   chunkSize = totalSize;
		}
		int from = 0;
		int to = chunkSize;

		while(from < totalSize){
		    String[] partArray = Arrays.copyOfRange(originalArray, from, to);
		    listOfArrays.add(partArray);

		    from+= chunkSize;
		    to = from + chunkSize;
		    if(to>totalSize){
		        to = totalSize;
		    }
		}
		return listOfArrays;
		}
	
	public static void main(String[] args) {
		
		int batchSize = 3;
		
		String[] originalArray = {"cmh-nexus-001.lbidts.com","cmh-db-001.lbidts.com",
				"ket-db-001.lbidts.com","cmh-svn-001.lbidts.com",
				"cmh-cohnwspd-001.lbidts.com","cmh-vsdpcohint-001.lbidts.com",
				"cmh-vsdpjetpd01-001.lbidts.com","cmh-db2connect-001.lbidts.com",
				"ket-vssdbd-001.lbidts.com","ket-cohnwsdev05-001.lbidts.com",
				"ket-vsfdbqa-001.lbidts.com","ket-delpd-001.lbidts.com",
				"cmh-cdbviewpd-001.lbidts.com","ket-vsdpjetpd01-001.lbidts.com",
				"cmh-cohbbwetpd-001.lbidts.com","cmh-tc-001.lbidts.com"};
			List<String[]> listOfArrays = splitArray(originalArray, batchSize);
        
		for(String[] array : listOfArrays){
		    System.out.print(array.length + ", ");
		    System.out.println(Arrays.toString(array));
		    new TelnetThread(array).start();
		}
		}
}
