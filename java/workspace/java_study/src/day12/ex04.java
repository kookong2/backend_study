package day12;

import java.io.*;

public class ex04 {
	public static void main(String[] args) {
		
		try {
			loadClass("aaa.txt", "Person");
			
		//} catch (FileNotFoundException | ClassNotFoundException e) {
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void loadClass(String fileName, String className)throws FileNotFoundException,
		ClassNotFoundException { 	// Exception -> 컴파일 시 체크되는 예외(엄격한 예외) - 형식 o
		
		FileInputStream fis = new FileInputStream(fileName);
		Class cls = Class.forName(className);
	}
}
