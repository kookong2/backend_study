package day20.sub2;

import static day20.sub2.Transportation.*;

public class Ex01 {
	public static void main(String[] args) {

		Transportation trans = BUS;	// trans == BUS -> 주소 값이 똑같음 

		if(trans == BUS) {
			System.out.println("버스");
		}
		
		String name = BUS.getName();
		System.out.println(name);
		
		//Transportation AIRPLANE = new Tranportaion("비행기");
	}
}
