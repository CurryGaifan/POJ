package poj;

import java.util.Scanner;

public class Q1083 {
	static class Move {
		int s;
		int b;

		public boolean compare(Move m) {
			if (this.s > m.b) {
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();

		for (int i = 0; i < count; i++) {
			int num = cin.nextInt();
			Move[] array = new Move[num];
			for (int j = 0; j < num; j++) {
				int temp1 = cin.nextInt();
				if((temp1 & 0x00000001) == 0x00000000){
					temp1 -- ;
				}
				int temp2 = cin.nextInt();
				if((temp2 & 0x00000001) == 0x00000000){
					temp2 -- ;
				}
				Move move = new Move();
				if (temp1 > temp2) {
					move.s = temp2;
					move.b = temp1;
				} else {
					move.s = temp1;
					move.b = temp2;
				}
				array[j] = move;
			}

			quickSort(array, 0, array.length - 1);
//			System.out.println("***********************");
			int[] used = new int[num];
			int time = 0;
			for (int j = 0; j < num; j++) {
				if (used[j] == 1)
					continue;
				time += 10;
				used[j] = 1;
				int index = j;

				// System.out.println(l[j] +" "+ w[j]);
				for (int k = j + 1; k < num; k++) {
					if (used[k] == 0 && array[k].compare(array[index])) {
						used[k] = 1;
						index = k;
						 
					}
				}
			}
			System.out.println(time);

		}

	}

	public static int getMiddle(Move[] w, int low, int high) {

		Move tmpw = w[low];

		while (low < high) {
			while (low < high && w[high].s >= tmpw.s) {

				high--;
			}
			w[low] = w[high];
			while (low < high && tmpw.s>= w[low].s) {
				low++;
			}
			w[high] = w[low];

		}
		w[low] = tmpw;
		return low;
	}

	public static void quickSort(Move[] w, int low, int high) {
		if (low < high) {
			int middle = getMiddle(w, low, high);
			quickSort(w, low, middle - 1);
			quickSort(w, middle + 1, high);
		}
	}

}
