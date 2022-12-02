package day17;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex01 {
	public static void main(String[] args) {
		
		ArrayList <String> al1 = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			al1.add("이름" + (i + 1));
		}
		
		Iterator<String> ir = al1.iterator();
		
		ir = al1.iterator();
		while(ir.hasNext()) {
			String name = ir.next();
			System.out.println(name);
		}
		
		System.out.println(al1);
		
		for(int i = 0; i < al1.size(); i++) {
			String name = al1.get(i);
			System.out.println(name);
		}
		
//		for(int i = 0; i < al1.size(); i++) {
//			al1.remove(i);
//		}
		
		for(int i = al1.size() -1; i >= 0; i--) {
			al1.remove(i);
		}
		
		System.out.println(al1);
		
	}
}
