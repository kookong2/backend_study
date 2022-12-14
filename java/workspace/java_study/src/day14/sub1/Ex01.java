package day14.sub1;

import java.lang.reflect.*;

public class Ex01 {
	public static void main(String[] args) {

		//Person person = new Person("이름1", 30);
		//Class cls = person.getClass();
		//Class cls = Person.class;
		Class cls;
		try {
			cls = Class.forName("day14.sub1.Person");
			//System.out.println(clsClass.getName());

			//멤버 변수
			Field[] fields = cls.getFields();
			for(Field field : fields) {
				System.out.println(field);
			}
			System.out.println("------------메서드-------------");
			Method[] methods = cls.getMethods();
			for(Method method : methods) {
				System.out.println(method);
			}

			System.out.println("------------생성자-------------");
			Constructor[] cons = cls.getConstructors();
			for(Constructor con : cons) {
				System.out.println(con);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}
}
