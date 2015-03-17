package poj;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Q2965 {
	static Queue<String> queue = new LinkedList<String>();
	static Map<String, String> map = new HashMap<String,String>();
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append(cin.next());
		sb.append(cin.next());
		sb.append(cin.next());
		sb.append(cin.next());
//		System.out.println( bs1);
//		BitSet bs = new BitSet(16);
		map.put(sb.toString(), "");
		queue.add(sb.toString());
		while(true){
			if(queue.size()==0)
				break;
			String temp = queue.poll();
			if(temp.equals("----------------")){
				String result = map.get(temp);
				System.out.println(result.split(" ").length-1);
				System.out.println(result);
				return;
			}
			deal(temp);
		}
		System.out.println("Impossible");
	}
	private static void deal(String temp) {
		
		String list = map.get(temp);
		for(int i =0; i <16; i++){
			String str = reverse(temp, i );
			if(!map.containsKey(str)){
//				List<String> copy = new LinkedList<String>(list);
//				copy.add((i/4+1)+" "+(i%4+1));
				map.put(str, list+(i/4+1)+" "+(i%4+1)+"\r\n");
				queue.add(str);
//				System.out.println(str);
//				
//				for(String path : copy)
//					System.out.println(path);
			}
			
		}
		
	}
	private static String reverse(String str, int i) {
		char[] ch = str.toCharArray();
		
		flip(ch , i);
		
		int tempa = i/4;
		int tempb = i%4;
		for(int j = 0; j<4; j ++){
			if(j==tempb)
				continue;
			flip(ch, j+tempa*4);
		}
		for(int j = 0 ; j <4; j++){
			if(j == tempa)
				continue;
			flip(ch, j*4 + tempb);
		}
		
		return new String(ch);
	}
	private static void flip(char[] ch, int i) {
		if(ch[i] == '+')
			ch[i] = '-';
		else if(ch[i]=='-')
			ch[i]= '+';
	}
}
