package poj;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Q1753 {
	static Queue<String> queue = new LinkedList<String>();
	static Map<String, Integer> map = new HashMap<String,Integer>();
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append(cin.next());
		sb.append(cin.next());
		sb.append(cin.next());
		sb.append(cin.next());
//		System.out.println( bs1);
//		BitSet bs = new BitSet(16);
		map.put(sb.toString(), 0 );
		queue.add(sb.toString());
		while(true){
			if(queue.size()==0)
				break;
			String temp = queue.poll();
			if(temp.toString().equals("bbbbbbbbbbbbbbbb") || temp.toString().equals("wwwwwwwwwwwwwwww")){
				System.out.println(map.get(temp.toString()));
				return;
			}
			deal(temp);
		}
		System.out.println("Impossible");
	}
	private static void deal(String temp) {
		
		int times = map.get(temp);
		for(int i =0; i <16; i++){
			String str = reverse(temp, i );
			if(!map.containsKey(str)){
				map.put(str, times +1);
				queue.add(str);
//				System.out.println(bs +" "+(times+1));
			}
			
		}
		
	}
	private static String reverse(String str, int i) {
		char[] ch = str.toCharArray();
		
		flip(ch , i);
		if(i - 4 >-1)
			 flip(ch ,i-4);
		if(i%4!=0)
			flip(ch ,i-1);
		if(i%4!=3)
			 flip(ch ,i+1);
		if(i+4<16)
			flip(ch ,i+4);
		
		return new String(ch);
	}
	private static void flip(char[] ch, int i) {
		if(ch[i] == 'b')
			ch[i] = 'w';
		else if(ch[i]=='w')
			ch[i]= 'b';
	}
	

}
