package day18;

import java.util.Arrays;
import java.util.List;

public class Ex08 {
	public static void main(String[] args) {
		
		List<String> fruits = Arrays.asList("사과","오렌지","바나나");
		
		System.out.println(fruits);
		
		int[][]nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.deepToString(nums));
		
		int[] nums2 = new int[10];
		Arrays.fill(nums2, 1);
		System.out.println(Arrays.toString(nums2));
		
		
		
		
	}
}
