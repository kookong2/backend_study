package day27;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex04 {
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		try(FileInputStream fis = new FileInputStream("...");
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream("...2");
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			int i = 0;
			while((i = bis.read()) != -1) {
				bos.write(i);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (endTime - startTime));
	}
}
