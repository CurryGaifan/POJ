package poj;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Q1015 {
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
			
			dp = new int[21][801];
			path = new int[21][801];
			
			for(int i = 0; i<21; i++){
				for(int j = 0; j <801; j++){
					dp[i][j] = -1;
				}
			}
			dp[0][0+fix] = 0; 
			
			int kl = 0+fix;
			int kr = 0+fix;
			int jl;
			int jr;
			
			
			
			for(int i = 1; i<m+1; i++){
				jl = Integer.MAX_VALUE ;
				jr = Integer.MIN_VALUE ;
				for(int k = kl; k<=kr; k++){
					if(dp[i-1][k]==-1)
						continue;
					for(int a = 0; a<n; a++){
						if(!ifcontains(a,i-1,k,v)){
							if(dp[i][k + v[a]] < dp[i-1][k] + s[a]){
								dp[i][k + v[a]] = dp[i-1][k] + s[a];
								path[i][k + v[a]] = a;
								if(k + v[a]<jl)
									jl = k+v[a];
								if(k+v[a]>jr)
									jr = k+v[a];
							}
							
							
						}
					}

				}
				kl = jl;
				kr = jr;
				
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
		
		boolean ifcontains = false;
		for(int j = i ; j>0; j--){
			if(path[j][k] == index){
				ifcontains = true;
				break;
			}
			
			k = k - v[path[j][k]];
		}
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
		return index;
	}

}
