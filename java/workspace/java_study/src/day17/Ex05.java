package day17;

import java.util.Stack;

public class Ex05 {
	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		
		for(int i = 0; i < 10; i++) {
			st.push(i);
		}
		
		while(st.size() > 0) {
			System.out.println(st.pop());
		}
	}
}
