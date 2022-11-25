package day12.sub2;

import java.io.*;

public class Ex02 {
	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("aaa.txt")) {
			int i = 0;
			while((i = fis.read())!= -1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
