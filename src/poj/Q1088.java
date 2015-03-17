package poj;

import java.util.Scanner;

public class Q1088 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int r =cin.nextInt();
		int c = cin.nextInt();
		int[][] array = new int[r][c];
		int[][] array1 = new int[r][c];
		for(int i =0; i<r; i++){
			for (int j = 0; j < c; j++) {
				array[i][j] = cin.nextInt();
			}
		}
		for(int i =0; i<r; i++){
			for (int j = 0; j < c; j++) {
				if(array1[i][j] == 0){
					getLong(array, array1, i, j);
				}
			}
		}
		int max = 0 ; 
		for(int i =0; i<r; i++){
			for (int j = 0; j < c; j++) {
				if(array1[i][j]> max){
					max = array1[i][j];
				}
			}
		}
		System.out.println(max);
		
		
	}

	private static int getLong(int[][] array, int[][] array1, int i, int j) {
		if(array1[i][j]!=0)
			return array1[i][j];
		
		
		int r = array.length;
		int c = array[0].length;
		int max = 1 ;
		int tmp;
		if(i != 0 && array[i][j] > array[i-1][j]){
			tmp = 1 + getLong(array, array1, i-1, j);
			if(tmp>max){
				max = tmp;
			}
		}
		
		if(i != r-1 && array[i][j] > array[i+1][j]){
			tmp = 1 + getLong(array, array1, i+1, j);
			if(tmp>max){
				max = tmp;
			}
		}
		
		if(j != 0 && array[i][j]> array[i][j-1]){
			tmp = 1 + getLong(array, array1, i, j-1);
			if(tmp>max){
				max = tmp;
			}
		}
		
		if(j != c-1&& array[i][j]> array[i][j+1]){
			tmp = 1 + getLong(array, array1, i, j+1);
			if(tmp>max){
				max = tmp;
			}
		}
		
		
		array1[i][j] = max;
		return max;
	}

}
