package poj;

import java.util.Scanner;

public class Q1014_Recursion {
	public static void main(String[] args) {
		Scanner cin= new Scanner(System.in);
		
		for(int i=1;; i++){
			int[] array = new int[6];
			
			int sum = 0;
			boolean isbreak = true;
			for(int j = 0 ;j <6 ;j ++){
				array[j]=cin.nextInt();
				sum += array[j]*(j+1);
				if(array[j]!=0)
					isbreak =false;
			}
			if(isbreak)
				break;
			
			if(sum%2==1){
				System.out.println("Collection #" + i + ":");
				System.out.println("Can't be divided.");
				System.out.println();
				continue;
				
			}
//			int sum1=0;
//			int halfindex ;
//			for(halfindex = 0 ;halfindex <6 && sum1 < sum/2 ;halfindex ++){
//				sum1 += array[halfindex]*(halfindex+1);
//			}
			
			boolean result =help(array, sum/2, 0, findnext(array, 5));
			System.out.println("Collection #" + i + ":");
			if(result){
				System.out.println("Can be divided.");
			}else{
				System.out.println("Can't be divided.");
				
			}
			System.out.println();
		}
	}

	private static int findnext(int[] array, int i) {
		for(int j=i; j>-1; j--){
			if(array[j] != 0 )
				return j;
		}
		return -1;
	}

	private static boolean help(int[] array, int sum, int tmpsum, int j) {

//		for(int num :array){
//			System.out.print(num + " ");
//		}
//		System.out.println();
//		System.out.println("sum:"+ sum +", tmpsum:"+ tmpsum + ", j:"+ j);
		
		
		if(sum==tmpsum){
//			System.out.println("sum==tmpsum return true");
			return true;
		}if(sum<tmpsum || j <0){
//			System.out.println("sum<tmpsum || j <0 return true");
			return false;
		}else{
			
			int sum1=0;
			int halfIndex ;
			for(halfIndex = 0 ; sum1<(sum-tmpsum) ; halfIndex++){
				sum1 += array[halfIndex]*(halfIndex+1);
			}
			halfIndex --;
//			System.out.println("halfIndex:" + halfIndex);
			
			
			
			boolean result = false;
			for(; j>halfIndex-1&&!result; j--){
				int  subsum = 0 ;
				for(int i = 0; i< j;  i++){
					subsum += array[i]*(i)+1;
				}
				
				int mink=0;
				if(subsum<(sum - tmpsum)){
					if((sum- tmpsum - subsum)%(j+1) ==0)
						mink = (sum- tmpsum - subsum)/(j+1);
					else
						mink = (sum- tmpsum - subsum)/(j+1)+1;
				}
					
				
				for(int k = getMin(array[j], (sum - tmpsum)/ (j+1)); k>= mink && !result; k--){
					array[j] -=k;
					result =help(array, sum, tmpsum + k*(j+1), findnext(array,j-1));
					if(!result)
						array[j]+=k;
				}
			}
			if(result)
				return true;
			else 
				return false;
			
		}
		
	}

	private static int getMin(int i, int j) {
		if(i<j)
			return i;
		else return j;
	}


}
