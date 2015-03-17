package poj;

import java.util.Scanner;

public class Q1068 {
	public static void main(String[] args) {
		Scanner cin= new Scanner(System.in);
		int count  = cin.nextInt();
		for(int i = 0 ; i <count; i++){
			int count1 = cin.nextInt();
			int[] array = new int[40];
			int index = 0;
			int left_count = 0 ;
			for(int j = 0 ; j <count1; j ++){
				
				
				
				int n = cin.nextInt();
				for(int a = 0 ; a <n -left_count ; a++){
					array[index++] = -1;
				}
				left_count =n;
				array[index++] = 1;
			}
			for(int j = 1; j < index; j++){
				if(array[j]== -1)
					continue;
				int right_count =1;
				int a = j-1;
				for(; a>-1&& right_count !=0; a--){
					if(array[a] == -1)
						right_count--;
					else
						right_count ++;
				}
				System.out.print((j-a)/2 + " ");
			}
			System.out.println();
		}
	}

}