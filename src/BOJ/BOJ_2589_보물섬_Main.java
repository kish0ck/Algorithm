package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬_Main {

	private static int result;
	private static int r;
	private static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		System.out.println(result-1);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i, j});
		boolean[][] visited = new boolean[r][c];
		int count = 0;
		int[] dr = {0,0,1,-1}, dc = {1,-1,0,0};
		visited[i][j] = true;
		while(!q.isEmpty()) {
			count++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if(nr>-1&&nc>-1&&nr<r&&nc<r&&!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new int[] {nr,nc});
					}
				}
			}
		}
		if(count>result) result = count;
		
	}

}
