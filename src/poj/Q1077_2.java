package poj;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1077_2 {
	static BitSet bs = new BitSet(362880);
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(true){
			int[][] array = new int[3][3];
			int m = -1;
			int n = -1;
			for(int i = 0; i < 3; i++){
				
				for(int j = 0; j < 3; j ++){
					String str = cin.next();
					if(str.equals("x")){
						m = i ;
						n = j ;
						array[i][j] = 9 ;
					}else{
						array[i][j] = Integer.valueOf(str);
					}
				}
			}
			bs.clear();
			Queue<String> queue = new LinkedList<String>();
			queue.add("");
			String path = go( bs, queue, array , m,  n);
			
			if(path!=null){
				
				System.out.println(path);
			}else {
				System.out.println("unsolvable");
			}
		}
	}

	private static String go(BitSet bs, Queue<String> queue, int[][] array, int m , int n ) {
		while(queue.size()!=0){
//			System.out.println(queue);
			String path = queue.poll();
			boolean success = getTempArray (array, path, m , n, queue);
			
			if(success)
				return path;

		}
		
		
		
		return null;
	}

	private static boolean getTempArray(int[][] array, String path, int m,
			int n,Queue<String> queue) {
		int temp;
		int[][] narray = new int[3][3];
		for(int i =0 ; i<3 ; i++){
			System.arraycopy(array[i], 0, narray[i], 0, 3);
		}
//		System.out.println(path);
		for(int i = 0; i< path.length(); i++){
			char c = path.charAt(i);
			
			if(c == 'u'){
				temp = narray[m][n];
				narray[m][n] = narray[m-1][n];
				narray[m-1][n] = temp;
				m--;
			}else if(c == 'd'){
				temp = narray[m][n];
				narray[m][n] = narray[m+1][n];
				narray[m+1][n] = temp;
				m++;
			}else if (c == 'l'){
				temp = narray[m][n];
				narray[m][n] = narray[m][n-1];
				narray[m][n-1] = temp;
				n--;
			}else if(c == 'r'){
				temp = narray[m][n];
				narray[m][n] = narray[m][n+1];
				narray[m][n+1] = temp;
				n++;
			}
		}
		int value = kangtuo(narray);;
		if(value ==0)
			return true;
		if(bs.get(value)){
			
		}else{
			bs.set(value);
			if(m>0 ){

					queue.add(path+"u");
				
			}
			
			if(m<2  ){

					queue.add( path+"d");

				
			}
			if(n>0 ){
				
					queue.add( path+"l");


				
			}
			
			
			
			if(n<2 ){

					queue.add( path+"r");
				
				
			}
		}
		return false;
	}
	
	
	private static int kangtuo(int[][] array) {
		int[] array1 = new int[10];
		int sum = 0 ;
		for(int i = 0 ; i <3; i++){
			for(int j = 0 ; j < 3; j++){
				int num = 0 ; 
				for(int k = 1 ; k < array[i][j]; k++){
					if(array1[k]==0)
						num ++;
					
				}
				sum += num* factorial[9 - i *3 -j -1];
				array1[array[i][j]] =1;
			}
		}
		return sum;
		
	}
	static int[] factorial = {1,1,2,6,24,120,720,5040,40320,3628800};


}