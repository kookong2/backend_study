package week04;

import java.util.Random;

public class SelectionAlgorithm {
	public static void main(String[] args) {
		
		int [] arr = new int [20];
		
		Random random = new Random();
		
		int k = random.nextInt(arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100) + 1;
		}
		
		// 1. pivot 정하기
		
		// 2. partitioning
		
		// 3. k 값 = pivot(index) => pivot 출력
		
		// 4. k 값 < pivot(index) => left subarray 1번부터 다시 진행
		
		// 5. k 값 > pivot(index) => right subarray 1번부터 다시 진행
	}
}
