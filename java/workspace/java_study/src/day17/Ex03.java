package day17;

import java.util.Vector;

public class Ex03 {

	public static void main(String[] args) {
		
		Vector<String> vc = new Vector<String>(3);
		
		int cap = vc.capacity();
		vc.add("이름1");
		vc.add("이름2");
		vc.add("이름3");
		System.out.println(cap);
		vc.add("이름4");
		vc.add("이름5");
		vc.add("이름6");
		cap = vc.capacity();
		System.out.println(cap);
		vc.add("이름7");
		cap = vc.capacity();
		System.out.println(cap);
	}
}
