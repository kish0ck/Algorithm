package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pq.offer(new int[] {i,j,map[i][j]});
			}
		}
		int[][] dp = new int[N][N];
		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		int ans = 1;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			dp[r][c] = 1;
			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + r;
				int nc = dc[d] + c;
				if(nr>-1&&nc>-1&&nr<N&&nc<N&&map[r][c]>map[nr][nc]) {
					dp[r][c] = Math.max(dp[r][c], dp[nr][nc]+1);
					if(ans<dp[r][c]) ans=dp[r][c];
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
