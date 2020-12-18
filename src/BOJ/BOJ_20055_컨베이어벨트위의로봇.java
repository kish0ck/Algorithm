package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 1 ~ 2N-1
		int K = Integer.parseInt(st.nextToken()); // 단계
		st = new StringTokenizer(br.readLine()," ");
		
		int[][] cb = new int[2][N]; // 컨베이어벨트
		int[][] arr = new int[2][N]; // 내구도
		for (int i = 0; i < N; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N-1; i > -1; i--) {
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		
		int cnt = 0; // 카운트 개수
		
		// 회전
		while(true) {
			for (int i = 1; i < N-1; i++) {
				if(cb[0][i]==-1) {
					
				}
			}
			
		}
		
		
	}

}
