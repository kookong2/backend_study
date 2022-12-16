package day27;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex07 {
	public static void main(String[] args) {
		
		try(FileReader fr = new FileReader("hello.txt");
			BufferedReader br = new BufferedReader(fr)) {
			
			// 문장 단위로 읽어올 때
			StringBuffer sb = new StringBuffer(50);
			String line = null;
			while((line = br.readLine()) != null) {
				//System.out.println(line);
				sb.append(line);
			}
			System.out.println(sb.toString());
		
			/*
			int i = 0;
			
			while((i = br.read()) != -1) {
				System.out.print((char)i);
			}
			*/
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
