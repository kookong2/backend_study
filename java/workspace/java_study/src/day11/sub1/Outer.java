package day11.sub1;

import java.security.PublicKey;

public class Outer {
	OrderProduct method(int num1, int num2) {
		
		OrderProduct orderProduct = new OrderProduct() {
			
			@Override
			public void order() {

				System.out.println("주문!");
				
				int result = num1 + num2;
				System.out.println(result);
			}
		};
		
		return orderProduct;
	}
}
