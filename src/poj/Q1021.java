package poj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q1021 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		for(int i = 0; i<count ; i ++){
			int w = cin.nextInt();
			int h = cin.nextInt();
			int[][] array1 = new int[w][h];
			int[][] array2 = new int[w][h];
			List<NodeSet> list1 = new ArrayList<NodeSet>();
			List<NodeSet> list2 = new ArrayList<NodeSet>();
			int n = cin.nextInt();
			for(int j = 0; j < n ; j++){
				int x = cin.nextInt();
				int y = cin.nextInt();
				array1[x][y] = 1;
			}
			for(int j = 0; j < n ; j++){
				int x = cin.nextInt();
				int y = cin.nextInt();
				array2[x][y] = 1;
			}
			
			for(int m = 0 ; m <h; m ++ ){
				for(int l = 0; l < w ; l ++){
					if(array1[l][m] == 1 ){
						Set<Node> set= new HashSet<Node>();
						addNode(array1, set , l , m,w,h);
						handle(set);

//						for(Node node :  set.toArray(new Node[1])){
//							System.out.print(node + " ");
//						}
//						System.out.println();
						
						list1.add(new NodeSet(set));
					}
				}
			}
			
//			System.out.println("pic 2:");
			
			for(int m = 0 ; m <h; m ++ ){
				for(int l = 0; l < w ; l ++){
					if(array2[l][m] == 1 ){
						Set<Node> set= new HashSet<Node>();
						addNode(array2, set , l , m,w,h);
						handle(set);
						
						
//						for(Node node :  set.toArray(new Node[1])){
//							System.out.print(node + " ");
//						}
//						System.out.println();
						
						
						list2.add(new NodeSet(set));
					}
				}
			}
			
			boolean equals = equal (list1, list2);
			
			if(equals){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
			
		}
		
	}

	private static void handle(Set<Node> set) {
		if(set.size()==1 || set.size()==2)
			return;
		
		int l  = Integer.MAX_VALUE;
		int r = Integer.MIN_VALUE;
		int u = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE;
		for(Node node : set){
			if(node.x < l)
				l = node.x;
			if(node.x > r)
				r = node.x;
			if(node.y < b)
				b = node.y;
			if(node.y > u)
				r = node.y;
		}
		for(Node node : set){
			node.x -=l;
			node.y -=b;
		}
		
		
		
	}

	private static boolean equal(List<NodeSet> list1, List<NodeSet> list2) {
		List<NodeSet> list1_c1 = new ArrayList<NodeSet>(list1);
		List<NodeSet> list1_c2 = new ArrayList<NodeSet>(list1);
		List<NodeSet> list2_c1 = new ArrayList<NodeSet>(list2);
		List<NodeSet> list2_c2 = new ArrayList<NodeSet>(list2);
		for(NodeSet ns : list1){
			if(ns.set.size() == 1)
				list1_c1.remove(ns);
			if(ns.set.size() == 2){
				list1_c1.remove(ns);
				list1_c2.remove(ns);
			}
		}
		for(NodeSet ns : list2){
			if(ns.set.size() == 1)
				list2_c1.remove(ns);
			if(ns.set.size() == 2){
				list2_c1.remove(ns);
				list2_c2.remove(ns);
			}
		}
		if(list1_c1.size()!=list2_c1.size())
			return false;
		if(list1_c2.size()!=list2_c2.size())
			return false;
		
		list1 = list1_c1;
		list2 = list2_c1;
//		System.out.println(list1.size());
//		System.out.println(list2.size());
		
		while(true){
			int i= 0;
			int j = 0;
			boolean find = false;
			for(;  i < list1.size() ;i++){
				for(; j < list2.size(); j ++){
//					System.out.println("list1:" + i +", list2:" + j);
					if(equal(list1.get(i), list2.get(j))){
						find = true;
						break;
					}
						
				}
				if(find)
					break;
			}
			
			if(find){
				list1.remove(i);
				list2.remove(j);
//				System.out.println("list1 remove :" + i + ", list2 remove:" + j);
			}else if( list1.size() == 0 && list2.size() == 0){
//				System.out.println("same");
				return true;
			}else {
//				System.out.println("different");
				return false;
			}
			
			
		}
		

	}

	private static boolean equal(NodeSet set1, NodeSet set2) {
		if(set1.set.size() ==1 && set2.set.size()==1)
			return true;
		if(set1.set.size()==2 && set2.set.size()==2)
			return true;
		
		if(set1.set.size()!= set2.set.size()){
//			System.out.println("size not same");
			return false;
		}
		
		boolean same = true;
//		System.out.println(set1.getW() +" "+set1.getH() +" "+ set2.getW() +" "+set2.getH());
		if(!((set1.getH()== set2.getH() && set1.getW()== set2.getW())||(set1.getH()== set2.getW() && set1.getW()== set2.getH()))){
//			System.out.println(set1.getH() + " "+ set2.getH() +" "+set1.getW() +" "+set2.getW());
//			System.out.println("w or h not same");
			return false;
		}else if(set1.getH() == set2.getH()){
			int[][] array1 = new int[set1.getW()+1][set1.getH()+1];
			int[][] array2 = new int[set2.getW()+1][set2.getH()+1];
			for(Node node : set1.set){
//				System.out.println(node.x + " "+node.y );
				array1[node.x][node.y] =1;
			}
			for(Node node : set2.set){
//				System.out.println(node.x + " "+node.y );
				array2[node.x][node.y] =1;
			}
			
			
			for(int i = 0  ; i < set1.getW()+1; i++){
				for(int j = 0; j < set1.getH()+1; j ++){
					if(array1[i][j]!= array2[i][j]){
						same = false;
						break;
					}
				}
				if(!same)
					break;
			}
			if(same)
				return true;
			
			same = true;
			for(int i = 0  ; i < set1.getW()+1; i++){
				for(int j = 0; j < set1.getH()+1; j ++){
					if(array1[ set1.getW() - i][j]!= array2[i][j]){
						same = false;
						break;
					}
				}
				if(!same)
					break;
			}
			if(same)
				return true;
			
			same = true;
			for(int i = 0  ; i < set1.getW()+1; i++){
				for(int j = 0; j < set1.getH()+1; j ++){
					if(array1[i][ set1.getH() - j]!= array2[i][j]){
						same = false;
						break;
					}
				}
				if(!same)
					break;
			}
			if(same)
				return true;
			
			same = true;
			for(int i = 0  ; i < set1.getW()+1; i++){
				for(int j = 0; j < set1.getH()+1; j ++){
					if(array1[set1.getW() - i][ set1.getH() - j]!= array2[i][j]){
						same = false;
						break;
					}
				}
				if(!same)
					break;
			}
			if(same)
				return true;
		}else if(set1.getH() == set2.getW()){
			same = true;
			int[][] array1 = new int[set1.getW()+1][set1.getH()+1];
			int[][] array2 = new int[set2.getW()+1][set2.getH()+1];
			for(int i = 0  ; i < set1.getW()+1; i++){
				for(int j = 0; j < set1.getH()+1; j ++){
					if(array1[i][j]!= array2[j][i]){
						same = false;
						break;
					}
				}
				if(!same)
					break;
			}
			if(same)
				return true;
			
			same = true;
			for(int i = 0  ; i < set1.getW()+1; i++){
				for(int j = 0; j < set1.getH()+1; j ++){
					if(array1[ set1.getW() - i][j]!= array2[j][i]){
						same = false;
						break;
					}
				}
				if(!same)
					break;
			}
			if(same)
				return true;
			
			same = true;
			for(int i = 0  ; i < set1.getW()+1; i++){
				for(int j = 0; j < set1.getH()+1; j ++){
					if(array1[i][ set1.getH() - j]!= array2[j][i]){
						same = false;
						break;
					}
				}
				if(!same)
					break;
			}
			if(same)
				return true;
			
			same = true;
			for(int i = 0  ; i < set1.getW()+1; i++){
				for(int j = 0; j < set1.getH()+1; j ++){
					if(array1[set1.getW() - i][ set1.getH() - j]!= array2[j][i]){
						same = false;
						break;
					}
				}
				if(!same)
					break;
			}
			if(same)
				return true;
		}
		
		
		
		return same;
	}

	private static void addNode(int[][] array1, Set<Node> set, int l, int m,int w, int h) {
		if(array1[l][m]== 1){
			set.add(new Node(l, m ));
			array1[l][m]= 0 ;
			if(l>0)
				addNode(array1, set , l-1 , m,w,h);
			if(l<w-1)
				addNode(array1, set , l+1 , m,w,h);
			if(m>0)
				addNode(array1, set , l , m-1,w,h);
			if(m<h-1)
				addNode(array1, set , l , m+1,w,h);
		}
		
		
		
		
		
	}

	static class NodeSet{
		public NodeSet(Set<Node> set){
			this.set = set;
		}
		
		Set<Node> set;
		private int w = 0;
		private int h = 0;
		public int getW() {
			if(w == 0){
				int l  = Integer.MAX_VALUE;
				int r = Integer.MIN_VALUE;
				int u = Integer.MIN_VALUE;
				int b = Integer.MAX_VALUE;
				for(Node node : set){
					if(node.x < l)
						l = node.x;
					if(node.x > r)
						r = node.x;
					if(node.y < b)
						b = node.y;
					if(node.y > u)
						u = node.y;
				}
				w = r - l;
				h = u-b ;
			}
			
			return w;
		}
		public int getH() {
			if(h == 0){
				int l  = Integer.MAX_VALUE;
				int r = Integer.MIN_VALUE;
				int u = Integer.MIN_VALUE;
				int b = Integer.MAX_VALUE;
				for(Node node : set){
					if(node.x < l)
						l = node.x;
					if(node.x > r)
						r = node.x;
					if(node.y < b)
						b = node.y;
					if(node.y > u)
						u = node.y;
				}
				w = r - l;
				h = u -b ;
			}
			return h;
		}
		
		
	}
	
	
	static class Node{
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		int x ;
		int y ;
		
		public String toString(){
			return "x: " + x + ", y: " + y;
		}
	}
}
