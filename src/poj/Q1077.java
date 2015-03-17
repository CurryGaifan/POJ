package poj;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1077 {
//	static Queue<int[][]> pool = new LinkedList<int[][]>();
//	static Set<Integer> set1 = new HashSet<Integer>();
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
//			int[] kangtuoarray = new int[362879];
//			BitSet bs = new BitSet(362880);
			bs.clear();
			Queue<Node> queue = new LinkedList<Node>();
			Node node = new Node(array, m, n, "");
			queue.add(node);
			Node node1 = go( bs, queue);
			
			if(node1!=null){
				
				System.out.println(node1.path);
			}else {
				System.out.println("unsolvable");
			}
		}
	}

	private static Node go(BitSet bs, Queue<Node> queue) {
		
		while(queue.size()!=0){
			Node node = queue.poll();
			int m = node.m;
			int n = node.n;
			String path = node.path;
//			System.out.println(path);
			int[][] array = node.array;
//			boolean success = check(array);
//			if(success)
//				return node;
			
			int value = kangtuo(array);;
			if(value ==0)
				return node;
			if(bs.get(value)){
				
			}else{
				bs.set(value);
				int tmp;
				int[][] narray;
				if(m>0 ){
					narray = getNewArray(array);
					tmp = narray[m][n];
					narray[m][n] = narray[m-1][n];
					narray[m-1][n] = tmp;
					value = kangtuo(narray);
					if(bs.get(value)){
						
					}else {
						queue.add(new Node(narray,m-1, n, path+"u"));
					}
					
				}
				
				if(m<2  ){
					narray = getNewArray(array);
					tmp = narray[m][n];
					narray[m][n] = narray[m+1][n];
					narray[m+1][n] = tmp;
					value = kangtuo(narray);
					if(bs.get(value)){
						
					}else {
						queue.add(new Node(narray,m+1, n, path+"d"));
					}
					
				}
				if(n>0 ){
					narray = getNewArray(array);
					tmp = narray[m][n];
					narray[m][n] = narray[m][n-1];
					narray[m][n-1] = tmp;
					value = kangtuo(narray);
					if(bs.get(value)){
						
					}else {
						queue.add(new Node(narray,m, n-1, path+"l"));
					}

					
				}
				
				
				
				if(n<2 ){
					narray = getNewArray(array);
					tmp = narray[m][n];
					narray[m][n] = narray[m][n+1];
					narray[m][n+1] = tmp;
					value = kangtuo(narray);
					if(bs.get(value)){
						
					}else {
						queue.add(new Node(narray,m, n+1, path+"r"));
					}
					
				}
//				pool.add(array);
				
			}
		}
		
		
		
		return null;
	}

	private static int[][] getNewArray(int[][] array) {
//		if(pool.size()==0){
		
			int[][] narray = new int[3][3];
		for(int i =0 ; i<3 ; i++){
			System.arraycopy(array[i], 0, narray[i], 0, 3);
		}
			
			return narray;
//		}else{
//			return pool.poll();
//		}
//		
		
	}

	private static int kangtuo(int[][] array) {
//		for(int i = 0 ; i <3; i++){
//			for(int j = 0 ; j < 3; j++){
//				System.out.print(array[i][j] + " ");
//			}
//		}
//		System.out.println();
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

	static class Node{
		int[][] array ;
		int m ;
		int n ;
		String path;
		public Node(int[][] array, int m, int n, String path) {
			super();
			this.array = array;
			this.m = m;
			this.n = n;
			this.path = path;
		}
		
	}
}