package poj;

import java.util.Scanner;

public class Q1006 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int p;
		int e;
		int i;
		int d;
		for(int count =1;; count++){
			p = cin.nextInt();
			e = cin.nextInt();
			i = cin.nextInt();
			d = cin.nextInt();
			if( p == -1 && e ==-1 && i==-1 && d==-1)
				break;
			int j;
			for(j=0;(p - i + j*33)%23!=0||(e - i + j*33)%28!=0 ;j++);
//			System.out.println(j);
			int day = i - j*33;
			if( day > d )
				System.out.println("Case " + count + ": the next triple peak occurs in " + (day-d) + " days.");
			else if( day + 21252 >d){
				System.out.println("Case " + count + ": the next triple peak occurs in " + (day-d+21252) + " days.");
			}else{
				System.out.println("Case " + count + ": the next triple peak occurs in " + (day-d+21252*2) + " days.");
			}
			
		}
	}

}
