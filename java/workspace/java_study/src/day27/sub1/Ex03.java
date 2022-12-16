package day27.sub1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Ex03 {
	public static void main(String[] args) {
		
		try(FileOutputStream fos = new FileOutputStream("data2.txt");
			PrintStream ps = new PrintStream(fos)) {
			
			ps.println("안녕");
			ps.println("Hello");
			
			ps.printf("%d + %d = %d%n",10,20,30);
			ps.printf("%s님 안녕하세요!%n", "이름1");
			ps.printf("실수 : %f%n", 10.1234);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
