package poj;

import java.util.Scanner;

public class Q2255 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(true){
			String pre = cin.next();
			String in = cin.next();
			helper(pre, in);
			System.out.println();
		}
	}

	private static void helper(String pre, String in) {
		
		
		if(pre.length()==0){
			return;
		}
		
		int index = in.indexOf(pre.substring(0,1));
		helper(pre.substring(1, index+1), in.substring(0,index));
		helper(pre.substring(index+1), in.substring(index+1));
		System.out.print(pre.substring(0,1));
	}

}
