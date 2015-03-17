package poj;

import java.util.Scanner;

public class Q2262 {
	static int[] isPrime =new int[1000001];
	static int[] primes = new int[1000001];
	public static void main(String[] args) {
		int j = 0 ; 
		for(int i = 2; i<1000001; i ++){
//			System.out.println(i);
			if(isprime(i)){
				isPrime[i] = 1;
				primes[j++] = i;
			}
		}
//		System.out.println("init end");
		Scanner cin = new Scanner(System.in);
		while(true){
			int num =cin.nextInt();
			if(num == 0 )
				break;
			boolean  isSecuss = false;
			for(int i =0;i <j && primes[i]<num/2+1;i++){
				if(isPrime[num - primes[i]]==1){
					System.out.println(num +" = "+ primes[i]+" + "+(num - primes[i]));
					isSecuss = true;
					break;
				}
					
			}
			if(!isSecuss)
				System.out.println("Goldbach's conjecture is wrong.");
		}
		
		
		
	}
	private static boolean isprime(int i) {
		for(int j = 2;j<(int)Math.sqrt(i) + 1; j++){
			if(i%j ==0)
				return false;
		}
		return true;
	}
	
}
