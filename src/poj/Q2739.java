package poj;

import java.util.Scanner;

public class Q2739 {
	static int[] primes =new int[10000];
	public static void main(String[] args) {
		int j = 0 ; 
		for(int i = 2; i<10001; i ++){
			if(isprime(i)){
				primes[j++] = i;
			}
		}
		int[] result = new int[10001];
		
		for(int i = 0 ; i < j ;i++){
			int sum = 0;
			for(int m = i ;m<j ; m++){
				sum+=primes[m];
				if(sum>10000)
					break;
				result[sum] ++;
			}
		}
		
//		System.out.println("init end");
		Scanner cin = new Scanner(System.in);
		while(true){
			int num = cin.nextInt();
			if(num == 0 )
				break;
			System.out.println(result[num]);
			
		}
		
		
		
		
	}
	private static boolean isprime(int i) {
		for(int j = 2;j<i; j++){
			if(i%j ==0)
				return false;
		}
		return true;
	}
	
	

}
