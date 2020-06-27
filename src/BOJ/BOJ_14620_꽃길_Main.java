package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14620_꽃길_Main {

	private static int ans;
	private static int N;
	private static boolean[][] visited;
	private static int[] dx;
	private static int[] dy;
	private static int[][] map;
	private static List<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dx = new int[] {0,0,1,-1};
		dy = new int[] {1,-1,0,0};
		visited = new boolean[N][N];
		list = new ArrayList<int[]>();
		ans = Integer.MAX_VALUE;
		go(0,0);
		System.out.println(ans);
		
	}

	private static void go(int cnt, int sum) {
		if(cnt==3) {
			if(sum<ans) ans=sum;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					int count=0;
					for (int d = 0; d < 4; d++) {
						int ni = i + dx[d];
						int nj = j + dy[d];
						if(ni>-1&&nj>-1&&ni<N&&nj<N&&!visited[ni][nj]) {
							count++;
						}
					}
					if(count==4) {
						int plus=0;
						for (int d = 0; d < 4; d++) {
							int ni = i + dx[d];
							int nj = j + dy[d];
							plus+=map[ni][nj];
							visited[ni][nj] = true;
						}
						plus+=map[i][j];
						go(cnt+1, sum+plus);
						for (int d = 0; d < 4; d++) {
							int ni = i + dx[d];
							int nj = j + dy[d];
							visited[ni][nj] = false;
						}
					}
					visited[i][j] = false;
				}
			}
		}
	}

}
