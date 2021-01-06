package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기_Main {
	static class Node {
		int r;
		int c;
		boolean flag;
		public Node(int r, int c, boolean flag) {
			super();
			this.r = r;
			this.c = c;
			this.flag = flag; // false = 벽 부수기 사용 가능, true = 벽 부수기 사용 불가
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		Queue<Node> q = new LinkedList<Node>();
		boolean[][][] visited = new boolean[N][M][2]; // 0 = 벽 부수기 사용안했을때, 1 = 벽부수기 사용했을때
		
		q.offer(new Node(0, 0, false));
		visited[0][0][0] = true;
		
		boolean check = false;
		int result = 0;
		
bfs:	while(!q.isEmpty()) {
			int size = q.size();
			result++;
			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				int r = cur.r;
				int c = cur.c;
				boolean flag = cur.flag;
				
				for (int d = 0; d < 4; d++) {
					int nr = dr[d] + r;
					int nc = dc[d] + c;
					if(nr>-1&&nc>-1&&nr<N&&nc<M) {
						
						if(nr==N-1&&nc==M-1) {
							check = true;
							break bfs;
						}
						
						if(!flag) { //벽 부수기 사용 가능
							if(map[nr][nc]=='1'&&!visited[nr][nc][0]) { // 벽
								visited[nr][nc][1]=true;
								q.offer(new Node(nr, nc, true));
							}else if(map[nr][nc]=='0'&&!visited[nr][nc][0]) {
								visited[nr][nc][0]=true;
								q.offer(new Node(nr, nc, false));
							}
						}else { // 벽 부수기 사용 불가
							if(map[nr][nc]=='0'&&!visited[nr][nc][1]) {
								visited[nr][nc][1] = true;
								q.offer(new Node(nr, nc, true));
							}
						}
					}
				}
			}
			
		}
		
		if(!check) {
			result = -1;
		} else {
			result++;
		}
		
		if(N==1 && M==1) result = 1;
		
		System.out.println(result);
	}

}
