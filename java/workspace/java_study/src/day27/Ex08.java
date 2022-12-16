package day27;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ex08 {
	public static void main(String[] args) {
		
		try(FileOutputStream fos = new FileOutputStream("hello.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos)) {
			
			fos.write('안');
			fos.write('녕');
			fos.write('하');
			fos.write('세');
			fos.write('요');
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
