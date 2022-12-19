package day28;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Ex02 {
	public static void main(String[] args)throws IOException {
		
		PrintStream out = new PrintStream(new FileOutputStream("log.txt"));
		System.setOut(out);
		
		System.out.println("기록!");
	}
}
