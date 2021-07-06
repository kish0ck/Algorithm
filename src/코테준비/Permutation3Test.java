package 코테준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Permutation3Test {
	// nPn
	
	static int N, R, numbers[];
	static boolean[] isSelected;
	static int totalCount=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		R = N;
		numbers = new int[N];
		isSelected = new boolean[N+1];
		
		permutation(0);
		System.out.println("경우의 수 : " + totalCount);
	}
	
	private static void permutation(int index) {
		
		if(index == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; ++i) {
//			if(isSelected[i]) continue; // 해당 수가 사용중이면 ++i로 
			if(!isSelected[i]) { 		// 해당 수가 선택되지 않았다면
				numbers[index] = i;		// index 턴으로봄
				isSelected[i] = true; // 현재 선택한수 사용한 플래그 처리
				permutation(index+1);
				isSelected[i] = false;
			}
		}
	}

}
