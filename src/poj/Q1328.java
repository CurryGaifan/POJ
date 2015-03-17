package poj;

import java.util.Scanner;

public class Q1328 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		for(int j =1; ; j++){
			int count = cin.nextInt();
			int r = cin.nextInt();
			if(r == 0 && count ==0)
				break;
			
			int[] x = new int[count];
			int[] y = new int[count];
			boolean success = true;
			for(int i = 0; i < count; i++){
				x[i] = cin.nextInt();
				y[i] = cin.nextInt();
				if(y[i] > r)
					success = false;
			}
			if(!success){
				System.out.println("Case " + j + ": " + -1);
				continue;
			}
			
			quick(x, y);
			
			double[] left = new double[count];
			double[] righ = new double[count];
			
	        for(int i=0;i<count;i++)  
	        {  
	            left[i]=x[i]-Math.sqrt(r*r-y[i]*y[i]);  
	            righ[i]=x[i]+Math.sqrt(r*r-y[i]*y[i]);  
	        }  
	        
	        int radar=1;  
	        double temp=righ[0];
	        for(int i=0;i<count-1;i++)  
	            if(left[i+1]>temp)  
	            {  
	                temp=righ[i+1];  
	                radar++;  
	            }  
	            else if(righ[i+1]<temp)  
	                temp=righ[i+1];  
	        
			System.out.println("Case " + j + ": " + radar);
				
		}
	}

	public static int getMiddle(int[] list, int[] list2, int low, int high) {
		int tmp = list[low]; // ����ĵ�һ����Ϊ����
		int tmp1 = list2[low];
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high]; // ������С�ļ�¼�Ƶ��Ͷ�
			list2[low] = list2[high];
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // �������ļ�¼�Ƶ��߶�
			list2[high] = list2[low];
		}
		list[low] = tmp; // �����¼��β
		list2[low] = tmp1;
		return low; // ���������λ��
	}

	public static void _quickSort(int[] list, int[] list2, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, list2, low, high); // ��list�������һ��Ϊ��
			_quickSort(list, list2, low, middle - 1); // �Ե��ֱ���еݹ�����
			_quickSort(list, list2, middle + 1, high); // �Ը��ֱ���еݹ�����
		}
	}

	public static void quick(int[] a1, int[] a2) {
		if (a1.length > 0) { // �鿴�����Ƿ�Ϊ��
			_quickSort(a1, a2, 0, a1.length - 1);
		}
	}
}
