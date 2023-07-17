package week03;

public class MargeSortEx {
	
	public static int[] src;
	public static int[] tmp;
	
	public static void main(String[] args) {
		src = new int[] {2, 87, 34 ,53, 12, 45, 23, 75};
		tmp = new int[src.length];
		printArray(src);
		margesort(0, src.length -1);
		printArray(src);
	}
	
	public static void margesort(int left, int right) {
		if(left < right) {
			int k = (left + right) / 2;
			margesort(left, k);
			margesort(k + 1, right);
			
			int p = left;
			int q = k + 1;
			int index = left;
			
			while(p <= k || q <= right) {
				if(q > right || (p <= k && src[p] < src[q])) {
					tmp[index++] = src[p++];
				}else {
					tmp[index++] = src[q++];
				}
			}
			
			for(int i = left; i <= right; i ++) {
				src[i] = tmp[i];
			}
		}
	}
	
	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			
		}
		System.out.println();
		
	}

}
