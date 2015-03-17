package poj;

import java.util.Scanner;

public class Q1050 {
	public static void main(String[] args) {
		
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		int[][] array = new int[count][count];
		for(int i = 0; i <count; i ++){
			for(int j =0; j<count ; j ++){
				array[i][j] = cin.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;
//		for(int i = 0 ; i <count ; i++){
//			int tmp = getMax(array[i]);
//			if(tmp> max)
//				max = tmp;
//		}
		
		for(int i = 0; i <count ; i++){
			int[] tmparray = new int[count];
			for(int j =i; j <count ; j ++){
				arrayadd (tmparray , array[j]);
				int tmp = getMax(tmparray);
				if(tmp> max)
					max = tmp;
			}
		}
		System.out.println(max);
		
	}

	private static void arrayadd(int[] tmparray, int[] is) {
		for(int i = 0 ; i <tmparray.length; i++){
			tmparray[i] += is[i];
		}
		
	}

	private static int getMax(int[] is) {
		int max = Integer.MIN_VALUE;
		int tmpsum = 0 ;
		for(int i = 0;i <is.length ; i++){
			if(tmpsum <0){
				tmpsum = 0 ;
			}
			tmpsum += is[i];
			if(tmpsum>max )
				max = tmpsum;
		}
		
		// TODO Auto-generated method stub
		return max;
	}

}
