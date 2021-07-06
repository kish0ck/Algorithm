package 코테준비;

import java.util.Scanner;

public class SubSet2Test {
	// 입력받은 수들로 가능한 부분집합 모두 출력 : 재귀로 구현
	public static int[] arr;
	public static boolean[] isSelect;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		isSelect = new boolean[n];
		for(int i=0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
		subSet(0);
	}
	
	public static void subSet(int s) {
		if(s==arr.length) {
			for(int i = 0,size = isSelect.length; i<size; i++) {
				System.out.print((isSelect[i] ? arr[i] : "X") + "\t");
			}
			System.out.println();
		}
		else {
			for (int i = 1; i >= 0; --i) {
				isSelect[s] = i%2==1 ? true : false;
				subSet(s+1);
			}
		}
	}
}
