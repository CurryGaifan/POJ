package poj;

import java.util.Scanner;

public class Q2159 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String str1 = cin.next();
		String str2 = cin.next();
		
		int[] array1 = new int[26];
		int[] array2 = new int[26];
		for(int i = 0 ; i < str2.length();i ++){
			array1[str1.charAt(i)-'A']++;
			array2[str2.charAt(i)-'A']++;
		}
		
		int[] sum1 = new int[101];
		int[] sum2 = new int[101];
		for(int  i = 0 ; i <26;i ++){
			sum1[array1[i]]++;
			sum2[array2[i]]++;
		}
		for(int i = 0;i <101;i++){
			if(sum1[i]!=sum2[i]){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
