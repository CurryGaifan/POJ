package poj;

import java.util.Scanner;

public class Q1011 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(true){
			int count = cin.nextInt();
			if(count == 0)
				break;
			int[] array = new int[count];
			int sum = 0;
			int max =Integer.MIN_VALUE;
			for(int i = 0 ; i < count; i++){
				int l = cin.nextInt();
				sum+=l;
				array[i] = l;
				if(max<l)
					max = l;
					
			}
			System.out.println(getMin(array, sum, max));
		}
	}

	private static int getMin(int[] array, int sum, int max) {
		quickSort(array, 0, array.length-1);
//		for(int a:array){
//			System.out.print(a + " ");
//		}
//		System.out.println();
//		System.out.println("sum:  " + sum +",max: "+ max);
		for(int i = max ; i<=sum; i++){
//			System.out.println("i:" + i);
			if(sum%i!=0)
				continue;
			int[] used = new int[array.length];
			if(isScuss(array, used,  i, sum))
				return i;
		}
		return -1;
	}

	private static boolean isScuss(int[] array, int[] used, int i, int sum) {
		if(sum==0)
			return true;
		
		int a= 0;
		for( ; a < array.length&& used[a]==1; a ++);
		used[a]=1;
		if(helper(array, used, i, array[a],sum,  a+1))
			return true;
		else {
			
			used[a]=0;
//			System.out.println("i:" + i +", sum:"+sum+"can't find.");
			return false;
		}
	}
	
	

	private static boolean helper(int[] array, int[] used, int i, int j, int sum, int index) {
//		System.out.println("i="+i+",j="+j+",sum = "+sum +",index="+index );
		if(sum ==0){
//			System.out.println("sum = 0 ");
			return true;
		}
			
		
		if(i==j){
			sum-=i;
//			for(int u:used){
//				System.out.print(u+ " ");
//				
//			}
//			System.out.println();
			return isScuss(array, used, i, sum);
		}
		if(i<j)
			return false;
		int temp = -1;
		for(int a = index ; a < array.length; a ++){

			
			if(used[a] == 1)
				continue;
			
			if (array[a] == temp)
				continue;
			else
				temp = array[a];
			
			used[a]=1;
			if(helper(array, used, i, j+array[a], sum, a+1)){
//				System.out.print(array[a]+" ");
				return true;
			}else {
				used[a] = 0;
			}
		}
		return false;
		
	}

	private static void quickSort(int[] array, int low, int high) {
		if(low < high){
			int middle = getMiddle(array, low, high);
			quickSort(array, low, middle -1);
			quickSort(array, middle+1, high);
		}
		
	}

	private static int getMiddle(int[] array, int low, int high) {
		int temp = array[low];
		while(low < high){
			while(array[high]<=temp && low<high){
				high --;
			}
			array[low] = array[high];
			while(array[low] >= temp && low< high){
				low ++;
			}
			array[high] = array[low];
			
		}
		
		array[low] = temp;
		return low;
	}

}
