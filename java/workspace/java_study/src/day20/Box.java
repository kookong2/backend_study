package day20;

import java.util.ArrayList;
import java.util.List;

public class Box <T>{	// T -> Apple
	
	private ArrayList<T> contents = new ArrayList<T>();
	
	// T - Object
	public void add(T content) {	// 컴파일 시 Fruit content
		contents.add(content);
		// Apple content
		//content.productInfo();
	}
	
	public List<T> getContents(){
		return contents;
	}
}
