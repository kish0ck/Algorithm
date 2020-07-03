package 개념;

import java.util.Scanner;

public class LIS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] array = new int[N]; // 인덱스마다 각 입력값
		int[] dp = new int[N]; // 인덱스마다 각 증가 수열의 길이
		int max = 0;
		dp[0] = 1;

		for(int i=1;i<N;i++) {
		    dp[i] = 1;
		    // i 를 기준으로 인덱스 0 에서부터 i-1까지 체크한다 
		    // 길이를 기준
		    for(int j=0;j<i;j++) {
		        if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
		            // 증가 수열
		            dp[i] = dp[j] + 1;
		        }
		    }

		    if (max < dp[i]) {
		        max = dp[i];
		    }

		}



	}

}
