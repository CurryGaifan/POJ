package poj;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1503 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		BigInteger sum = new BigInteger("0");
		while(true){
			String line = cin.next();
//			System.out.println(line);
			if(line.equals("0"))
				break;
			sum = sum.add(new BigInteger(line));
		}
		
		System.out.println(sum.toString());
	}
}
