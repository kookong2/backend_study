package day13.sub1;

import java.util.Objects;

public class Person {
	private int age;
	private String name;
	
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(name, age);
		
		return hash;
	}

	@Override
	public boolean equals(Object obj) { // Object obj = new Person()
		
		if(obj instanceof Person) {
			//Person p1 = this;
			Person p2 = (Person)obj;
			if(p2.name.equals(name)&&p2.age == age) {
				return true;
			}	
		}
		return false;
	}
	
	
	
}
