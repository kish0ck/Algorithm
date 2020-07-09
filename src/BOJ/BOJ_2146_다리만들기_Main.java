package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 2020-07-09
public class BOJ_2146_다리만들기_Main {

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
		int ans = Integer.MAX_VALUE;
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					
					boolean flag = false;
					Queue<int[]> q2 = new LinkedList<int[]>();
					for (int k = 0; k < 4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr>-1&&nc>-1&&nr<N&&nc<N&&map[nr][nc]==0) {
							flag=true;
							q2.offer(new int[] {nr,nc});
						}
					}
					
					if(flag) {
						boolean[][] visited = new boolean[N][N];
						visited[i][j] = true;
						Queue<int[]> q = new LinkedList<int[]>();
						q.offer(new int[] {i,j});
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							for (int k = 0; k < 4; k++) {
								int nr = cur[0]+dr[k];
								int nc = cur[1]+dc[k];
								if(nr>-1&&nc>-1&&nr<N&&nc<N&&!visited[nr][nc]&&map[nr][nc]==1) {
									visited[nr][nc]=true;
									q.offer(new int[] {nr,nc});
								}
							}
						}
						
						int lv = 0;
loop:					while(!q2.isEmpty()) {
							int size = q2.size();
							lv++;
							for (int s = 0; s < size; s++) {
								int[] cur = q2.poll();
								for (int k = 0; k < 4; k++) {
									int nr = cur[0]+dr[k];
									int nc = cur[1]+dc[k];
									if(nr>-1&&nc>-1&&nr<N&&nc<N&&!visited[nr][nc]) {
										visited[nr][nc] = true;
										if(map[nr][nc]==0) {
											q2.offer(new int[] {nr,nc});
										}else {
											if(lv<ans) ans=lv;
											break loop;
										}
									}
								}
								
							}
						}
						
						
					}
					
				}
			}
		}
		
		System.out.println(ans);
		
		
		
		
	}

}
