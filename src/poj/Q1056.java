package poj;

import java.util.Scanner;

public class Q1056 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String[] array = new String[10];
		int n= 1;
		for(;;n++){
			int i = 0 ;
			boolean success = true;
			for(; ; i++){
				array[i] = cin.nextLine();
				if(array[i].equals("9"))
					break;
			}
			for(int j = 0 ; j<i+1;j ++ ){
				for(int k = j +1; k<i +1; k++){
					if(array[j].startsWith(array[k]) || array[k].startsWith(array[j])){
						success =false;
						break;
					}
				}
				if(success ==false)
					break;
			}
			
			if(success)
				System.out.println("Set " + n + " is immediately decodable");
			else
				System.out.println("Set " + n + " is not immediately decodable");
			
		}
	}

}
