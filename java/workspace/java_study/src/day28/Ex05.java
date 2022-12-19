package day28;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex05 {
	public static void main(String[] args) {
		
		try(RandomAccessFile ra = new RandomAccessFile("data4.txt","rw")) {
			ra.writeInt(100);
			System.out.println(ra.getFilePointer());
			ra.writeChar('A');
			System.out.println(ra.getFilePointer());
			ra.writeUTF("안녕!");
			System.out.println(ra.getFilePointer());
			
			ra.seek(0);
			System.out.println(ra.getFilePointer());
			
			int num = ra.readInt();
			System.out.println(ra.getFilePointer());
			
			char ch = ra.readChar();
			System.out.println(ra.getFilePointer());
			
			String str = ra.readUTF();
			System.out.println(ra.getFilePointer());
			
			System.out.printf("%d,%c,%s",num,ch,str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
