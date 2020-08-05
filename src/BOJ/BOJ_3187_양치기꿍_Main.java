package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187_양치기꿍_Main {

	public static void main(String[] args) throws IOException {
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}
		
		// 2. bfs
		int ans_k = 0;
		int ans_v = 0;
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j]&&map[i][j]!='#') {
					visited[i][j] = true;
					int k_cnt=0, v_cnt=0;
					if(map[i][j]=='k') k_cnt++;
					if(map[i][j]=='v') v_cnt++;
					Queue<int[]> q = new LinkedList<int[]>();
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int nr = cur[0]+dr[d];
							int nc = cur[1]+dc[d];
							if(nr>-1&&nc>-1&&nr<R&&nc<C&&!visited[nr][nc]&&map[nr][nc]!='#') {
								if(map[nr][nc]=='k') k_cnt++;
								if(map[nr][nc]=='v') v_cnt++;
								visited[nr][nc]=true;
								q.offer(new int[] {nr, nc});
							}
						}
					}
					if(k_cnt>v_cnt) {
						ans_k+=k_cnt;
					} else {
						ans_v+=v_cnt;
					} 
				}
			}
		}
		
		System.out.println(ans_k + " " + ans_v);
	}

}
