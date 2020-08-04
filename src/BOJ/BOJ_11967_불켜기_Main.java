package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11967_불켜기_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> map[][] = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<Integer>();
			}
		}
		boolean[][] light = new boolean[N][N];
		light[0][0] = true;
		List<int[]> info = new ArrayList<int[]>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y].add(i);
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			info.add(new int[] {a,b});
		}
		
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		int ans = 1;
		boolean[][] visited = new boolean[N][N]; //방문
		Queue<int[]> q = new LinkedList<int[]>(); //베시
		visited[0][0] = true;
		q.offer(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(map[cur[0]][cur[1]].size()!=0) {
				for (int i = 0; i < map[cur[0]][cur[1]].size(); i++) {
					int[] can_switch = info.get(map[cur[0]][cur[1]].get(i));
					int rr = can_switch[0];
					int cc = can_switch[1];
					if(!light[rr][cc]) {
						light[rr][cc] = true;
						ans++;
						for (int d = 0; d < 4; d++) {
							int nr = dr[d]+rr;
							int nc = dc[d]+cc;
							if(nr>-1&&nc>-1&&nr<N&&nc<N&&light[nr][nc]&&visited[nr][nc]) {
								q.offer(new int[] {nr,nc});
								break;
							}
						}
					}
				}
			}
			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + cur[0];
				int nc = dc[d] + cur[1];
				if(nr>-1&&nc>-1&&nr<N&&nc<N&&light[nr][nc]&&!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
 		}
 		System.out.println(ans);
	}

}
