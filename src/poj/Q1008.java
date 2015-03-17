package poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1008 {
	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pop", 0);
		map.put("no", 1);
		map.put("zip", 2);
		map.put("zotz", 3);
		map.put("tzec", 4);
		map.put("xul", 5);
		map.put("yoxkin", 6);
		map.put("mol", 7);
		map.put("chen", 8);
		map.put("yax", 9);
		map.put("zac", 10);
		map.put("ceh", 11);
		map.put("mac", 12);
		map.put("kankin", 13);
		map.put("muan", 14);
		map.put("pax", 15);
		map.put("koyab", 16);
		map.put("cumhu", 17);
		map.put("uayet", 18);
		String[] tzolkin_d_a = {"imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		System.out.println(count);
//		cin.nextLine();
//		String line;
		int haab_d;
		String haab_m;
		int haab_y;
		int tzolkin_y;
		String tzolkin_c;
		int tzolkin_n;
//		String[] str;
		int days=0;
		String p ;
		for(int i = 0; i<count; i++){
			p = cin.next();
			haab_d = Integer.valueOf(p.substring(0,p.length()-1));
			haab_m = cin.next();
			haab_y = Integer.valueOf(cin.next());
			days = haab_d + map.get(haab_m)*20 + haab_y*365;
			
			tzolkin_y=days/260;
			tzolkin_c = tzolkin_d_a[days%260%20];
			tzolkin_n = days%260%13+1;
			System.out.println(tzolkin_n+" "+tzolkin_c+" "+tzolkin_y);
		}
	}

}
