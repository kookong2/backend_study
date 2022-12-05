package day18;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex04 {
	public static void main(String[] args) {
		
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2)*-1;
			}
			
			
		};
		
		TreeSet<String> names = new TreeSet<String>(comp);
		
		names.add("이름1");
		names.add("이름2");
		names.add("이름3");
		names.add("이름4");
		names.add("이름5");
		
		System.out.println(names);
		
		Comparator<Integer> comp2 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2)*-1;
			}
		};
		
		TreeSet<Integer> nums = new TreeSet<Integer>(comp2);
		nums.add(20);
		nums.add(21);
		nums.add(19);
		nums.add(25);
		nums.add(15);
		
		System.out.println(nums);
	}
}
