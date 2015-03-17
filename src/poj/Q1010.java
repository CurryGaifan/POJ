package poj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q1010 {
	public static void main(String[] args) {
		Scanner cin  = new Scanner(System.in);
		while(true){
			int[] array1 = new int[100];
			int[] array2 = new int[100];
			int length1=0;
			int length2=0;
			int num;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int count = 0;
			while(true){
				num  = cin.nextInt();
				if(num == 0)
					break;
				if(length1!=0 &&num ==array1[length1 -1]){
					count++;
					continue;
				}
				if(length1!=0)
					map.put(array1[length1-1],count);
				count=1;
				array1[length1] = num;
				length1++;
			}
			map.put(array1[length1-1],count);
			
			while(true){
				num  = cin.nextInt();
				if(num == 0)
					break;
				array2[length2] = num;
				length2++;
			}
//			System.out.println("array1 length:" + length1);
//			for(int i= 0; i<length1 ; i++)
//				System.out.print(array1[i]+" ");
//			System.out.println();
//			for(Map.Entry<Integer, Integer> entry : map.entrySet())
//				System.out.print(entry.getKey()+ " " + entry.getValue() +", ");
//			System.out.println();
//			System.out.println("array2 length:" + length2);
//			for(int i= 0; i<length2 ; i++)
//				System.out.print(array2[i]+" ");
//			System.out.println();
			
			
			for(int i=0; i<length2; i++){
				helper(array1, length1, map, array2[i]);
			}
			
			
			
		}
	}

	private static void helper(int[] array1, int length1,Map<Integer, Integer> map, int j) {
		// 这里应该打印出来最优解
		List<String> list = new ArrayList<String>();
		helper2(array1, 0,length1, j,"",list);
//		System.out.println("list.size():" + list.size());
		String bestrst = null;
		int com=0;
		boolean isTie = false;
		for(String str :list){
//			System.out.println(str);
			com = getBest(bestrst , str,map);
			if(com == -1){
				bestrst = str;
				isTie = false;
			}else if(com==0)
				isTie = true;
//			System.out.println("bestrst:" + bestrst);
			
		}
		
		
//		System.out.println("***********************");
		StringBuilder sb = new StringBuilder();
		sb.append(j);
		
		
		if(bestrst == null){
			sb.append(" ---- none");
			System.out.println(sb.toString());
			return;
		}
		String[] str = bestrst.split("_");
		sb.append(" (");
		sb.append(getTypeCount(str, map));
		sb.append("): ");
		
		if(isTie || isTie(bestrst,map)){
			sb.append("tie");
			System.out.println(sb.toString());
		}else{

			for(String s :str)
				sb.append(s+" ");
			System.out.println(sb.toString());
		}
			
		
	}

	private static boolean isTie(String bestrst, Map<Integer, Integer> map) {
		String[] sr = bestrst.split("_");
		int last = 0;
		int count = 0;
		int i = 0;
		for(; i<sr.length; i++){
			if (count ==0){
				last= Integer.valueOf(sr[i]);
				count ++;
			}
			else if(last == Integer.valueOf(sr[i])){
				count++;
			}else{
				if(map.get(Integer.valueOf(sr[i-1])) != 1 && count!= map.get(Integer.valueOf(sr[i-1])))
					return true;
				last= Integer.valueOf(sr[i]);
				count =1;
			}
		}
		if(map.get(Integer.valueOf(sr[i-1])) != 1 && count != map.get(Integer.valueOf(sr[i-1])))
			return true;
		else
			return false;
	}

	private static int getBest(String bestrst, String str,Map<Integer,Integer> map) {
		if(bestrst == null&&str!=null)
			return -1;
		if(bestrst != null&&str==null)
			return 1;
		if(bestrst==null && str == null)
			return 0;
		
		String[] b = bestrst.split("_");
		String[] s = str.split("_");
		int btc = getTypeCount(b,map);
		int stc = getTypeCount(s, map);
//		System.out.println("btc:" + btc);
//		System.out.println("stc:" + stc);
		if(btc> stc){
			return 1;
		}else if (btc<stc){
			return -1;
		}
		if(b.length>s.length)
			return -1;
		else if(b.length<s.length)
			return 1;
//		for(int i = 0 ; i<b.length ; i++){
//			if(Integer.valueOf(b[b.length-i-1])>Integer.valueOf(s[s.length-i-1]))
//				return 1;
//			else if (Integer.valueOf(b[b.length-i-1])<Integer.valueOf(s[s.length-i-1]))
//				return -1;
//		}
		if(Integer.valueOf(b[b.length-1])>Integer.valueOf(s[s.length-1]))
			return 1;
		else if (Integer.valueOf(b[b.length-1])<Integer.valueOf(s[s.length-1]))
			return -1;
		
		
		return 0;
	}

	private static int getTypeCount(String[] sr, Map<Integer, Integer> map) {
		int last = 0;
		int count = 0;
		int typecount=0;
		int i = 0;
		for(; i<sr.length; i++){
			if (count ==0){
				last= Integer.valueOf(sr[i]);
				count ++;
			}else if(last == Integer.valueOf(sr[i])){
				count++;
			}else{
//				System.out.println("map.get(sr[i-1]):" +sr[i-1]+" "+ i );
//				System.out.println(map.containsKey(sr[i-1]));
//				System.out.println(map.size());
				typecount+=getCTC(count, map.get(Integer.valueOf(sr[i-1])));
				last= Integer.valueOf(sr[i]);
				count =1;
			}
		}
		typecount+=getCTC(count, map.get(Integer.valueOf(sr[i-1])));
		
		return typecount;
	}

	private static int getCTC(int count, Integer integer) {
//		System.out.println("count:" + count +", integer:" +integer);
		if(count>integer)
			return  integer;
		else
			return count;
	}

	private static void helper2(int[] array1, int start, int length1, int j,String result,List<String> list) {
		int rl = result.split("_").length;
		if(!result.contains("_"))
			rl = 0;
//		System.out.println("start: "+ start+ ", j:" + j +", result:" + result+", rl:"+ rl);
		
		if(j ==0 ){
			list.add(result);
//			System.out.println("***************" + result);
			return;
		}
		
		if(start >= length1){
//			System.out.println("return");
			return;
		}
		
		helper2(array1, start+1 , length1, j,result, list) ;
		StringBuilder sb = new StringBuilder();
		for(int i=1 ; array1[start]*i <= j && i + rl <5; i++){
			sb.append(array1[start]);
			sb.append("_");
			helper2(array1, start+1 , length1, j-array1[start]*i,result + sb.toString(), list) ;
		}
	}



}
