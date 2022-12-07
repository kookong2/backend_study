package day20.sub1;

public class Box <T>{	// T -> Apple
	
	T fruit;
	
	public void add(T fruit) {
		this.fruit = fruit;
	}
	
	public T get() {
		return fruit;
	}
}
