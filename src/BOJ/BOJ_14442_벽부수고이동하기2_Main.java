package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기2_Main {
	static class Node{
		int r;
		int c;
		int k;
		public Node(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[N][M][K+1];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		Node node = new Node(0,0,0);
		Queue<Node> q = new LinkedList<Node>();
		visited[0][0][0] = true;
		q.offer(node);
		int ans=0;
		int[] dr = {0,0,1,-1}, dc= {1,-1,0,0};
		boolean flag=false;
loop:	while(!q.isEmpty()) {
			ans++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				int r = cur.r;
				int c = cur.c;
				int k = cur.k;
				
				if(r==N-1&&c==M-1) {
					flag = true;
					break loop;
				}
				
				for (int d = 0; d < 4; d++) {
					int nr = r +dr[d];
					int nc = c +dc[d];
					if(nr>-1&&nc>-1&&nr<N&&nc<M) {
						if(map[nr][nc]==0&&!visited[nr][nc][k]) {
							visited[nr][nc][k]=true;
							q.offer(new Node(nr,nc,k));
						}else {
							if(k+1<=K&&!visited[nr][nc][k+1]) {
								visited[nr][nc][k+1]=true;
								q.offer(new Node(nr,nc,k+1));
							}
						}
					}
				}
				
				
			}
		}
		if(flag) {
			System.out.println(ans);
		} else System.out.println("-1");
		
	}

}
