package 개념;

public class BinarySearch1 {
// 이진탐색 - 반복문
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		// ex) 3을 찾을때
		int value = 3;
		int result = BinarySearch(arr, value);
		System.out.println(result);

	}

	private static int BinarySearch(int[] arr, int value) {
		int start = 0, end = arr.length - 1, mid = 0;
		while(start<=end) {
			mid = (start + end) /2;
			if(value > arr[mid]) start = mid+1;
			else end = mid-1;
		}
		return end+1;
	}

}
