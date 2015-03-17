package poj;

import java.math.BigDecimal;
import java.util.Scanner;

public class Q1001 {
	
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		String r;
		int  n;
		BigDecimal bd ;
		BigDecimal rs ;
		String pval;
		while(true){
//			sum = new BigDecimal(1);
			r = String.valueOf(cin.nextDouble());
			bd = new BigDecimal(r);
			n = cin.nextInt();
//			for(int i =0; i <n ; i++){
//				sum = sum .multiply(bd);
//			}
			rs = bd.pow(n);
			pval = rs.stripTrailingZeros().toPlainString();
			if(rs.compareTo(new BigDecimal(1))<0)
				pval = pval.substring(1);
			System.out.println(pval);
		}
	}

}
