package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10451_순열싸이클_Main {

	private static boolean[] visited;
	private static int N;
	private static int[][] matrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			matrix = new int[N+1][N+1];
			for (int i = 0; i < N; i++) {
				matrix[i+1][arr[i]] = 1;
			}
			
			visited = new boolean[N+1];
			int answer = 0;
			for (int i = 1; i < N+1; i++) {
				if(!visited[i]) {
					visited[i] = true;
					answer++;
					dfs(i);
				}	
			}
			
			System.out.println(answer);
		}
	}

	private static void dfs(int n) {
		for (int i = 1; i < N+1; i++) {
			if(!visited[i] && matrix[n][i]==1) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

}
