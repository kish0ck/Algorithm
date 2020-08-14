package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_10836_여왕벌_Main {

	public static void main(String[] args) throws IOException {
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken()); // 격자 크기
		int N = Integer.parseInt(st.nextToken()); // 날짜 수
		
		int[][] map = new int[M][M];
		for (int i = 0; i < M; i++) {
			Arrays.fill(map[i], 1);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int val0 = Integer.parseInt(st.nextToken()); // 0 개수
			int val1 = Integer.parseInt(st.nextToken()); // 1 개수
			int val2 = Integer.parseInt(st.nextToken()); // 2 개수
			
			// 2. 구현
			// 2-1. 애벌레 키우기
			for (int r = M-1; r > -1; r--) {
				if(val0!=0) {
					val0--;
				}else if(val1!=0) {
					map[r][0] += 1;
					val1--;
				}else if(val2!=0) {
					map[r][0] += 2;
					val2--;
				}
			}
			for (int c = 1; c < M; c++) {
				if(val0!=0) {
					val0--;
				}else if(val1!=0) {
					map[0][c] += 1;
					val1--;
				}else if(val2!=0) {
					map[0][c] += 2;
					val2--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		// 2-2. 나머지 애벌레
		for (int r = 1; r < M; r++) {
			for (int c = 1; c < M; c++) {
				map[r][c] = (map[r-1][c]>map[r][c-1]) ? ((map[r-1][c]>map[r-1][c-1])?map[r-1][c]:map[r-1][c-1]) : ((map[r][c-1]>map[r-1][c-1])?map[r][c-1]:map[r-1][c-1]);
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]+" ");
			}sb.append("\n");
		}
		
		// 3. 출력
		System.out.println(sb.toString());
	}
}
