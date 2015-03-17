package poj;

import java.util.Scanner;

public class Q1017 {
	static int[] array;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		array = new int[6];
		while(true){
			int sum = 0 ;
			int count = 0; 
			for(int i = 0; i<6 ; i++){
				array[i] = cin.nextInt();
				sum +=array[i];
			}
			
			if(sum == 0 )
				break;
			count += array[5];
//			System.out.println("6: " + count);
//			System.out.println("array[0]: " + array[0]);
			for(int i= 0; i<array[4]; i++){
				count ++;
				comsume1(11);
			}
//			System.out.println("5: " + count);
//			System.out.println("array[0]: " + array[0]);
			for(int i= 0; i<array[3]; i++){
				count ++;
				fourcomsume1_2(20);
			}
//			System.out.println("4: " + count);
//			System.out.println("array[0]: " + array[0]);
			while(array[2]>0){
				if(array[2]>=4){
					array[2] -=4;
				}else{
					threecomsume1_2(36-array[2]*9);
					array[2]= 0 ;
				}
				count ++;
			}
//			System.out.println("3: " + count);
//			System.out.println("array[0]: " + array[0]);
			
			while(array[1] > 0){
				if(array[1]>=9){
					array[1]-=9;
				}else {
					comsume1(36 - array[1]*4);
					array[1]= 0 ;
				}
				count ++;
			}
//			System.out.println("2: " + count);
//			System.out.println("array[0]: " + array[0]);
			count += Math.ceil(((float)array[0])/36);
//			System.out.println("1: " + count);
			System.out.println(count);
		}
		
	}
	private static void comsume1(int i) {
		if(array[0]>i)
			array[0] -=i;
		else
			array[0] = 0;
	}
	private static void fourcomsume1_2(int i) {
		if(array[1]>=5){
			array[1] -=5;
		}else{
			comsume1(i - array[1]*4);
			array[1] = 0;
		}
		
	}
	
	private static void threecomsume1_2(int i) {
		if(i ==9){
			if(array[1]>=1){
				array[1]-=1;
				comsume1(5);
			}else{
				comsume1(9);
			}
		}else if(i==18){
			if(array[1]>=3){
				array[1]-=3;
				comsume1(6);
			}else{
				array[1] = 0;
				comsume1(18-array[1]*4);
				
			}
			
			
		}else if(i==27){
			if(array[1]>=5){
				array[1]-=5;
				comsume1(7);
			}else{
				
				comsume1(27- array[1] *4);
				array[1] = 0;
			}
		}
		
	}

}
