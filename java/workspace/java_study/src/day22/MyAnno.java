package day22;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, TYPE, FIELD, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnno {
	
	int num = 10;	// public static final	// 가능
	String[] value()default {"값1","값2"};	// 배열 가능
	//int nums(int n1, int n2); 			// 매개변수가 있는 추상 메서드 x
	//T value2();							// 지네릭 타입도 x
}
