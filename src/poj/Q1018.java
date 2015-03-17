package poj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1018 {
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		for(int i = 0 ; i<count ; i++){
			int count1 = cin.nextInt();
			int[][] b = new int [count1][100];
			int[][] p = new int [count1][100];
			int[] length = new int[count1];
			Set<Integer> set = new HashSet<Integer>();
			for(int j = 0; j <count1 ; j++ ){
				int count2 = cin.nextInt();
				for(int k = 0; k <count2 ; k++ ){
					b[j][k] = cin.nextInt();
					p[j][k] = cin.nextInt();
				}
//				myPrint(b[j], p[j],count2);
				
				
				quick(p[j], count2, b[j]);
//				myPrint(b[j], p[j],count2);
				
				int max_b  = b[j][0];
				int last_p = p[j][0];
				int nlength = 0;
				for(int k = 0; k<count2 ; k ++){
					if(p[j][k] == last_p){
						if(b[j][k] > max_b){
							max_b = b[j][k];
						}
					}else{
						b[j][nlength] = max_b;
						p[j][nlength] = last_p;
						nlength++;
						last_p = p[j][k];
						max_b = b[j][k];
					}
				}
				b[j][nlength] = max_b;
				p[j][nlength] = last_p;
				nlength++;
//				myPrint(b[j], p[j],nlength);
				
				quick(b[j], nlength, p[j]);
//				myPrint(b[j], p[j],nlength);
				int min_p  = p[j][0];
				int last_b = b[j][0];
				int nlength2 = 0 ;
				for(int k = 0; k<nlength ; k ++){
					if(b[j][k] == last_b){
						if(p[j][k] < min_p){
							min_p = p[j][k];
						}
					}else{
						b[j][nlength2] = last_b;
						p[j][nlength2] = min_p;
						nlength2++;
						last_b = b[j][k];
						min_p = p[j][k];
					}
				}
				b[j][nlength2] = last_b;
				p[j][nlength2] = min_p;
				nlength2++;
//				myPrint(b[j], p[j],nlength2);
				
				for(int a =0; a<nlength2; a++){
					for(int c = a+1; c<nlength2; c++){
						if(p[j][c]>p[j][a]){
							p[j][c] =p [j][nlength2-1];
							nlength2--;
							c--;
						}
					}
					
				}
//				myPrint(b[j], p[j],nlength2);
				length[j] = nlength2;
				for(int a = 0; a<nlength2; a++){
					set.add(b[j][a]);
				}
				
				
			}
			
			int sum;
			float max = Float.MIN_NORMAL;
			for(int tmp_b :set){
//				System.out.println("tmp_b: " +tmp_b);
				
				sum =0;
				boolean isfind = true;
				for(int x=0; x<count1; x++){
//					int index = findP(b[x],length[x],tmp_b);
					int index = findP(b[x],0,length[x]-1,tmp_b);
//					System.out.println("index:" + index);
					if(index==-1){
						isfind= false;
						break;
					}else{
						sum += p[x][index];
					}
					
					
				}
				
				if(isfind){
					if(((float)tmp_b)/sum>max)
						max = ((float)tmp_b)/sum;
				}
				
			}
			
			
//			float max = getMaxb_p(b,p,length,b[0][0],Integer.MIN_VALUE,0,count1);
			System.out.println(String.format("%.3f",max));
			
			
			
			
			
		}
	}
	private static int findP(int[] p , int start, int end, int tmpB){
		if(tmpB> p[0])
			return -1;
		if(tmpB<p[end])
			return end;
		if(start==end)
			return end;
		
		if(start+1 == end)
			if(tmpB== p[end])
				return end;
			else 
				return start;

		int mid = (end+start)/2;
		
		if(tmpB==p[mid])
			return mid;
		else if(tmpB>p[mid])
			return findP(p, start, mid,tmpB);
		else
			return findP(p, mid, end,tmpB);
	}
	
	

	private static int findP(int[] p, int length, int tmpB) {
//		System.out.println("length:" + length);
		int i = 0;
		for(; i<length&& p[i]>=tmpB; i++);
//		i--;
//		System.out.println("i:" + i);
		return --i;
		
	}

//
//	private static void myPrint(int[] b, int[] p, int count2) {
//		for (int j = 0; j < count2; j++) {
//			System.out.print(b[j] + "\t");
//		}
//		System.out.println();
//
//		for (int j = 0; j < count2; j++) {
//			System.out.print(p[j] + "\t");
//		}
//		System.out.println();
//		System.out.println("*********************************************************************");
//	}


	public static int getMiddle(int[] list, int low, int high, int[] a2) {
		int tmp = list[low]; // 数组的第一个作为中轴
		int tmp1 = a2[low];
		while (low < high) {
			while (low < high && list[high] <= tmp) {

				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			a2[low] = a2[high];
			while (low < high && list[low] >= tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
			a2[high] = a2[low];
		}
		list[low] = tmp; // 中轴记录到尾
		a2[low] = tmp1;
		return low; // 返回中轴的位置
	}

	public static void _quickSort(int[] list, int low, int high, int[] a2) {
		if (low < high) {
			int middle = getMiddle(list, low, high, a2); // 将list数组进行一分为二
			_quickSort(list, low, middle - 1, a2); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high, a2); // 对高字表进行递归排序
		}
	}

	public static void quick(int[] a1, int a1length, int[] a2) {
		if (a1length > 0) { // 查看数组是否为空
			_quickSort(a1, 0, a1length - 1, a2);
		}
	}
	
	
	
}