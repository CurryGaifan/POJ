package poj;

import java.util.Scanner;

public class Q1020 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		for(int i = 0 ;  i < count ; i ++){
			int size = cin.nextInt();
			int[] array = new int[size];
			int num = cin.nextInt();
			int[] array1 = new int[10];
			for(int j = 0 ; j < num ; j++){
				array1[cin.nextInt() -1 ] ++;
			}
			
			boolean success = filling(array, array1, 0, array.length);
//			while(true){
//				int index = searchLow(array);
//				int length  = getLowLength (array, index );
//				if( index == 0 &&  array[index] ==size && length == size)
//					break;
//				success = filling(array, array1, index, length);
//				if(!success)
//					break;
//			}
			
			if(success){
				System.out.println("KHOOOOB!");
			}else{
				System.out.println("HUTUTU!");
			}
			
			
		}

	}

//	private static boolean filling(int[] array, int[] array1) {
//		return filling( array,  array1, 0, array.length);
//	}

	private static boolean filling(int[] array, int[] array1, int index, int length) {
//		System.out.println("index = " + index + ", length = " + length);
//		for(int a : array){
//			System.out.print(a + " ");
//		}
//		
//		System.out.println();
//		for(int b : array1){
//			System.out.print(b + " ");
//		}
//		
//		System.out.println();
		
		
		if( index == 0 &&  array[index] ==array.length && length == array.length)
			return true;
		for(int i = Math.min (length -1, array1.length - 1) ; i >-1; i --){
			if(array1[i]>0){
				array1[i] --;
				for(int j=index ; j <index + i +1 ; j++){
					array[j] += (i +1);
				}
//				System.out.println("use " + (i+1));
				int index1 = searchLow(array);
				int length1  = getLowLength (array, index1 );
				boolean success = filling(array, array1, index1, length1);
				if(success){
//					System.out.println("trurn true");
					return true;
				}else {
					array1[i]++;
					for(int j=index ; j <index + i +1 ; j++){
						array[j] -= (i +1);
					}
				}
				
			}
		}

		
//		System.out.println("trurn false");
		return false;
	}

	private static int getLowLength(int[] array, int index) {
		
		int length = 1;
		
		for(int i = index + 1; i < array.length; i ++){

			if(array[i]!= array[index])
				break;
			length ++;
		}
		return length;
	}

	private static int searchLow(int[] array) {
		// TODO Auto-generated method stub
		int low = Integer.MAX_VALUE ;
		int index = Integer.MAX_VALUE;
		for(int i = 0  ; i< array.length ; i ++){
			if(array[i]<low){
				low = array[i] ;
				index = i ;
			}
				
		}
		
		return index;
	}

}
