package day17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Ex04 {
	public static void main(String[] args) {

		LinkedList<String> names = new LinkedList<String>();
		for(int i = 0; i < 10; i++) {
			names.add("이름" + (i + 1));
		}
		
		printNames(names);


	}

	private static void printNames(LinkedList<String> names) {
		ListIterator<String> ir = names.listIterator();

		while(ir.hasNext()) {
			String name = ir.next();
			System.out.println(name);
		}

		while(ir.hasPrevious()) {
			String name = ir.previous();
			System.out.println(name);
		}
	}
}
