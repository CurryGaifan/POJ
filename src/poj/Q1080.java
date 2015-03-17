package poj;

import java.util.Scanner;

public class Q1080 {
	public static void main(String[] args) {
		int[][] socre = new int[85][85];
		socre['A']['A'] = 5;
		socre['A']['C'] = -1;
		socre['A']['G'] = -2;
		socre['A']['T'] = -1;
		socre['A']['-'] = -3;
		
		socre['C']['A'] = -1;
		socre['C']['C'] = 5;
		socre['C']['G'] = -3;
		socre['C']['T'] = -2;
		socre['C']['-'] = -4;
		
		socre['G']['A'] = -2;
		socre['G']['C'] = -3;
		socre['G']['G'] = 5;
		socre['G']['T'] = -2;
		socre['G']['-'] = -2;
		
		socre['T']['A'] = -1;
		socre['T']['C'] = -2;
		socre['T']['G'] = -2;
		socre['T']['T'] = 5;
		socre['T']['-'] = -1;
		
		socre['-']['A'] = -3;
		socre['-']['C'] = -4;
		socre['-']['G'] = -2;
		socre['-']['T'] = -1;
		
		
		
		
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		for(int i = 0 ; i < count; i ++){
			int m = cin.nextInt();
			char[] s1 = cin.next().trim().toCharArray();
//			System.out.println(s1);
			int n = cin.nextInt();
			char[] s2 = cin.next().trim().toCharArray();
//			System.out.println(s2);
			int[][] dp = new int[m+1][n+1];
			dp[0][0] = 0;
			for(int a = 1; a <n+1; a++){
				dp[0][a] = dp[0][a-1] + socre['-'][s2[a-1]];
			}
			
			for(int b = 1; b <m+1; b++){
				dp[b][0] = dp[b-1][0] + socre[s1[b-1]]['-'];
			}
			                            
			for(int a = 1; a< m+1; a++){
				for(int b = 1; b< n+1; b++){
					if(s1[a-1]==s2[b-1]){
						dp[a][b] = dp[a-1][b-1] + 5;
					}else{
						int lu = dp[a-1][b-1] + socre[s1[a-1]][s2[b-1]];
						int nk = dp[a][b-1] + socre['-'][s2[b-1]];
						int mk = dp[a-1][b] + socre[s1[a-1]]['-'];
						int max = Math.max(lu, nk);
						max = Math.max(max, mk);
						dp[a][b] = max;
						
						
					}
				}
			}
			
			System.out.println(dp[m][n]);
			
//			for(int a =0 ; a<m+1; a++){
//				for(int b = 0 ; b< n+1;b++){
//					System.out.print(dp[a][b] + " ");
//				}
//				System.out.println();
//			}
		}
	}

}
