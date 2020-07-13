package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RE_BOJ_1937_욕심쟁이판다_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean[][] visited = new boolean[N][N];
				Queue<int[]> q = new LinkedList<int[]>();
				q.offer(new int[] {i,j,map[i][j]});
				visited[i][j]=true;
				int K = 0;
				while(!q.isEmpty()) {
					int size = q.size();
					K++;
					for (int s = 0; s < size; s++) {
						int[] cur = q.poll();
						int r = cur[0];
						int c = cur[1];
						int val = cur[2];
						for (int d = 0; d < 4; d++) {
							int nr = dr[d]+r;
							int nc = dc[d]+c;
							if(nr>-1&&nc>-1&&nr<N&&nc<N&&!visited[nr][nc]&&val<map[nr][nc]) {
								visited[nr][nc]=true;
								q.offer(new int[] {nr,nc,map[nr][nc]});
							}
						}
					}
				}
				if(K>max) max = K;
			}
		}
		System.out.println(max);
		
	}

}
