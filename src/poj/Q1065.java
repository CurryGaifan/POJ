package poj;

import java.util.Scanner;

public class Q1065 {
	static class Stick{
		int l;
		int w;
		public Stick(int l, int w) {
			super();
			this.l = l;
			this.w = w;
		}
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int num  = cin.nextInt();
		for(int i = 0 ; i < num; i++){
			int count = cin.nextInt();
			Stick[] s = new Stick[count];
			for(int j = 0 ; j < count; j ++){
				int l = cin.nextInt();
				int w = cin.nextInt();
				s[j] = new Stick(l, w);
			}
			
			quickSort(s, 0 , s.length-1);
			int[] used = new int[count];
			int time  = 0 ;
			for(int j = 0 ; j<count; j ++){
				if(used[j] ==1)
					continue;
				time ++;
				used[j] =1;
				int index = j;
				
//				System.out.println(l[j] +" "+ w[j]);
				for(int k = j +1; k<count; k++){
					if(used[k] == 0 && s[k].l>=s[index].l && s[k].w >= s[index].w){
						used[k] = 1;
						index = k;
//						System.out.println(l[k] +" "+ w[k]);
					}
				}
				
			}
			System.out.println(time);
			
		}
	}

	public static int getMiddle(Stick[] w, int low, int high) {
		
		Stick tmpw = w[low];
		
		while (low < high) {
			while (low < high && compare(w[high], tmpw)>-1) {

				high--;
			}
			w[low] = w[high];
			while (low < high && compare(w[low], tmpw)<1) {
				low++;
			}
			w[high] = w[low];
			
		}
		w[low] = tmpw; 
		return low; 
	}

	public static void quickSort(Stick[] w,  int low, int high) {
		if (low < high) {
			int middle = getMiddle(w, low, high);
			quickSort(w, low, middle - 1);
			quickSort(w, middle + 1, high); 
		}
	}

	private static int compare(Stick a, Stick b) {
		if(a.l > b.l)
			return 1;
		else if(a.l == b.l){
			if(a.w> b.w)
				return 1;
			else if(a.w==b.w)
				return 0;
			
		}
		return -1;
	}

	
	
}
