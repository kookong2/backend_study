package day12;

import java.io.*;

public class Ex01 {
	public static void main(String[] args) {
		
		// FileNotFoundException ,, .class 파일 x -> 실행 자체 x
		try {
			FileInputStream fis = new FileInputStream("aaa.txt"); // 실제 파일 x -> 예외 객체를 던지기			
			System.out.println("실행되는 부분!");
			
		}catch (FileNotFoundException e) {	// FileNotFoundException e = new FileNotFoundException(...);
			// IOException e = new FileNotFoundException(...);
			// Exception e = new FileNotFoundException(...);
			// Throwable e = new FileNotFoundExceoption(...);
			System.out.println("예외 발생!");
		}
		System.out.println("실행!");
	}
}
