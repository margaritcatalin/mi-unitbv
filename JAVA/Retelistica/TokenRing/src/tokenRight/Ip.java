package tokenRight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ip {

	static public List<String> allIpsList = new ArrayList<String>();
	
	public static String generateNewIp(){
		
		int max = 255;
		boolean repeter = true;
		int part1;
		int part2;
		int part3;
		int part4;
		Random rnd = new Random();
		do{
			part1 = rnd.nextInt(max);
			part2 = rnd.nextInt(max);
			part3 = rnd.nextInt(max);
			part4 = rnd.nextInt(max);
			
			String returnedIp = new String (part1 + "." + part2 + "." + part3 + "." + part4);
			
			if(!allIpsList.contains(returnedIp)){
				allIpsList.add(returnedIp);
				return returnedIp;
			}
		}while(repeter);
		
		return null;
	}
}
