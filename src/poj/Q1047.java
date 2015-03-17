package poj;

import java.math.BigDecimal;
import java.util.Scanner;

public class Q1047 {
	public static void main(String[] args) {
		Scanner cin  = new Scanner(System.in);
		while(true){
			String str = cin.next();
			BigDecimal num = new BigDecimal(str);
			char[] ch = str.toCharArray();
			BigDecimal tmp ;
			char[] tmpch1;
			char[] tmpch2;
			boolean success= true;
			for(int i = 2 ;  i < ch.length + 1; i++){
				tmp = num.multiply(new BigDecimal(i));
				tmpch1 = tmp.toPlainString().toCharArray();
				tmpch2 = new char[ch.length];
//				System.out.println(ch);
//				System.out.println(tmpch1);
				if(tmpch1.length > ch.length){
					success =false;
					break;
				}
					
				for(int j = 0 ; j < ch.length - tmpch1.length; j ++){
					tmpch2[j] = '0' ;
				}
//				System.out.println(tmpch2);
				System.arraycopy(tmpch1, 0, tmpch2, ch.length - tmpch1.length, tmpch1.length);
				success = compare(ch, tmpch2);
				if(!success)
					break;
			}
			if(success)
				System.out.println(str + " is cyclic" );
			else
				System.out.println(str + " is not cyclic");
			
		}
	}

	private static boolean compare(char[] ch, char[] tmpch2) {
		// TODO Auto-generated method stub
//		System.out.println(ch);
//		System.out.println(tmpch2);
		boolean  success = true;
		for(int i = 0 ;  i < ch.length; i++){
			success = true;
			for(int j = 0 ; j < ch.length; j ++){
				if(ch[(i+j)%ch.length] != tmpch2[j]){
					success = false;
					break;
				}
			}
			if(success)
				break;
		}
		return success;

	}

}
