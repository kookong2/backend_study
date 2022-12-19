package day28;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04 {
	public static void main(String[] args) {
		
		try(FileOutputStream fos = new FileOutputStream("data3.txt");
			DataOutputStream dos = new DataOutputStream(fos)) {
			
			dos.writeInt(100);
			dos.writeChar('A');
			dos.writeUTF("안녕");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (FileInputStream fis = new FileInputStream("data3.txt");
			DataInputStream dis = new DataInputStream(fis)){
			
			int num = dis.readInt();
			char ch = dis.readChar();
			String str = dis.readUTF();
			System.out.printf("%d,%c,s", num,ch,str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
