package day14.sub2;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("숫자 2개를 입력 하세요. ㅇㅖ)20 30 ");
			String nums = scanner.nextLine();
			
			if(nums.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			System.out.println("입력한 숫자는 " + nums);
			String[]_nums = nums.split(" ");
			
			int n1 = Integer.parseInt(_nums[0]);
			int n2 = Integer.parseInt(_nums[1]);
			
			System.out.println("덧셈 결과? " + (n1 + n2));
			
			
			
		}
	}
}
