package day28;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Ex07 {
	public static void main(String[] args) {
		
		try (FileInputStream fis = new FileInputStream("user.dat");
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			/*
			Member user1 = (Member)ois.readObject();
			System.out.println(user1);
			
			Member user2 = (Member)ois.readObject();
			System.out.println(user2);
			*/
			
			List<Member> members = (List<Member>)ois.readObject();
			System.out.println(members);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
