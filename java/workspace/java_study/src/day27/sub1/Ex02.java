package day27.sub1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex02 {
	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("data1.txt");
			DataInputStream dis = new DataInputStream(fis)) {
			
			int num = dis.readInt();
			char ch = dis.readChar();
			String str = dis.readUTF();
			
			System.out.println(num);
			System.out.println(ch);
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
