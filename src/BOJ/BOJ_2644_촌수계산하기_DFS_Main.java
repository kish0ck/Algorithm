package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산하기_DFS_Main {

	private static int result;
	private static int[][] matrix;
	private static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken()); // a와 b의 촌수 계산
		int m = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수 m
		matrix = new int[n][n];
		result = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
		dfs(a, b, 0, 0);
		System.out.println(result);
	}
	private static void dfs(int end, int now, int before, int cnt) {
		if(end == now) {
			result = cnt;
			return;
		}
		for (int i = 0; i < n; i++) {
			if(i!=before&&matrix[now][i]!=0) dfs(end, i, now, cnt+1);
		}
	}

}
