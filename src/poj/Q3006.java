package poj;

import java.util.Scanner;

public class Q3006 {
	
	static int[] isPrime =new int[1000001];
//	static int[] primes = new int[1000001];
	public static void main(String[] args) {
//		int j = 0 ; 
//		for(int i = 2; i<1000001; i ++){
//			if(isprime(i)){
//				isPrime[i] = 1;
//			}
//		}
		
		Scanner cin = new Scanner(System.in);
		while(true){
			int a = cin.nextInt();
			int d = cin.nextInt();
			int n = cin.nextInt();
			int count =0;
			int sum = a;
			if((a | d | n)==0)
				break;
			while(count<n){
				
				if(isZh(sum)){
					count++;
				}
				
				sum+=d;
			}
			System.out.println(sum-d);
		}
		
		
		
	}
	public static boolean isZh(int p){
		if (p==1){
			return false;
		}
		if (p==2){
			return true;
		}
		if (p%2==0){
			return false;
		}
		for (int i=3;i*i<=p ;i=i+2 ){
			if (p%i==0){
				return false;
			}
		}
		return true;
	}
	
	private static boolean isprime(int i) {
		if(i==2)
			return true;
			
		if(i%2==0)
			return false;
		
		for(int j = 3;j<(int)Math.sqrt(i) + 1; j+=2){
			if(i%j ==0)
				return false;
		}
		return true;
	}

}
