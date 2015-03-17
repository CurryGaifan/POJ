package poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Q1002 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		cin.nextLine();
		String line;
		SortedMap<String, Integer> map = new TreeMap<String, Integer>();
		Map<Character,Character> char_map = new HashMap<Character, Character>();
		char_map.put('A', '2');
		char_map.put('B', '2');
		char_map.put('C', '2');
		char_map.put('D', '3');
		char_map.put('E', '3');
		char_map.put('F', '3');
		char_map.put('G', '4');
		char_map.put('H', '4');
		char_map.put('I', '4');
		char_map.put('J', '5');
		char_map.put('K', '5');
		char_map.put('L', '5');
		char_map.put('M', '6');
		char_map.put('N', '6');
		char_map.put('O', '6');
		char_map.put('P', '7');
		char_map.put('Q', '7');
		char_map.put('R', '7');
		char_map.put('S', '7');
		char_map.put('T', '8');
		char_map.put('U', '8');
		char_map.put('V', '8');
		char_map.put('W', '9');
		char_map.put('X', '9');
		char_map.put('Y', '9');
		char_map.put('Z', '9');
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<count; i++){
			line = cin.nextLine();
			sb.setLength(0);
			for(int j = 0; j<line.length(); j++){
				char c = line.charAt(j);
				if('0'<=c && c<='9'){
					sb.append(c);
				}else if ('A'<=c && c<='Z') {
					sb.append(char_map.get(c));
				}
				
			}
			
			

			if(map.containsKey(sb.toString())){
				map.put(sb.toString(), map.get(sb.toString())+1);
			}else {
				map.put(sb.toString(), 1);
			}
		}
		boolean isduplicates = true; 
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			if(entry.getValue()>1){
				isduplicates= false;
				String key = entry.getKey();
				String putkey = key.substring(0, 3) + "-" + key.substring(3);
				System.out.println(putkey + " " + entry.getValue());
			}
		}
		if(isduplicates){
			System.out.println("No duplicates.");
		}
	}

}