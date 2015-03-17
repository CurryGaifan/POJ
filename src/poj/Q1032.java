package poj;

import java.util.Scanner;

public class Q1032 {
	public static void main(String[] args) {
		int[] n = new int[46];
		int sum = 0 ;
		for(int i = 2 ; i< 48; i ++){
			sum += i;
			n[i-2] = sum ;
		}
		
		Scanner cin = new Scanner(System.in);
		
//		while(true){
			int num = cin.nextInt();
			int index = find(n, num );
			int o = num - n[index];
			int a = o/(index +1);
			int b = o %(index +1);
//			System.out.println(a + " " + b);
			for(int i = 0; i< index+1; i++){
				if(i< index + 1 - b){
					System.out.print((i+2+a) + " ");
				}else {
					System.out.print((i+a+3) + " ");
				}
			}
//		}
	}

	private static int find(int[] n, int num) {
		for(int i =0; i< n.length; i++){
			if(num<n[i]){
//				System.out.println(i-1);
				return i -1;
			}
		}
		
		return -1;
	}

}
