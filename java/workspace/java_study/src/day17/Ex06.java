package day17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex06 {
	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < 10; i ++) {
			queue.offer(i);
		}
		
		while(queue.size() > 0) {
			System.out.println(queue.poll());
		}
	}
}
