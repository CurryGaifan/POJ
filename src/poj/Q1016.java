package poj;

import java.util.Scanner;

public class Q1016 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String array;
		String array1;
		while(true){
			String str = cin.nextLine().trim();
			if(str.equals("-1"))
				break;
			
			array = str;
			boolean isinventory = false;
			String[] path = new String[15];
			for(int i = 0 ;  i< 15 ;  i++){
				
				path[i] = array;
				
				array1 = inventory(array);
				if(array.equals(array1)){
					if(i==0){
						System.out.println(str + " is self-inventorying");
					}else{
						System.out.println(str + " is self-inventorying after " + i + " steps");
					}
					
					isinventory =true;
					break;
				}else{
					for(int c=0; c<i+1; c++){
						if(path[c].equals(array1)){
							System.out.println(str + " enters an inventory loop of length " + (i - c+1));
							isinventory =true;
							break;
						}
					}
				}
				if(isinventory)
					break;
				
				array = array1;
			}
			if(!isinventory){
				System.out.println(str + " can not be classified after 15 iterations" );
			}
		}
		
	}

	private static String inventory(String str) {
		char[] tmparray = str.toCharArray();
		quick(tmparray);
		
		StringBuilder sb= new StringBuilder();
		
		
		int last = -1;
		int count = 0;
		for(int i = 0 ; i< tmparray.length; i++){
			if(last == -1){
				last = tmparray[i];
				count ++;
			}else if (last == tmparray[i]){
				count ++;
			}else {
				sb.append(count);
				sb.append(last-'0');
				count = 1;
				last = tmparray[i];
			}
			
		}
		sb.append(count);
		sb.append(last-'0');
		return sb.toString();
	}

	public static int getMiddle(char[] list, int low, int high) {
		char tmp = list[low]; // ����ĵ�һ����Ϊ����
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high]; // ������С�ļ�¼�Ƶ��Ͷ�
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // �������ļ�¼�Ƶ��߶�
		}
		list[low] = tmp; // �����¼��β
		return low; // ���������λ��
	}

	public static void _quickSort(char[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // ��list�������һ��Ϊ��
			_quickSort(list, low, middle - 1); // �Ե��ֱ���еݹ�����
			_quickSort(list, middle + 1, high); // �Ը��ֱ���еݹ�����
		}
	}

	public static void quick(char[] a2) {
		if (a2.length > 0) { // �鿴�����Ƿ�Ϊ��
			_quickSort(a2, 0, a2.length - 1);
		}
	}
}
