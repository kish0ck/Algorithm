package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {

	private static int N;
	private static int K;
	private static int ans;
	private static boolean flag;
	private static boolean[][] visited;
	private static int[] dr;
	private static int[] dc;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(max<map[i][j]) max=map[i][j];
				}
			}
			List<int[]> list = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(max==map[i][j]) list.add(new int[] {i,j});
				}
			}
			dr = new int[] {0,0,1,-1};
			dc = new int[] {1,-1,0,0};
			for (int i = 0; i < list.size(); i++) {
				visited = new boolean[N][N];
				flag = false;
				int[] cur = list.get(i);
				visited[cur[0]][cur[1]] = true;
				dfs(cur[0],cur[1],0);
			}
			
			System.out.println("#"+tc+" "+(ans+1));
		}
	}

	private static void dfs(int r, int c, int deep) {
		if(ans<deep) {
			ans=deep;
		} 
		
		if(flag) {//K사용한 후
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>-1&&nc>-1&&nr<N&&nc<N&&!visited[nr][nc]&&map[r][c]>=map[nr][nc]) {
					if(map[nr][nc]<map[r][c]) {
						visited[nr][nc]=true;
						dfs(nr,nc,deep+1);
						visited[nr][nc]=false;
					}
					
				}
			}
		}else {// K사용 전
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>-1&&nc>-1&&nr<N&&nc<N&&!visited[nr][nc]) {
					if(map[nr][nc]<map[r][c]) {
						// K 안사용
						visited[nr][nc]=true;
						dfs(nr,nc,deep+1);
						visited[nr][nc]=false;
						
						for (int k = 1; k < K+1; k++) { // K사용
							map[nr][nc]-=k;
							visited[nr][nc]=true;
							flag=true;
							dfs(nr,nc,deep+1);
							flag=false;
							visited[nr][nc]=false;
							map[nr][nc]+=k;
						}
						
					}else {
						if(map[nr][nc]-K<map[r][c]) {
							for (int k = 1; k < K+1; k++) {
								if(map[nr][nc]-k<map[r][c]) {
									map[nr][nc]-=k;
									visited[nr][nc]=true;
									flag=true;
									dfs(nr,nc,deep+1);
									flag=false;
									visited[nr][nc]=false;
									map[nr][nc]+=k;
								}
							}
						}
					}
				}
			}
		}
	}

}
