package day17.sub1;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01 {
	public static void main(String[] args) {
		
		HashSet<String> names = new HashSet<String>();
		names.add("이름1");
		names.add("이름2");
		names.add("이름3");
		names.add(new String("이름3"));
		names.add("이름4");
		names.add("이름5");
		
		String str1 = new String("이름3");
		String str2 = new String("이름3");
		System.out.println("str1 = " + str1.hashCode());
		System.out.println("str2 = " + str2.hashCode());
		System.out.println(str1.equals(str2));

		Iterator<String> ir = names.iterator();
		while(ir.hasNext()) {
			String name = ir.next();
			// equals, hashcode
			System.out.println(name);
		}
		
		for(String name : names) {
			System.out.println(name);
		}
	}
}
