package poj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q1062 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int dif = cin.nextInt();
		int count = cin.nextInt();
		List<Thing> list = new ArrayList<Thing>();
		int firstLevel =Integer.MIN_VALUE;
		for(int i =0; i<count; i++){
			int price = cin.nextInt();
			int level = cin.nextInt();
			if(firstLevel== Integer.MIN_VALUE)
				firstLevel = level;
			int insteadCount = cin.nextInt();
			List<Thing> list1 = new ArrayList<Thing>();
			for(int j = 0 ; j < insteadCount; j ++){
				list1.add(new Thing(cin.nextInt(), cin.nextInt()));
			}
			list.add(new Thing(price, level, count, list1));
		}
		Set<Integer> set = new HashSet<Integer>();
		int low = getLow(list, dif, firstLevel - dif, firstLevel + dif , 0,set);
		System.out.println(low);
	}

	
	
	private static int getLow(List<Thing> list,int dif,  int lowlevel, int uplevel,int index, Set<Integer> set) {
		
		Thing thing = list.get(index);
		int level = thing.getLevel();
		int price = thing.getPrice();
		List<Thing> list1 = thing.getList();
		
		if(level > uplevel || level < lowlevel ||set.contains(index)){
			return -1;
		}
		set.add(index);
		for(Thing th : list1){
			
			int otherPrice = getLow(list, dif, Math.max(level-dif, lowlevel), Math.min(level +dif, uplevel), th.getIndex()-1, set);
			if(otherPrice == -1){
				
			}else{
				int tmpprice = th.getPrice() + otherPrice;
//				System.out.println("tmpprice " + tmpprice);
				if(tmpprice < price)
					price = tmpprice;
			}
				
				
			
		}
		set.remove(index);
//		System.out.println("return " + price);
		return price;
	}



	static class Thing{
		int price;
		int level; 
		int index;
		List<Thing> list;
		public Thing(int index, int price) {
			super();
			this.price = price;
			this.index = index;
		}
		public Thing(int price, int level, int index, List<Thing> list) {
			super();
			this.price = price;
			this.level = level;
			this.index = index;
			this.list = list;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public List<Thing> getList() {
			return list;
		}
		public void setList(List<Thing> list) {
			this.list = list;
		}
	}
}

