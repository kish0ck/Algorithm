package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS_Main {

	private static int[][] matrix;
	private static int N;
	private static int M;
	private static boolean[] visitedD;
	private static boolean[] visitedB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점 번호
		
		matrix = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		visitedD = new boolean[N+1];
		visitedD[V] = true;
		System.out.print(V+" ");
		dfs(V);
		System.out.println();
		visitedB = new boolean[N+1];
		bfs(V);
		
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		visitedB[v]=true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur+" ");
			for (int i = 1; i <= N; i++) {
				if(matrix[cur][i]==1&&!visitedB[i]) {
					visitedB[i]=true;
					q.offer(i);
				}
			}
		}
	}

	private static void dfs(int v) {
		for (int i = 1; i <= N; i++) {
			if(!visitedD[i]&&matrix[v][i]==1) {
				visitedD[i]=true;
				System.out.print(i+" ");
				dfs(i);
			}
		}
	}

}
