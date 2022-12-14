package day25;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex08 {
	public static void main(String[] args) {
		
		String[][] strs = {
				new String[] {"abc","def"},
				new String[] {"ghi","jkl"},
		};
		
		Stream<Stream<String>> stream1 = Arrays.stream(strs).map(Arrays::stream);
		
		long count = Arrays.stream(strs).flatMap(Arrays::stream).count();
		System.out.println(count);
	}
}
