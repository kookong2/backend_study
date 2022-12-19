package day28;

import java.io.File;
import java.io.IOException;

public class Ex03 {
	public static void main(String[] args) throws Exception {
		
		File dir = new File("C:" + File.separator + "uploads");
		System.out.println(File.pathSeparator);
		dir.mkdir();
		
		File file = new File(dir,"blank.txt");
		file.createNewFile();
		
		String path = file.getPath();
		System.out.printf("파일 경로 : %s%n", path);
		String name = file.getName();
		System.out.printf("파일 명 : %s%n",name);
		
		File tmpFile = File.createTempFile("tmp", ".log", dir);
		System.out.printf("임시 파일 경로 : %s%n", tmpFile.getPath());
		tmpFile.deleteOnExit();		// 프로그램 종료 시에 삭제
		
		Thread.sleep(3000);
		file.delete();
		
		Thread.sleep(5000);
		
		System.out.println("blank.txt?" + file.exists());
		System.out.println("tmp file" + tmpFile.exists());
		
		
	}
}
