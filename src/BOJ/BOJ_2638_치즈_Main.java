package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈_Main {

	private static boolean[][] visited;
	private static int[] dr;
	private static int[] dc;
	private static int[][] map;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cheese++;
			}
		}
		dr = new int[] {0,0,1,-1};
		dc = new int[] {1,-1,0,0};
		int ans = 0;
loop:	while(true) {
			visited = new boolean[N][M];//외부공기true
			bfs(0,0);
			ans++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1) {
						int cnt=0;
loop2:					for (int d = 0; d < 4; d++) {
							int ni = dr[d]+i;
							int nj = dc[d]+j;
							if(ni>-1&&nj>-1&&ni<N&&nj<M&&visited[ni][nj]&&map[ni][nj]==0) {
								cnt++;
								if(cnt>1) {
									map[i][j]=0;
									cheese--;
									if(cheese==0) break loop;
									break loop2;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r,c});
		visited[r][c]=true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if(nr>-1&&nc>-1&&nr<N&&nc<M&&!visited[nr][nc]&&map[nr][nc]==0) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}

}
