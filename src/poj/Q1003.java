package poj;

import java.util.Scanner;

public class Q1003 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		float f;
		while(true){
			f = cin.nextFloat();
			if(f == 0.00f){
				break;
			}
//			System.out.println(f);
			int count = getCount(f);
			System.out.println(count +" card(s)");
		}
		
	}

	private static int getCount(float f) {
		float sum = 0 ; 
		int i;
		for(i = 1;sum < f; i++){
			sum += 1f/(i+1);
//			System.out.println("**" + sum + "***" +i);
		}
		return i-1;
	}
}
