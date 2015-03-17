package poj;

import java.util.Scanner;

public class Q1028 {

	public static void main(String[] args) {
		int factor = 10;
		String[] webSite = new String[1];
		String[] tmp;
		webSite[0] = "http://www.acm.org/";
		Scanner cin = new Scanner(System.in);
		int current = 0;
		int end = 0;
		while(true){
			String str = cin.next();
			if(str.equals("VISIT")){
				if(current == webSite.length - 1){
					tmp = webSite;
					webSite = new String[tmp.length*factor];
					System.arraycopy(tmp, 0, webSite, 0, tmp.length);
				}
				
				webSite[++current] = cin.next();
				end = current;
				System.out.println(webSite[current]);
			} else if (str.equals("BACK")) {
				if(current == 0 ){
					System.out.println("Ignored");
				}else{
					System.out.println(webSite[--current]);
				}
			} else if (str.equals("FORWARD")) {
				if(current == end){
					System.out.println("Ignored");
				}else{
					System.out.println(webSite[++current]);
				}
			} else if(str.equals("QUIT")){
				break;
			}
		}
		
		
	}

}