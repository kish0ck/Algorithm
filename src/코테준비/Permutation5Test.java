package 코테준비;

import java.util.Arrays;

public class Permutation5Test {
	static int[] numbers;
	static int N, totalCount;
	public static void main(String[] args) {
		N=4;
		numbers = new int[] {1,2,3,4};
//		Arrays.sort(numbers);
//		do {
//			System.out.println(Arrays.toString(numbers));
//		} while(nextPermutation());
//		System.out.println("총 경우의 수 : " + totalCount);
		permutation(0);
	}
	
	private static void permutation(int index) {
		if(index == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=index; i<N; ++i) {
			swap(index, i);
			permutation(index+1);
			swap(i, index);	// 되돌려놓기 : 처음 상태로 만들기
		}
	}
	
	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	public static boolean nextPermutation() {
		totalCount++;
		// 1. 뒷쪽부터 왼쪽으로 탐색하며 교환이 필요한 위치 찾기
		int i=N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) --i;
		
		// 찾은 위치가 0이면 이미 내림차순된 순열이므로 다음 순열은 없다.
		if(i==0) return false;
		
		// 2. i-1 위치 : 교환이 필요한 위치
		//    i-1 위치값과 교환할 뒷쪽에서 다음 큰 수 찾기
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		// 3. i-1 위치값과 j 위치값 교환
		swap(i-1, j);
		// 4. i 위치부터 끝까지의 순열을 오름차순으로 재조정
		j = N-1;
		while(i<j) swap(i++, j--);
		return true;
	}
}
