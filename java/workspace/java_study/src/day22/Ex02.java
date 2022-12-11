package day22;

import java.util.Arrays;

@MyAnno({"값1","값2","값3"})
public class Ex02 {
	public static void main(String[] args) {
		
		Class<Ex02> cls = Ex02.class;
		
		MyAnno anno = cls.getAnnotation(MyAnno.class);
		
		String[] values = anno.value();
		System.out.println(Arrays.toString(values));
	}
}
