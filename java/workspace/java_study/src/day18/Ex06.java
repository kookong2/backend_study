package day18;

import java.util.*;

public class Ex06 {
	public static void main(String[] args) {
		
		Comparator<String> comp = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2)*-1;
			}
		};
		
		TreeMap<String, String> members = new TreeMap<String,String>(comp);
		
		members.put("user01", "123456");
		members.put("user03", "123456");
		members.put("user04", "234567");
		members.put("user02", "234567");
		
		System.out.println(members);
	}
}
