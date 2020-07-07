package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14722_우유도시_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 딸기 -> 초코 -> 바나나 -> 딸기
		// 0 딸기, 1 초코, 2 바나나
		// r, c, 현재우유, 개수
		int[] dr = {0,1}, dc= {1,0};
		int ans = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<boolean[][]> q2 = new LinkedList<boolean[][]>();
		if(map[0][0]==0) {
			q.offer(new int[] {0, 0, 0, 1});
			boolean[][] visited = new boolean[N][N];
			visited[0][0] = true;
			q2.offer(visited);
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			boolean[][] cur_visited = q2.poll();
			cur_visited[cur[0]][cur[1]] = true;
			int now_milk = cur[2];
			int next_milk = -1;
			switch(now_milk) {
				case 0:
					next_milk=1;
					break;
				case 1:
					next_milk=2;
					break;
				case 2:
					next_milk=0;
					break;
			}
			int cnt = cur[3];
			if(ans<cnt) ans=cnt;
			for (int d = 0; d < 2; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr>-1&&nc>-1&&nr<N&&nc<N&&!cur_visited[nr][nc]) {
					if(nr==N-1&&nc==N-1) {
						if(map[N-1][N-1]==next_milk) {
							if(ans<cnt+1) ans=cnt+1;
						} 
					}else {
						if(map[nr][nc]==next_milk) {
							q.offer(new int[] {nr,nc,next_milk,cnt+1});
							q2.offer(cur_visited);
						}else {
							q.offer(new int[] {nr,nc,now_milk,cnt});
							q2.offer(cur_visited);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}
