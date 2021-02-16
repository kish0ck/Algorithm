package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작_Main {

	private static boolean flag;
	private static int[][] map;
	private static int N;
	private static int M;
	private static int H;
	private static boolean[][] visited;
	private static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][2*N-1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][2*(b-1)+1] = 1;
		}
		
		flag = false;
		int answer = 0;
		if(M==0) {
			System.out.println(answer);
		}else {
			while(true) {
				answer++;
				visited = new boolean[H][2*N-1];
				dfs(answer,0);
				if(flag) break;
				if(answer==4) {
					answer=-1;
					break;
				}
			}
			System.out.println(answer);
		}
		
	}

	private static void dfs(int totalCnt, int cnt) {
		if(cnt==totalCnt) {
			if(move()) flag = true;
			return;
		}
		
		if(flag) return;
		for (int i = 0; i < H; i++) {
			for (int j = 1; j < 2*N-1; j+=2) {
				if(!visited[i][j]&&map[i][j]!=1) {
					if(j+2<2*N-1) if(map[i][j+2]==1) continue;
					if(j-2>0)     if(map[i][j-2]==1) continue;
					visited[i][j]=true;
					map[i][j]=1;
					dfs(totalCnt,cnt+1);
					if(flag) return;
					map[i][j]=0;
					visited[i][j]=false;
				}
			}
		}
	}

	private static boolean move() {
		result = new int[2*N-1];
		for (int i = 0; i < 2*N-1; i+=2) {
			int r = 0;
			int c = i;
			while(true) {
				boolean check = false;
				if(c+1<2*N-1 && map[r][c+1]==1) {
					check = true;
					c+=2;
					r++;
					if(r==H) {
						result[i] = c;
						if(i!=c) return false;
						break;
					}
				}
				
				if(c-1>-1    && map[r][c-1]==1) {
					check = true;
					c-=2;
					r++;
					if(r==H) {
						result[i] = c;
						if(i!=c) return false;
						break;
					}
				}
				
				if(!check) {
					r++;
					if(r==H) {
						result[i] = c;
						if(i!=c) return false;
						break;
					}
				} 
			}
		}
		return true;
	}

}
