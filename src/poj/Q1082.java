package poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1082 {
	static class Cld{
		int year;
		int month;
		int day;
		Cld befor(){
			Cld b = new Cld();
			b.year = this.year;
			b.month = this.month;
			b.day = this.day;
			if(day>1){
				b.day--;
			}else if(day == 1){
				if(month>1){
					if(month==2||month ==4||month ==6||month==8||month ==9||month==11){
						b.month--;
						b.day=31;
					}else if(month == 5||month == 7||month ==10||month==12){
						b.month--;
						b.day=30;
					}else if(month ==3){
						if((year & 3) == 0){
							if(year%100 == 0 && year!=2000){
								b.month --;
								b.day = 28;
							}else {
								b.month--;
								b.day=29;
							}
						}else {
							b.month--;
							b.day= 28;
						}
					}
					
					
					
				}else if(month ==1){
					b.year --;
					b.month=12;
					b.day=31;
				}
			}
			return b;
		}
		
		
		boolean hasNextMonthDay(){
			if(month==2||month==4||month==6||month==7||month==9||month==11||month==12){
				return true;
			}else if(month==3||month==5||month==8||month==10){
				if(day==31)
					return false;
				else 
					return true;
			}else {
				if(day >29)
					return false;
				else if(day == 29 ){
					if((year & 3) == 0){
						if(year%100 == 0 && year!=2000){
							return false;
						}else {
							return true;
						}
					}
					return false;
				}else 
					return true;
			}
		}
		
		Cld nextMonthDay(){
			Cld b = new Cld();
			b.year = this.year;
			b.month = this.month;
			b.day = this.day;
			if(month ==12){
				b.year ++;
				b.month=1;
				
			}else {
				b.month++;
			}
			return b;
		}
		
		
		
		@Override
		public int hashCode(){
			return year * 10000 + month *100 + day;
		}
	}
	static Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	
	public static void main(String[] args) {
		
		Cld cld = new Cld();
		cld.year = 2001;
		cld.month = 11;
		cld.day = 3;
//		System.out.println(cld.hashCode());
		map.put(cld.hashCode(), true);
		boolean win = true;
		while(true){
			cld = cld.befor();
//			System.out.println(cld.hashCode());
			if(cld.hashCode() < 19000101)
				break;
			
			
			if(win ==false){
				map.put(cld.hashCode(), true);
				win = true;
			}else {
				if(cld.hasNextMonthDay()){
					Cld nmd = cld.nextMonthDay();
					if(map.containsKey(nmd.hashCode())){
						boolean nmdWin = map.get(nmd.hashCode());
						if(nmdWin){
							map.put(cld.hashCode(), false);
							win = false ;
						}else {
							map.put(cld.hashCode(), true);
							win = true;
						}
					}else {
						map.put(cld.hashCode(), false);
						win = false ;
					}
					
					
				}else {
					map.put(cld.hashCode(), false);
					win = false ;
				}
			}
			
		}
//		System.out.println("END");
		
		
		
		Scanner cin = new Scanner(System.in);
		int count = cin.nextInt();
		for(int i = 0 ; i < count;i++){
			int year = cin.nextInt();
			int month = cin.nextInt();
			int day = cin.nextInt();
			if(map.get(year * 10000 + month *100 + day))
				System.out.println("YES");
			else 
				System.out.println("NO");
			
		}
	}

}
