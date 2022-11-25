package day10.sub3;

public interface Buy {
	void buy();
	
	default void order() {
		System.out.println("주문!");
	}
}
