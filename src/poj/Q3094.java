package poj;

import java.util.Scanner;

public class Q3094 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(true){
			String line = cin.nextLine();
			if(line.equals("#"))
				break;
			int sum =0; 
			int fac = 0 ;
			for(int i = 1;i < line.length()+1; i++){
				
				if(line.charAt(i-1) == ' ')
					fac = 0 ; 
				else
					fac = line.charAt(i-1)-'A'+1;
//				System.out.println("i:"+(i-1)+",fac:"+fac);
				sum+=i*fac;
			}
			System.out.println(sum);
			
		}
	}

}
