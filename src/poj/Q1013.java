package poj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1013 {
	public static void main(String[] args) throws Exception {
		Scanner cin = new Scanner(System.in);
		int count= cin.nextInt();
		for(int i =0 ; i<count ;  i++){
			int[] array = new int[12];
			Set<Character> ls = new  HashSet<Character>();
			Set<Character> hs = new  HashSet<Character>();
//			String[] array1 = new String[9];
			
			String l;
			String r;
			String b;
			
			for(int j = 0 ; j<3; j++){
				l = cin.next();
				r = cin.next();
				b = cin.next();
				if(b.equals("even")){
					for(char c : l.toCharArray()){
						array[c-'A'] = 1;
						if(ls.contains(c))
							ls.remove(c);
						if(hs.contains(c))
							hs.remove(c);
					}
					for(char c : r.toCharArray()){
						array[c-'A'] = 1;
						if(ls.contains(c))
							ls.remove(c);
						if(hs.contains(c))
							hs.remove(c);
					}
					
				}else{
					Set<Integer> tmp = new HashSet<Integer>(); 
					
					if(b.equals("up")){
						for(char c : l.toCharArray()){
							
							if(array[c-'A'] ==1){
								
							}else if(ls.contains(c)){
								array[c-'A']=1;
								ls.remove(c);
							}else {
								hs.add(c);
							}
							
							
							tmp.add(c-'A');
						}
						for(char c : r.toCharArray()){
							if(array[c-'A'] ==1){
								
							}else if(hs.contains(c)){
								array[c-'A']=1;
								hs.remove(c);
							}else {
								ls.add(c);
							}
							tmp.add(c-'A');
						}
						
					}else {
						for(char c : l.toCharArray()){
							if(array[c-'A'] ==1){
								
							}else if(hs.contains(c)){
								array[c-'A']=1;
								hs.remove(c);
							}else {
								ls.add(c);
							}
							tmp.add(c-'A');
						}
						for(char c : r.toCharArray()){
							if(array[c-'A'] ==1){
								
							}else if(ls.contains(c)){
								array[c-'A']=1;
								ls.remove(c);
							}else {
								hs.add(c);
							}
							
							
							tmp.add(c-'A');
						}
					}
					
					for(int k = 0 ; k <array.length; k++){
						if(array[k]==0 && !tmp.contains(k)){
							array[k]=1;
						}
					}

					
				}
				
//				for(int g : array){
//					System.out.print(g+" ");
//				}
//				System.out.println();
//				
//				for(char c : ls){
//					System.out.print(c+" ");
//				}
//				System.out.println();
//				
//				for(char c : hs){
//					System.out.print(c+" ");
//				}
//				System.out.println();
			}
			
			int  count0 = 0 ; 
			for(int k = 0 ; k <array.length; k++){
				if(array[k]==0){
					count0++;
					if(ls.contains((char)('A' + k)))
						System.out.println((char)('A' + k)+" is the counterfeit coin and it is light.");
					if(hs.contains((char)('A' + k)))
						System.out.println((char)('A' + k)+" is the counterfeit coin and it is heavy.");
				}
			}
			if(count0!=1)
				throw new Exception();
			
//			for(char c : ls){
//				System.out.println(c+" is the counterfeit coin and it is light.");
//			}
//			for(char c : hs){
//				System.out.println(c+" is the counterfeit coin and it is heavy.");
//			}
			
			
		}
	}
}
