package poj;

import java.util.Scanner;

public class Q1005 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
//		cin.nextLine();
//		String line;
		float x;
		float y;
		int year;
		for(int i=0; i<count; i++){
			x = cin.nextFloat();
			y = cin.nextFloat();
			year = (int)((x*x+y*y)*Math.PI/100)+1;
			System.out.println("Property "+ (i+1) + ": This property will begin eroding in year "+ year +".");
		}
		System.out.println("END OF OUTPUT.");
	}
	
	
	
}
