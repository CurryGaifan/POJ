package poj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1067 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		
		for(int i = 0 ; i < 1000000002; i++){
			for(int j =0 ; j < 1000000002;j ++){
				
				if(i==0 && j==0){
					set.add(i +" " + j);
				}else if(i==0 || j ==0 ||i ==j )
					continue;
				
				if(calu(set, i , j ) == 0 )
					set.add(i +" "+j);
				
			}
			System.out.println(i);
		}
		System.out.println("dp end");
		Scanner cin = new Scanner(System.in);
		while(true){
			int a = cin.nextInt();
			int b = cin.nextInt();
			if(set.contains(a+" "+b))
				System.out.println(0);
			else 
				System.out.println(1);
			
		}
		
		
		
	}

	private static int calu(Set<String> set, int i, int j) {
		for(int m  = 0 ;m < i; m ++){
			if(set.contains(m+" "+j))
				return 1;
		}
		for(int n  = 0;n <j ; n++){
			if(set.contains(i +" " +n) )
				return 1;
		}
		for(int a = 1; i-a>-1 && j-1>-1; a++){
			if(set.contains((i-a) +" "+(j-a)))
				return 1;
		}

		return 0;
	}
	
	

}
