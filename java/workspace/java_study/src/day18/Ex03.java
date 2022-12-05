package day18;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex03 {
	public static void main(String[] args) {

		HashMap<String, String> members = new HashMap<String,String>();

		members.put("user01", "123456");
		members.put("user02", "234567");
		members.put("user03", "123456");
		members.put("user04", "234567");
		
		for(Map.Entry<String, String> entry : members.entrySet()) {
			
			String key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("key = " + key + ", value = " + value);
		}
		
		// Collection -> Iterator
		Set<String> userIds = members.keySet();
		Collection<String> passwords = members.values();
		
		System.out.println(userIds);
		System.out.println(passwords);
		
		Iterator<String> ir = userIds.iterator();
		while(ir.hasNext()) {
			String key = ir.next();
			String value = members.get(key);
			System.out.println("key = " + key + ", value = " + value);
		}
	}
}
