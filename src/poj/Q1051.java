package poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1051 {
	public static void main(String[] args) {
		Map<Character, String> map1 = new HashMap<Character, String>();
		Map<String, Character> map2 = new HashMap<String, Character>();
		map1.put('A', ".-");
		map1.put('B', "-...");
		map1.put('C', "-.-.");
		map1.put('D', "-..");
		map1.put('E', ".");
		map1.put('F', "..-.");
		map1.put('G', "--.");
		map1.put('H', "....");
		map1.put('I', "..");
		map1.put('J', ".---");
		map1.put('K', "-.-");
		map1.put('L', ".-..");
		map1.put('M', "--");
		map1.put('N', "-.");
		map1.put('O', "---");
		map1.put('P', ".--.");
		map1.put('Q', "--.-");
		map1.put('R', ".-.");
		map1.put('S', "...");
		map1.put('T', "-");
		map1.put('U', "..-");
		map1.put('V', "...-");
		map1.put('W', ".--");
		map1.put('X', "-..-");
		map1.put('Y', "-.--");
		map1.put('Z', "--..");
		map1.put('_', "..--");
		map1.put('.', "---.");
		map1.put(',', ".-.-");
		map1.put('?', "----");
		
		for(Map.Entry<Character, String> entry : map1.entrySet()){
			map2.put(entry.getValue(), entry.getKey());
		}
		
		Scanner cin= new Scanner(System.in);
		int count = cin.nextInt();
		cin.nextLine();
		for(int i = 0 ; i <count ; i ++){
			String str = cin.nextLine().trim();
			StringBuilder sb = new StringBuilder();
			StringBuilder num = new StringBuilder();
			char[] ch = str.toCharArray();
			for(int j = 0 ; j < ch.length; j ++){
				sb.append(map1.get(ch[j]));
				num.append(map1.get(ch[j]).length());
			}
			
			String sbs = sb.toString();
			String nums = num.toString();
//			System.out.println(sbs);
//			System.out.println(nums);
			int beginIndex=0;
			System.out.print((i +1) + ": ");
			for(int j = nums.length()-1; j > -1; j--){
				
				System.out.print(map2.get(sbs.substring(beginIndex, beginIndex + num.charAt(j)-'0')));
				beginIndex += num.charAt(j)-'0';
			}
			System.out.println();
		}
	}

}