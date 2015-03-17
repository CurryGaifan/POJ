package poj;

import java.util.Scanner;

public class Q1009 {

	public static void main(String[] args) {

		Scanner cin = new Scanner(System.in);

		int width;
		int pv;
		int rl;
		while (true) {
			int[] array1 = new int[1001];
			int[] array2 = new int[1001];
			int[] array3 = new int[10000];
			int[] array4 = new int[10000];
			width = cin.nextInt();
			if (width == 0)
				break;

			int i = 0;
			while (true) {
				pv = cin.nextInt();
				rl = cin.nextInt();
				if (pv == 0 && rl == 0)
					break;
				array1[i] = pv;
				array2[i] = rl;
				i++;

			}
			// for(int b=0; b<i;b++){
			// System.out.print(array1[b] + " ");
			// }
			// System.out.println();
			// for(int b=0; b<i;b++){
			// System.out.print(array2[b] + " ");
			// }
			// System.out.println();
			int length = 0;
			int tmp;
			int j = 0;
			for (; j < i; j++) {
				tmp = array2[j];
				array2[j] = length;
				length += tmp;
			}
			// System.out.println("length: " + length);
			// for(int b=0; b<j;b++){
			// System.out.print(array2[b] + " ");
			// }
			// System.out.println("*********************");
			int lastmax = 0;
			int maxcount = 0;
			int max;
			int n = 0;
			int m = 0;
			while (m < length) {
				// System.out.println(m);
				int m_index = findindex(array2, m, j, length);
//				 System.out.println(m + " " + m_index+" "+ j + " "+width +" "  +length+" "+array2[m_index]);
				
				//一个像素值连续2*width以上的话，前后两个width以外的像素的最大值为0
				if (m > array2[m_index] + width && ((m_index == j - 1 && m < length - width) || m < array2[m_index + 1] - width-1)) {
//					System.out.println("m:" + m +", m1:" +m_index+" "+array2[m_index]+" "+array2[m_index+1]);
					if (lastmax == 0) {

						if (m_index == j - 1) {
//							System.out.println("Branch 1");
//							maxcount += length - array2[m1] - 2 * width-1;
							maxcount += length - m;
						} else {
//							System.out.println("Branch 2");
							maxcount += array2[m_index + 1] - array2[m_index] - 2 * width
									- 2;
						}

					} else {
						array3[n] = lastmax;
						array4[n] = maxcount;
						lastmax = 0;
						if (m_index == j - 1) {
//							System.out.println("Branch 3");
//							maxcount = length - array2[m1] - 2 * width-1 ;
							maxcount = length - m;
						} else {
//							System.out.println("Branch 4");
							maxcount = array2[m_index + 1] - array2[m_index] - 2 * width
									- 2;
						}

						n++;
					}
					if (m_index == j - 1) {
//						m = length - width;
						m = length +1;
					} else {
						m = array2[m_index + 1] - width-1;
					}

//					 System.out.println("m:" + m + ",maxcount:" + maxcount);
				} else {
					max = getMax(array1, array2, width, length, m, j, m_index);
//					System.out.println("m: " + m + ", max : " + max);
					
					int msw_index =  findindex(array2, m-width, j, length);
					int maw_index =  findindex(array2, m+width, j, length);
					boolean isgo = true;
					if(msw_index != -1){
						isgo = isgo && (array2[msw_index] != (m-width));
					}
					isgo = isgo && (array2[m_index] != m);
					if(maw_index != -1){
						isgo = isgo && (array2[maw_index] != (m+width));
					}
//					System.out.println("isgo:" +isgo);
					//一个像素，此像素接下来是连续的； 上面的像素接下来是连续的；下面的像素接下来是连续的；并且都不是各自处在的连续像素序列的第一个像素，那么可以向前跳跃。
					if(isgo){
//						System.out.println("*******in isgo********");
//						System.out.println("msw_index:" + msw_index + ", m_index:"+ m_index +", maw_index:" + maw_index+", j:" + j);
						int msw_gl = 0;
						int m_gl = 0;
						int maw_gl = 0;
						if(msw_index == -1){
							msw_gl = width - m%width-1;
						}else if(msw_index<j-1){
							msw_gl  = array2[msw_index+1]- (m-width)-2;
							if(msw_gl<0)
								msw_gl = 0;
						}else{
							msw_gl = length - (m-width)-1;
						}
						
						if(m_index<j-1){
							m_gl = array2[m_index+1] - m -2;
							if(m_gl<0)
								m_gl = 0;
						}else{
							m_gl = length - m-1;
						}
						
						if(maw_index == -1){
							maw_gl = width - m%width-1;
						}else if(maw_index<j-1){
							maw_gl = array2[maw_index +1] - (m+width)-2;
							if(maw_gl<0)
								maw_gl = 0;
						}else{
							maw_gl = length - (m+width)-1;
						}
						
//						System.out.println("msw_gl:" + msw_gl+", m_gl:"+m_gl+", maw_gl:"+ maw_gl);
						int gl = min(msw_gl,m_gl,maw_gl);
						if (max == lastmax) {
							maxcount+= gl+1;
						} else {
							array3[n] = lastmax;
							array4[n] = maxcount;
							// System.out.println("array3[n] : " + array3[n]
							// +", array4[n]"+ array4[n]);
							lastmax = max;
							maxcount = gl+1;
							n++;

						}
						m += (gl+1);
//						System.out.println("m:" + m + ",maxcount:" + maxcount);
//						System.out.println("******isgo end********");
					}else{
						if (m == 0) {
							lastmax = max;
							maxcount++;
						} else if (max == lastmax) {
							maxcount++;
						} else {
							array3[n] = lastmax;
							array4[n] = maxcount;
							// System.out.println("array3[n] : " + array3[n]
							// +", array4[n]"+ array4[n]);
							lastmax = max;
							maxcount = 1;
							n++;

						}
						m++;
					}
					
				}

			}
			array3[n] = lastmax;
			array4[n] = maxcount;

//			 System.out.println("**************");
			System.out.println(width);
			for (int a = 0; a < n + 1; a++) {
				System.out.println(array3[a] + " " + array4[a]);
			}
			System.out.println("0 0");

		}
		System.out.println("0");
	}

	private static int min(int mswGl, int mGl, int mawGl) {
		int min = Integer.MAX_VALUE;
		if (mswGl < min)
			min = mswGl;
		if (mGl < min)
			min = mGl;
		if (mawGl < min)
			min = mawGl;

		return min;
	}

	private static int getMax(int[] array1, int[] array2, int width,
			int length, int m, int array2length, int m1) {
		int max = 0;
		// int m1 = findindex(array2, m, array2length);

		int dis;
		if (m - width - 1 >= 0 && m % width != 0) {
			int m_lu = findindex(array2, m - width - 1, array2length, length);
			dis = Math.abs(array1[m1] - array1[m_lu]);
			// System.out.println("m_lu : " + dis);
			if (dis > max)
				max = dis;

		}
		if (m - width >= 0) {
			int m_u = findindex(array2, m - width, array2length, length);
			dis = Math.abs(array1[m1] - array1[m_u]);
			// System.out.println("m_u : " + dis);
			if (dis > max)
				max = dis;
		}
		if (m - width + 1 >= 0 && (m + 1) % width != 0) {
			int m_ru = findindex(array2, m - width + 1, array2length, length);
			dis = Math.abs(array1[m1] - array1[m_ru]);
			// System.out.println("m_ru : " + dis);
			if (dis > max)
				max = dis;
		}
		if (m % width != 0) {
			int m_l = findindex(array2, m - 1, array2length, length);
			dis = Math.abs(array1[m1] - array1[m_l]);
			// System.out.println("m_l : " + dis);
			if (dis > max)
				max = dis;
		}
		if ((m + 1) % width != 0) {
			int m_r = findindex(array2, m + 1, array2length, length);
			dis = Math.abs(array1[m1] - array1[m_r]);
			// System.out.println("m_r : " + dis);
			if (dis > max)
				max = dis;
		}
		if (m + width - 1 < length && m % width != 0) {
			int m_ln = findindex(array2, m + width - 1, array2length, length);
			dis = Math.abs(array1[m1] - array1[m_ln]);
			// System.out.println("m_ln : " + dis);
			if (dis > max)
				max = dis;
		}
		if (m + width < length) {
			int m_n = findindex(array2, m + width, array2length, length);
			dis = Math.abs(array1[m1] - array1[m_n]);
			// System.out.println("m_n : " + dis);
			if (dis > max)
				max = dis;
		}
		if (m + width + 1 < length && (m + 1) % width != 0) {
			int m_rn = findindex(array2, m + width + 1, array2length, length);
			// System.out.println(m1 + ":"+ array1[m1] + ", "+m_rn + ":"+
			// array1[m_rn]);
			dis = Math.abs(array1[m1] - array1[m_rn]);
			// System.out.println("m_rn : " + dis);
			if (dis > max)
				max = dis;
		}

		return max;
	}

	private static int findindex(int[] array2, int m, int array2length, int length) {

		// System.out.println("findindex m :" + m);
		if(m<0)
			return -1;
		if(m>=length)
			return -1;
		
		int i;
		for (i = 0; i < array2length && m >= array2[i]; i++)
			;
		return i - 1;
	}

}
