package 코테준비;

import java.util.Arrays;
import java.util.Scanner;

public class SubSet2SumTest {
	// 입력받은 수들로 가능한 부분집합 모두 출력 : 재귀로 구현
	public static int[] arr;
	static int sum;
	static int ea = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sum = sc.nextInt();
		arr = new int[n];
		for(int i=0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		subSet2(0, 0, "");
		System.out.println("경우의 수 : " + ea);
	}
	
	public static void subSet(int index, int total) {
		if(index==arr.length) {
			if(total == sum) ea++;
			return;
		}
		subSet(index+1, total+arr[index]);
		subSet(index+1, total);
	}
	public static void subSet2(int index, int total, String result) {
		if(index==arr.length) {
			if(total == sum) {
				ea++;
				System.out.println(result);
			}
			return;
		}
		subSet2(index+1, total+arr[index], result+arr[index]+" ");
		subSet2(index+1, total, result);
	}
}
