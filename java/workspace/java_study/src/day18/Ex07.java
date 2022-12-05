package day18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex07 {
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		
		names.add("이름3");
		names.add("이름1");
		names.add("이름2");
		names.add("이름5");
		names.add("이름4");
		
		System.out.println(names);
		
		Collections.sort(names);
		System.out.println(names);
		
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2)*-1;
			}
		};
		Collections.sort(names,comp);
		
		System.out.println(names);
	}
}
