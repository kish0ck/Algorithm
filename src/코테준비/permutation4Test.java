package 코테준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class permutation4Test {
	static int N,R,numbers[];
	static int totalCount = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		R = Integer.parseInt(in.readLine());
		numbers = new int[R];
		
		permutation(0,  0);
		System.out.println("경우의 수 : " + totalCount);
	}
	
	private static void permutation(int index, int selected) {
		
		if(index == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1; i<=N; ++i) {
			if((selected & 1<<i)==0) {	// 해당 수가 선택되지 않았다면
				numbers[index] = i;
				permutation(index+1, selected | 1<<i); 	// 현재 선택한 수 사용한 플래그 처리
			}
		}
	}
}
