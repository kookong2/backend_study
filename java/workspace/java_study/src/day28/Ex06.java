package day28;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ex06 {
	public static void main(String[] args) {
		
		Member user1 = new Member("user01", "12345678");
		Member user2 = new Member("user02", "12345678");
		
		List<Member> members = new ArrayList<>();
		members.add(user1);
		members.add(user2);

		try(FileOutputStream fos = new FileOutputStream("user.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(members);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
