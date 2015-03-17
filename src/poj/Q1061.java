package poj;

import java.util.Scanner;

public class Q1061 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		long x = cin.nextLong();
		long y = cin.nextLong();
		long m = cin.nextLong();
		long n = cin.nextLong();
		long l = cin.nextLong();
		if(x ==y){
			System.out.println("0");
			return;
		}
		
		if((x^y&1)==1 && (m&1)==0 && (n &1)==0){
			System.out.println("Impossible");
			return;
		}
		int[] a = new int[31];
		int[] b = new int[31];
		int[] c = new int[31];
		int al = resolve((int)m, 0 , a);
		int bl = resolve((int)n, 0 , b);
		int cl = resolve((int)l, 0 , c);
		
		long ac = minMul(a, al, c, cl);
		long bc = minMul(b, bl, c, cl);
		System.out.println("ac:"+ac+",bc:"+bc+",ac/m:"+ac/m+",bc/n:"+bc/n);
		int[] d = new int[31];
		int[] e = new int[31];
		int dl = resolve((int)(ac/m), 0 , d);
		int el = resolve((int)(bc/n), 0 , e);
		
		long ab = minMul(d, dl, e, el);
		
		
		System.out.println("ab:"+ab);
		for(int i = 0 ;i < ab;i++){
			x = (x+m) %l;
			y = (y+n)%l;
			if(x==y){
				System.out.println(i+1);
				return ;
			}
			
		}
		System.out.println("Impossible");
	}
	
	
	private static long minMul(int[] a, int al, int[] c, int cl) {
		int i=0;
		int j =0;
		
		long sum =1;
		
		while(i<al ||j <cl){
			if(i==al){
				for(int m = j; m<cl; m++){
					sum*=c[m];
				}
				return sum;
			}else if(j==cl){
				for(int m = i; m<al; m++){
					sum*=a[m];
				}
				return sum;
			}
			
			
			
			if(a[i] ==c[j]){
				int aCtn = continueLength(a,i);
				int cCtn = continueLength(c, j);
				if(aCtn<=cCtn){
					for(int m = 0 ; m < cCtn; m++){
						sum*=c[j];
					}
				}else {
					for(int m = 0 ; m < aCtn; m++){
						sum*=a[i];
					}
					
				}
				i +=aCtn;
				j +=cCtn;
			}else if(a[i]< c[j]){
				int aCtn = continueLength(a,i);
				for(int m = 0 ; m < aCtn; m++){
					sum*=a[i];
				}
				i +=aCtn;
			}else {
				int cCtn = continueLength(c, j);
				for(int m = 0 ; m < cCtn; m++){
					sum*=c[j];
				}
				j +=cCtn;
			}
		}
		return sum;
	}


	private static int continueLength(int[] c, int j) {
		int temp = c[j];
		int a = j ;
		int i = j ; 
		for( ; i <c.length&&c[i]==temp; i++);
		return i-a;
	}


	private static int resolve(int num, int length, int[] array){
		for(int i =2; i<num+1; i++){
			if(num%i==0){
				array[length] = i;
//				System.out.print(i+" ");
				return resolve(num/i, length + 1, array) + 1;
			}
		}
		return 0;
		
	}

}
