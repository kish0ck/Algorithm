package 개념;

import java.util.Arrays;

//2020-06-14
public class NextPermutaion {
/*
 * 첫 번째 단계로는 맨 뒤에서부터 탐색하며, 교환할 위치를 찾아야한다.
 * 뒤쪽부터 탐색하며, i보다 값이 작은 i-1 인덱스를 발견하는 순간이 교환할 위치 i-1이 된다.
 * 
 * 두 번째 단계로는 내가 찾은 i-1 인덱스의 배열 값과, 교환할 i-1보다 큰 위치 j를 찾는 것이다.
 * 이렇게 찾은 i-1자리와 j의 값을 교환한다.
 * 
 * 마지막으로는, 다음 순열의 사전순의 특징을 위해 i번째 인덱스부터 맨마지막 인덱스의 배열 값을 오름차순으로 바꿔주는 작업이 필요하다. 
 * */
	static int N,totalCount;
	static int[] numbers;
	
	public static void main(String[] args) {
		N = 5;
		numbers =  new int[] {1,2,3,4,5};
		Arrays.sort(numbers);
		
		do {
			System.out.println(Arrays.toString(numbers));
		}while(nextPermutation());
		System.out.println("총 경우의 수 : "+totalCount);
	}

	private static boolean nextPermutation() {
		totalCount++;
		//1. 뒷쪽부터 왼쪽으로 탐색하며 교환이 필요한 위치 찾기
		int i=N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		// 찾은위치가 0이면 이미 내림차순된 순열이므로 다음순열은 없다.
		if(i==0) return false;
		
		//2. i-1위치 : 교환이 필요한 위치
		//	 i-1위치값과 교환할 뒷쪽에서 다음 큰 수 찾기
		int j = N-1;
		while(numbers[i-1]>= numbers[j]) --j;

		//3. i-1위치값과 j위치값 교환
		swap(i-1, j);
		
		//4. i위치부터 끝까지의 순열을 오름차순으로 재조정
		j = N-1;
		while(i<j) {
			swap(i++, j--);
		}
		return true;
	}
	
	private static void swap(int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
