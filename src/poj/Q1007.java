package poj;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Q1007 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
//		int n = cin.nextInt();
		int m = cin.nextInt();
//		char[][] ch = new char[m][n];
		cin.nextLine();
		String line;
//		Map<String, Integer> map_index = new HashMap<String, Integer>();
		SortedMap<String, String> map_num = new TreeMap<String, String>(new MyComparator());
		int num;
		for(int i =0; i<m ;i++){
			line = cin.nextLine();
//			map_index.put(line, i);
			num = help(line);
			map_num.put(num+"_"+i, line);
		}
		for(Map.Entry<String, String> entry : map_num.entrySet()){
			System.out.println(entry.getValue());
			
		}
		
		
	}
	
	public static class MyComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			int o1m = Integer.valueOf(o1.split("_")[0]);
			int o1n = Integer.valueOf(o1.split("_")[1]);
			int o2m = Integer.valueOf(o2.split("_")[0]);
			int o2n = Integer.valueOf(o2.split("_")[1]);
			if(o1m>o2m){
				return 1;
			}else if (o1m<o2m){
				return -1;
			}else{
				if(o1n>o2n){
					return 1;
				}else if (o1n<o2n){
					return -1;
				}else{
					return 0;
				}
			}
		}
		
	}

	private static int help(String line) {
		int[] array = new int[26];
		char tmpch;
		int  num = 0 ;
		for(int i = 0; i<line.length();i++){
			tmpch = line.charAt(i);
			if(tmpch!='T')
				array[tmpch - 'A']++;
		}
		for(int i = 0; i<line.length();i++){
			tmpch = line.charAt(i);
			if(tmpch!='T')
				array[tmpch-'A'] --;
			
			if(tmpch=='C'){
				num = num + array['A'-'A'];
			}else if(tmpch=='G'){
				num = num + array['A'-'A']+ array['C'-'A'];
			}else if(tmpch=='T'){
				num = num + array['A'-'A']+ array['C'-'A']+ array['G'-'A'];
			}
		}
		

		
		
		return num;
	}

}
