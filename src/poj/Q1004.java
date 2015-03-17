package poj;

import java.util.Scanner;

public class Q1004 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		float f; 
		Float sum = 0f ;
		for(int i = 0 ; i<12; i++){
			f = cin.nextFloat();
			sum += f;
		}
		float avr = sum/12;
//		System.out.println(avr);
		String avr_str = String.valueOf(avr);
		int index = avr_str.indexOf(".");
//		System.out.println(index);
		int point3 = Integer.valueOf(avr_str.charAt(index + 3))-'0';
		int point2 = Integer.valueOf(avr_str.charAt(index + 2))-'0';
//		char point2_j = point3<'5'? point2 : Character.valueOf((point2 + 1));
//		System.out.println(point3 +" " + point2  +" "   );
		System.out.println("$" + avr_str.substring(0,index+2) + (point3<5? point2 : point2+1));
	}

}
