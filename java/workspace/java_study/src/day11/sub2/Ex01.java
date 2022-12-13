package day11.sub2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex01 {
	public static void main(String[] args) {
		
		// FileInputStream
		try {
			FileInputStream fis = new FileInputStream("111.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("무조건 실행!");
		}
	}
}
