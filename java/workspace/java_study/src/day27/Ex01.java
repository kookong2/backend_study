package day27;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class Ex01 {

	public static void main(String[] args) {
		
		try(FileOutputStream fos = new FileOutputStream("aaa.txt")){
			char ch = 'A';
			for(int i = 0; i < 26; i++) {
				fos.write(ch);
				ch++;
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
