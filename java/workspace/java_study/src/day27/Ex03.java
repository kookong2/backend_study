package day27;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class Ex03 {
	public static void main(String[] args) {
		
		try(FileInputStream fis1 = new FileInputStream("num1.txt");
			FileInputStream fis2 = new FileInputStream("num2.txt");
			SequenceInputStream sis = new SequenceInputStream(fis1,fis2)) {
			
			int i = 0;
			while((i = sis.read()) != -1) {
				System.out.print((char)i);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
