package day24;


public class Ex01 {
	public static void main(String[] args) {
		
		/**
		int num3 = 30;
		
		Calculator calculator2 = (x,y) -> {
			// num3 = 40;
			return x + y;
		};
		
		
		
		Calculator calculator = new Calculator() {
			
			@Override
			public int add(int num1, int num2) {
				
				return num1 + num2;
			}
		};
		**/
		
		Calculator calculator =(x,y)->{
			
			return x + y;
		};
		
		int result = add(calculator);
		System.out.println(result);
		
		int result2 = add((x,y) -> x - y);
		System.out.println(result2);
		/*	// 얘랑 같다
		int result2 = add(new Calculator() {
			
			@Override
			public int add(int num1, int num2) {
				
				return num1 + num2;
			}
		});
		*/
		
		Calculator calculator2 = add2();
		int result3 =calculator2.add(30,20);
		System.out.println(result);
	}
	
	public static int add(Calculator calculator) {
		
		return calculator.add(10,20);
		
	}
	
	public static Calculator add2() {
		
		//Calculator calculator2 = (x,y) -> x + y;
		//return calculator2;
		
		return (x,y) -> x + y;
		
	}
}
