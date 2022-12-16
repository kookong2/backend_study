package day27.sub1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01 {
	public static void main(String[] args) {
		
		try(FileOutputStream fos = new FileOutputStream("data1.txt");
			DataOutputStream dos = new DataOutputStream(fos)) {
			
			dos.writeInt(100);
			dos.writeChar('A');
			dos.writeUTF("안녕하세요");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
