package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14722_우유도시_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 딸기 -> 초코 -> 바나나 -> 딸기
		// 0 딸기, 1 초코, 2 바나나
		// r, c, 현재우유, 개수
		int[][][] dp = new int[N][N][3];
		int now_milk = 0;
		boolean flag = false;
		if(map[0][0]==0) {
			flag = true;
			now_milk = 1;
			dp[0][0][0]++;
		}
		
		for (int i = 1; i < N; i++) {
			dp[0][i]=dp[0][i-1].clone();
			if(map[0][i]==now_milk) {
				dp[0][i][now_milk]++;
				now_milk++;
				now_milk%=3;
			}
		}
		if(flag) {
			now_milk = 1;
		}else now_milk = 0;
		for (int i = 1; i < N; i++) {
			dp[i][0]=dp[i-1][0].clone();
			if(map[i][0]==now_milk) {
				dp[i][0][now_milk]++;
				now_milk++;
				now_milk%=3;
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				int sumR = 0;
				int sumC = 0;
				for (int q = 0; q < 3; q++) {
					sumR+=dp[i-1][j][q];
					sumC+=dp[i][j-1][q];
				}
				
				if(sumR>=sumC) {
					dp[i][j]=dp[i-1][j].clone();
					now_milk=sumR%3;
				}else if(sumR<sumC) {
					dp[i][j]=dp[i][j-1].clone();
					now_milk=sumC%3;
				}
				
				if(map[i][j]==now_milk) {
					dp[i][j][now_milk]++;
				}
				
			}
		}
		
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			ans+=dp[N-1][N-1][i];
		}
		System.out.println(ans);
		
	}

}
