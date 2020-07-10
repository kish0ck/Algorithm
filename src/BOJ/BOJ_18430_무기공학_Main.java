package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18430_무기공학_Main {

	private static int[][] map;
	private static boolean[][] visited;
	private static int max;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		max = Integer.MIN_VALUE;
		dfs(0,0,0);
		System.out.println(max);
	}

	private static void dfs(int r, int c, int sum) {
		if(sum>max) max=sum;
		
		for (int i = r; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if(j-1>-1&&i-1>-1&&!visited[i][j-1]&&!visited[i-1][j]&&!visited[i][j]) {//1
					int val = 0;
					val=(map[i][j]*2);
					val+=map[i][j-1];
					val+=map[i-1][j];
					visited[i][j]=true;
					visited[i][j-1]=true;
					visited[i-1][j]=true;
					
					dfs(i,j,sum+val);
					
					visited[i][j]=false;
					visited[i][j-1]=false;
					visited[i-1][j]=false;
				}
				
				if(j+1<M&&i-1>-1&&!visited[i][j+1]&&!visited[i-1][j]&&!visited[i][j]) {//2
					int val = 0;
					val=(map[i][j]*2);
					val+=map[i-1][j];
					val+=map[i][j+1];
					visited[i][j]=true;
					visited[i-1][j]=true;
					visited[i][j+1]=true;

					dfs(i,j,sum+val);
					
					visited[i][j]=false;
					visited[i-1][j]=false;
					visited[i][j+1]=false;
				}
				
				if(j-1>-1&&i+1<N&&!visited[i][j-1]&&!visited[i+1][j]&&!visited[i][j]) {//3
					int val = 0;
					val=(map[i][j]*2);
					val+=map[i+1][j];
					val+=map[i][j-1];
					visited[i][j]=true;
					visited[i][j-1]=true;
					visited[i+1][j]=true;
					
					dfs(i,j,sum+val);
					
					visited[i][j]=false;
					visited[i][j-1]=false;
					visited[i+1][j]=false;
				}
				
				if(j+1<M&&i+1<N&&!visited[i+1][j]&&!visited[i][j+1]&&!visited[i][j]) {//4
					int val = 0;
					val=(map[i][j]*2);
					val+=map[i+1][j];
					val+=map[i][j+1];
					visited[i][j]=true;
					visited[i+1][j]=true;
					visited[i][j+1]=true;
				
					dfs(i,j,sum+val);
				
					visited[i][j]=false;
					visited[i+1][j]=false;
					visited[i][j+1]=false;
				}
			}
		}
		
	}

}
