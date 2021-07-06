package 코테준비;

import java.util.Arrays;
import java.util.Scanner;

public class SubSet1SumTest {
	// 입력받은 수들로 가능한 부분집합 모두 출력 : 재귀로 구현
	public static int[] arr;
	public static boolean[] isSelect;
	static int sum;
	static int ea = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sum = sc.nextInt();
		arr = new int[n];
		isSelect = new boolean[n];
		for(int i=0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		subSet(0);
		System.out.println("경우의 수 : " + ea);
	}
	
	public static void subSet(int s) {
		int ss;
		if(s==arr.length) {
			ss = 0;
			for(int i = 0,size = isSelect.length; i<size; i++) {
				if(isSelect[i])  ss += arr[i];
			}
			if(ss == sum) {
//				for(int i = 0,size = isSelect.length; i<size; i++) {
//					System.out.print(isSelect[i] ? arr[i] + " ": "");
//				}
//				System.out.println();
				ea++;
			}
		}
		else {
			for (int i = 1; i >= 0; --i) {
				isSelect[s] = i%2==1 ? true : false;
				subSet(s+1);
			}
		}
	}
}
