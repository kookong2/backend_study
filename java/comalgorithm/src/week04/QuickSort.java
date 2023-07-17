package week04;

import java.util.Arrays;

public class QuickSort {

	  public static void main(String[] args) {
	    int[] arr = { 23, 19, 78, 45, 30, 10, 7, 99, 43, 56 };
	    quickSort(arr);
	    System.out.println(Arrays.toString(arr));
	  }

	  public static void quickSort(int[] arr) {
	    quickSort(arr, 0, arr.length - 1);
	  }

	  private static void quickSort(int[] arr, int start, int end) {
	    if (start >= end)
	      return;
	    
	    int pivot = start;
	    int left = start + 1;
	    int right = end;
	    
	    while (left <= right) {
	      while (left <= end && arr[left] <= arr[pivot]) 
	        left++;
	      while (right > start && arr[right] >= arr[pivot]) 
	        right--;
	      if (left > right)				 
	        swap(arr, right, pivot);
	      else
	        swap(arr, left, right);			 
	      }
		
	    
	    quickSort(arr, start, right - 1);
	    quickSort(arr, right + 1, end);

	  }

	  private static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }
	}
