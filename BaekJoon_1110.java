package GitHub;

import java.io.*;
import java.util.*;

public class BaekJoon_1110 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int oldNum = Integer.parseInt(sc.nextLine());
		int count = 0;
		int newNum = oldNum;
		
		while(true) {
			int sum = 0;
			count++; 
			newNum = (newNum%10)*10+((newNum/10)+(newNum%10))%10;
			
			if(oldNum == newNum) {
				System.out.println(count);
				break;
			} 
	    }
	}

}
