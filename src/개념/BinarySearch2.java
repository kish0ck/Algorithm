package 개념;

public class BinarySearch2 {
	// 이진탐색 - 재귀
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int value = 3;
		int result = BinarySearch(arr, 0, arr.length-1, value);
		System.out.println(result);
	}

	private static int BinarySearch(int[] arr, int start, int end, int value) {
		if(start>end) {
			return end+1;
		}
		
		int mid = (start+end)/2;
		if(value > arr[mid]) return BinarySearch(arr, mid+1, end, value);
		else return BinarySearch(arr, start, mid-1, value);
		
	}

}
