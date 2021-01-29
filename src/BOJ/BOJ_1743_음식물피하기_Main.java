package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기_Main {

	private static boolean[][] visited;
	private static int max;
	private static int N;
	private static int M;
	private static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 쓰레기의 개수
		map = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = true;
		}
		max = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]&&map[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(max);
	}

	private static void bfs(int i, int j) {
		visited[i][j] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		int count = 1;
		int[] dr = {0,0,1,-1}, dc= {1,-1,0,0};
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr>-1&&nc>-1&&nr<N&&nc<M&&!visited[nr][nc]&&map[nr][nc]) {
					visited[nr][nc] = true;
					count++;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		if(max<count) max=count;
	}

}
