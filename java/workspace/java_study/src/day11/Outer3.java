package day11;

public class Outer3 {
	
	Runnable method(int num1,int num2) {
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {

//				System.out.println("출력");
				
				//num1 = 30;	// 상수 -> 수정 x final
				//num2 = 40;	// 상수 -> 수정 x final
				
				int result = num1 + num2;		// 지역 변수 -> 상수(연산을 위해 제거x)
				System.out.println(result);
			}
		};
		
		return runnable;
	}
}
