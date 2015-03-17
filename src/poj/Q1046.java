package poj;

import java.util.Scanner;

public class Q1046 {

	public static void main(String[] args) {
		int[] r = new int[16];
		int[] g = new int[16];
		int[] b = new int[16];
		Scanner cin = new Scanner(System.in);
		for(int i =0; i<16 ; i++){
			r[i] = cin.nextInt();
			g[i] = cin.nextInt();
			b[i] = cin.nextInt();
		}

		int rr;
		int gg;
		int bb;
		
		while(true){
		
			rr = cin.nextInt();
			gg = cin.nextInt();
			bb = cin.nextInt();
			if(rr==-1 && gg == -1 && bb== -1)
				break;
			int min =Integer.MAX_VALUE;
			int index = -1;
			for(int i =0; i<16 ; i++){
				double sum = Math.pow(rr-r[i], 2) + Math.pow(gg - g[i], 2) + Math.pow(bb - b[i], 2); 
				if(sum< min){
					min = (int)sum;
					index = i;
				}
			}
			System.out.println("(" + rr +","+ gg+","+ bb+") maps to (" + r[index] +"," + g[index]+","+b[index]+")");
		}
	
		
	}

}
