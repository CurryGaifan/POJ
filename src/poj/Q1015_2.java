package poj;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Q1015_2 {
	static int[][] dp;
	static int[][] path;
	static int fix = 400;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int count = 1;
		for(;;count ++){
			int n = cin.nextInt();
			int m = cin.nextInt();
			if(n ==0 && m ==0)
				break;
			
			int[] p = new int[n];
			int[] d = new int[n];
			int[] v = new int[n];
			int[] s = new int[n];
			
			for(int i = 0 ; i< n ; i ++){
				p[i] = cin.nextInt();
				d[i] = cin.nextInt();
				v[i] = p[i] - d[i];
				s[i] = p[i] + d[i];
			}
//			System.out.println("v[]:");
//			for(int i = 0 ; i< n ; i ++){
//				System.out.print(v[i] + " ");
//			}
//			System.out.println();
			
			dp = new int[21][801];
			path = new int[21][801];
			
			for(int i = 0; i<21; i++){
				for(int j = 0; j <801; j++){
					dp[i][j] = -1;
				}
			}
			dp[0][0+fix] = 0; 
			
			//´òÓ¡
//			System.out.println("dp:");
//			for(int j = -400 + fix; j <= 400 + fix; j++){
//				System.out.print(dp[0][j] + "\t");
//				
//			}
//			System.out.println();
			
			for(int i = 1; i<m+1; i++){
				for(int j = -20*i + fix; j <= 20*i + fix; j++){
					int sum = -1;
					int sindex = -1;
					for(int k = -20*(i-1) + fix; k <= 20*(i-1) + fix  ; k++){
						
//						int sub = dp[i][j]-dp[i-1][k];
						if(dp[i-1][k] ==-1)
							continue;
						
						int sub = j - k;
						int index  = findIndex(sub,v, s , (i-1), k );
//						System.out.println("index: " + index);
						if(index != -1){
							
							
//								System.out.println("i:" + i +",j: " + j + ",k: " + k +",index: " + index+ ",sum:" +sum+",dp[i-1][k]:" + dp[i-1][k]+",s[index]: " + s[index]);
								if(sum ==-1){
									sum = dp[i-1][k] + s[index];
									sindex = index;
								}else if(sum<dp[i-1][k] + s[index]){
									sum = dp[i-1][k] + s[index];
									sindex = index;
								}
							
							
							
							
						}
						
						
					}
					
					if(sum!=-1){
						dp[i][j] = sum;
//						System.out.println("dp["+i +"]["+j+"]: " + dp[i][j]);
//						v[sindex] = Integer.MIN_VALUE;
						path[i][j] = sindex;
					}
					
					
				}
				//´òÓ¡
//				System.out.println("dp:");
//				for(int j = -400 + fix; j <= 400 + fix; j++){
//					System.out.print(dp[i][j] + "\t");
//					
//				}
//				System.out.println();
//				System.out.println("path:");
//				for(int j = -400 + fix; j <= 400 + fix; j++){
//					System.out.print(path[i][j] + "\t");
//					
//				}
//				System.out.println();
			}
			
			
			int index = searchDP(m);
			int prosecution =0;
			int defence = 0;
			SortedSet<Integer> map = new TreeSet<Integer>();
			for(int i = m ; i>0; i--){
				map.add(path[i][index] + 1);
				prosecution += p[path[i][index]];
				defence += d[path[i][index]];
				index = index - v[path[i][index]];
			}
			
			System.out.println("Jury #" + count);
			System.out.println("Best jury has value " + prosecution + " for prosecution and value " + defence + " for defence:");
			for(int a : map){
				System.out.print( " " + a );
			}
			System.out.println();
			System.out.println();
			
		}
	}
	private static boolean ifcontains(int index, int i, int k, int[] v) {
		
//		System.out.println("index: " + index + ",i: " + i +",k: " +k);
		boolean ifcontains = false;
		for(int j = i ; j>0; j--){
//			System.out.println("path["+j+"]["+k+"]:" + path[j][k] +",v[path[i][k]]:" +v[path[i][k]] + ",v[2]:" + v[2]);
			if(path[j][k] == index){
				ifcontains = true;
				break;
			}
			
			k = k - v[path[j][k]];
		}
//		System.out.println(ifcontains);
		return ifcontains;
	}
	private static int searchDP(int m) {
		int index = Integer.MIN_VALUE;
		for(int i=0; i<=20*m; i++){
			boolean r = false;
			boolean l = false;
			if(dp[m][fix +i ]!= -1){
				r = true;
			}
			if(dp[m][fix - i]!= -1){
				l = true;
			}
			
			if(r ==true && l==true){
				if(dp[m][fix +i]>dp[m][fix - i]){
					index = fix +i;
				}else {
					index = fix -i;
				}
				break;
			}else if(r == true){
				index = fix +i;
				break;
			}else if(l == true){
				index = fix -i ;
				break;
			}
		}
//		System.out.println("*******************" + index);
		
		return index;
	}
	private static int findIndex(int differ, int[] v, int[] s, int x, int y) {
		int index = -1;
//		System.out.println("differ: " + differ + ",x:" + x+ ",y:" + y);
		for(int i = 0 ; i<v.length; i++){
//			System.out.println("v[i]" + v[i] + ",differ:" + differ);
			if(v[i]== differ && !ifcontains(i, x, y , v )){
				if(index == -1){
					index = i;
				}else if(s[i]>s[index]){
					index = i;
				}
			}
		}
		
		return index;
	}

}
