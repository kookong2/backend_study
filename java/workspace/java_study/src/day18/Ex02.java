package day18;

import java.util.HashMap;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		
		HashMap<String, String> members = new HashMap<String,String>();
		
		members.put("user01", "123456");
		members.put("user02", "234567");
		members.put("user03", "123456");
		members.put("user04", "234567");
		
		members.put("user02", "123456");
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("아이디 :");
			String userId = scanner.nextLine();
			System.out.print("비밀 번호 :");
			String userPass = scanner.nextLine();
			
			String _userpass = members.get(userPass);
			
			if(_userpass == null) {
				System.out.println("등록된 회원이 아닙니다.");
				continue;
			}
			
			if(_userpass.equals(_userpass)) {	// 비번이 일치
				System.out.println("로그인 성공");
				break;
			}else {	// 비번이 불일치
				System.out.println("비밀번호 불일치!");
			}
		}
	}
}
