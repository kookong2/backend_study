package day27;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Ex05 {
	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("aaa.txt")) {
			// int read() // 1byte unsigned 양의 정수 0 ~ 255, 내용의 끝에 도달하면 반환값 -1
			// byte -> short, int, long
			
			byte[] buckets = new byte[10];
			
			int no = 1;
			int i = 0;
			while((i = fis.read(buckets)) != -1) {
				//System.out.println(no++);
				//System.out.println(Arrays.toString(buckets));
				//System.out.println("읽어온 바이트 수 ? " + i);
				
				for(int j = 0; j < i; j++) {
					System.out.print((char)buckets[j]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
