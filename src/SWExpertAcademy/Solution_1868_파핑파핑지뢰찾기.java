package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//2020-07-20
public class Solution_1868_파핑파핑지뢰찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				map[i] = input.toCharArray();
			}
			int dr[] = {-1,-1,-1,0,0,1,1,1};
			int dc[] = {-1,0,1,-1,1,-1,0,1};
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.'&&!visited[i][j]) {
						boolean flag = false;
						Queue<int[]> q = new LinkedList<int[]>();
						q.offer(new int[] {i,j});
						while(!q.isEmpty()) {
								int[] cur = q.poll();
								int c = 0;
								for (int d = 0; d < 8; d++) {
									int nr = dr[d]+cur[0];
									int nc = dc[d]+cur[1];
									if(nr>-1&&nc>-1&&nr<N&&nc<N) {
										if(map[nr][nc]=='*') c++;
									}
								}
								if(c==0) {
									flag = true;
									visited[cur[0]][cur[1]] = true;
									for (int d = 0; d < 8; d++) {
										int nr = dr[d]+cur[0];
										int nc = dc[d]+cur[1];
										if(nr>-1&&nc>-1&&nr<N&&nc<N&&!visited[nr][nc]) {
											visited[nr][nc] = true;
											q.offer(new int[] {nr,nc});
										} 
								}
							}
						}
						if(flag) ans++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]&&map[i][j]=='.') ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

}
