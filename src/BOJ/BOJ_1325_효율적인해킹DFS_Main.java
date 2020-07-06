package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
// 인접행렬로는 안되네ㅋ
// StringBuilder 하니깐 됨 ㅋ
// DFS

public class BOJ_1325_효율적인해킹DFS_Main {

	private static int[] deep;
	private static boolean[] visited;
	private static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		deep = new int[N+1];
		
		list = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
		}

		for (int i = 1; i < N+1; i++) {
			visited = new boolean[N+1];
			dfs(i);
		}
		
		int max = 0;
		for (int i = 1; i < N+1; i++) {
			if(max<deep[i]) max = deep[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			if(deep[i]==max) sb.append(i+" ");
		}
		
		System.out.println(sb.toString());
		
	}

	private static void dfs(int v) {
		visited[v] = true;
		
		for (int vv : list[v]) {
			if(!visited[vv]) {
				deep[vv]++;
				dfs(vv);
			}
		}
	}

}
