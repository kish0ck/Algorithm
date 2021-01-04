package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토_Main_BFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		int[][] box = new int[N][M];
		int cnt0 = 0; // 토마토개수
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==0) {
					cnt0++;
				} else if(box[i][j]==1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		boolean[][] visited = new boolean[N][M];
		boolean flag;
		int answer = -1;
bfs:	while(!q.isEmpty()) {
			answer++;
			flag = false;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int r = cur[0]; int c = cur[1];
				for (int d = 0; d < 4; d++) {
					int nr = r + dx[d];
					int nc = c + dy[d];
					if(nr>-1&&nc>-1&&nr<N&&nc<M&&!visited[nr][nc]&&box[nr][nc]==0) {
						visited[nr][nc] = true;
						flag=true;
						box[nr][nc] = 1;
						q.offer(new int[] {nr, nc});
					}
				}
			}
			if(!flag) break bfs;
		}
		
out:	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j]==0) {
					answer=-1;
					break out;
				} 
			}
		}
		
		System.out.println(answer);
		
	}

}
