package poj;

import java.util.Scanner;

public class Q1012 {
	public static void main(String[] args){
		int[] array = new int[100];
		Scanner cin = new Scanner(System.in);
		while(true){
			int k = cin.nextInt();
			if(k == 0 ){
				break;
			}
			if(array[k]!=0){
				System.out.println(array[k]);
			}else{
				for(int i=1 ; ; i++){
					int m= (k+1)*i ;
//					System.out.println("m:" + m);
					boolean result = testM(k,m);
					
					if(result == true){
						System.out.println(m);
						break;
					}
					m ++;
//					System.out.println("m:" + m);
					result = testM(k,m);
					if(result == true){
						System.out.println(m);
						array[k] = m;
						break;
					}
					
				}
			}
			
			
		}
	}

	private static boolean testM(int k, int m) {
		int before;
		if(k==1&&m==2)
			return true;
		
		
		if(m%(2*k)>0 && m%(2*k)<=k)
			return false;
		before = (2*k -m%(2*k))%(2*k);
//		System.out.println("before:"+ before);
		int golength;
		for(int j = 1; j<k; j++){
			golength = m%(2*k-j);
			if(golength==0&& k-j > before){
				
			}else if(golength >0 && golength <=before){
				before -= golength;
			}else if(golength>before+k){
				before += (2*k-j-golength);
			}else{
				return false;
			}
//			System.out.println("before:"+ before);
		}
		return true;
	}

}
