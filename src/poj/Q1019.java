package poj;

import java.util.Scanner;

public class Q1019 {
	static long[] sums = {45,9000,1386450,188019000,23750235000l};
	static int[] sums1 = {9, 189, 2889,38889, 488889};
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		
		int count = cin.nextInt();
		for(int i = 0 ; i <count; i ++){
			long num = cin.nextInt();
			long sumsums =0;
			int j = 0 ;
			boolean con=false;
			for(; j <5; j ++){
				sumsums += sums[j];
				if(sumsums > num)
					break;
				else if (sumsums == num){
					System.out.println(9);
					con = true;
					break;
				}
			}
			if (con)
				continue;
			long rest = num - (sumsums - sums[j]);
			int index1 = getIndex1(rest, j);
			System.out.println(index1);
		}
	}

	private static int getIndex1(long rest, int j) {
//		System.out.println("rest:" + rest+",j:" + j);
		long sum1 = 0;
		for(int a = 0 ; a<j; a++){
			sum1 += 9 * Math.pow(10, a)*(a+1);
		}
		sum1 *=2;
		int b = 1;
		for(;b*(sum1 + (j+1) *(b+1))/2< rest ;b++){
		}
		rest -=(b-1)*(sum1 + (j+1) *(b))/2;
		return  getIndex2(rest, b);
		
		
		
	}

	private static int getIndex2(long rest, int b) {
//		System.out.println("rest:" + rest+",b:" + b);
		int i = 0 ;
		for(; sums1[i] <rest; i ++){
			
		}
			
		
		if(i == 0 )
			return (int)rest;
		
		rest -= sums1[i-1];
//		System.out.println("rest: " + rest+",i:" +i);
		int index3 = (int)rest/(i+1);
		int index4 = (int)(rest%(i+1));
//		System.out.println("rest:" + rest + ",i:" + i +",index3:" + index3 +",index4:" + index4);
		String str;
		if(index4 == 0 ){
			str = String.valueOf((int)Math.pow(10, i) -1 + index3);
//			System.out.println("str:" + str);
			return str.charAt(str.length()-1) - '0';

		}else{
			str = String.valueOf((int)Math.pow(10, i) + index3);
			return str.charAt(index4-1) - '0';
		}
		
		
		
	}

}