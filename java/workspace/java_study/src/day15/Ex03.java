package day15;

import java.text.*;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		
		String pattern = "이름 : {0}, 전화번호 : {1}";
		String[] names = {"홍길동", "고길동", "둘리"};
		String[] tels = {"010-0000-0001","010-0000-0002","010-0000-0003"};
		
		
		for(int i = 0; i < names.length; i++) {
			String name = names[i];
			String tel = tels[i];
			String info = MessageFormat.format(pattern, name,tel);
			System.out.println(info);
		}
	}
}
