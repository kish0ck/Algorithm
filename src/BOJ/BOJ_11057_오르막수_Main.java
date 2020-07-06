package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2020-07-06
public class BOJ_11057_오르막수_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][10];
		
		for (int i = 0; i < 10; i++) {
			arr[0][i] = 1;
		}
		for (int i = 0; i < N+1; i++) {
			arr[i][0] = 1;
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < 10; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		System.out.println(arr[N][9]%10007);
	}

}
