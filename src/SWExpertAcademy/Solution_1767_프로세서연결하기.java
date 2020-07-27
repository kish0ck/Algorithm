package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {

	private static int ans;
	private static int max;
	private static boolean[][] visited;
	private static int[][] map;
	private static List<int[]> list;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st;
			list = new ArrayList<int[]>();
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(i!=0&&j!=0&&i!=N-1&&j!=N-1) list.add(new int[] {i,j});
						visited[i][j]=true;
					} 
				}
			}
			ans = Integer.MAX_VALUE;
			max = 0;
			int[] cur = list.get(0);
			dfs(cur[0],cur[1],0,0,0);
			System.out.println("#"+tc+" "+ans);
		}
		
	}

	private static void dfs(int r, int c, int idx, int js, int cnt) {
		if(idx+1<=list.size()) {
			if(list.size()==idx+1) {
				int nr = r-1;
				int nc = c;
				int val = 0;
				boolean flag = false;
				while(nr>=0) {
					if(map[nr][nc]==1||visited[nr][nc]) {
						flag = true;
						break;
					} 
					val++;
					nr--;
				}
				if(!flag) {
					if(max<cnt+1) {
						max=cnt+1;
						ans=js+val;
					}else if(max==cnt+1&&ans>js+val) {
						ans=js+val;
					}
				}
				nr = r+1;
				nc = c;
				flag = false;
				val = 0;
				while(nr<=N-1) {
					if(map[nr][nc]==1||visited[nr][nc]) {
						flag = true;
						break;
					} 
					val++;
					nr++;
				}
				if(!flag) {
					if(max<cnt+1) {
						max = cnt+1;
						ans = js+val;
					}else if(max==cnt+1&&ans>js+val) {
						ans=js+val;
					}
				}
				// 좌
				flag = false;
				nr = r;
				nc = c-1;
				val = 0;
				while(nc>=0) {
					if(map[nr][nc]==1||visited[nr][nc]) {
						flag = true;
						break;
					} 
					val++;
					nc--;
				}
				if(!flag) {
					if(max<cnt+1) {
						max = cnt+1;
						ans = js+val;
					}else if(max==cnt+1&&ans>js+val) {
						ans=js+val;
					}
					
				}
				// 우
				flag = false;
				nr = r;
				nc = c+1;
				val=0;
				while(nc<=N-1) {
					if(map[nr][nc]==1||visited[nr][nc]) {
						flag = true;
						break;
					} 
					val++;
					nc++;
				}
				if(!flag) {
					if(max<cnt+1) {
						max=cnt+1;
						ans=js+val;
					}else if(max==cnt+1&&ans>js+val) {
						ans=js+val;
					}
					
				}
			}else {
				int[] next = list.get(idx+1);
				dfs(next[0],next[1],idx+1,js,cnt);
				int nr = r-1;
				int nc = c;
				int val = 0;
				boolean flag = false;
				// 상
				while(nr>=0) {
					if(map[nr][nc]==1||visited[nr][nc]) {
						flag = true;
						break;
					} 
					val++;
					nr--;
				}
				if(!flag) {
					if(max<cnt+1) {
						max=cnt+1;
						ans=js+val;
					}else if(max==cnt+1&&ans>js+val) {
						ans=js+val;
					}
					for (int j = r-1; j > -1; j--) {
						visited[j][c]=true;
					}
					dfs(next[0], next[1], idx+1, js+val, cnt+1);
					for (int j = r-1; j > -1; j--) {
						visited[j][c]=false;
					}
				}
				// 하
				nr = r+1;
				nc = c;
				flag = false;
				val = 0;
				while(nr<=N-1) {
					if(map[nr][nc]==1||visited[nr][nc]) {
						flag = true;
						break;
					} 
					val++;
					nr++;
				}
				if(!flag) {
					if(max<cnt+1) {
						max = cnt+1;
						ans = js+val;
					}else if(max==cnt+1&&ans>js+val) {
						ans=js+val;
					}
					for (int j = r+1; j < N; j++) {
						visited[j][c]=true;
					}
					dfs(next[0], next[1], idx+1, js+val,cnt+1);
					for (int j = r+1; j < N; j++) {
						visited[j][c]=false;
					}
				}
				// 좌
				flag = false;
				nr = r;
				nc = c-1;
				val = 0;
				while(nc>=0) {
					if(map[nr][nc]==1||visited[nr][nc]) {
						flag = true;
						break;
					} 
					val++;
					nc--;
				}
				if(!flag) {
					if(max<cnt+1) {
						max = cnt+1;
						ans = js+val;
					}else if(max==cnt+1&&ans>js+val) {
						ans=js+val;
					}
					for (int j = c-1; j > -1; j--) {
						visited[r][j]=true;
					}
					dfs(next[0], next[1], idx+1, js+val,cnt+1);
					for (int j = c-1; j > -1; j--) {
						visited[r][j]=false;
					}
				}
				// 우
				flag = false;
				nr = r;
				nc = c+1;
				val=0;
				while(nc<=N-1) {
					if(map[nr][nc]==1||visited[nr][nc]) {
						flag = true;
						break;
					} 
					val++;
					nc++;
				}
				if(!flag) {
					if(max<cnt+1) {
						max=cnt+1;
						ans=js+val;
					}else if(max==cnt+1&&ans>js+val) {
						ans=js+val;
					}
					for (int j = c+1; j < N; j++) {
						visited[r][j]=true;
					}
					dfs(next[0], next[1], idx+1, js+val,cnt+1);
					for (int j = c+1; j < N; j++) {
						visited[r][j]=false;
					}
				}
			}
			
		}
	}

}