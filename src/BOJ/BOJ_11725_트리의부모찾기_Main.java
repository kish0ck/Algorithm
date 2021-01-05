package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기_Main {

	private static int[] parents;
	private static boolean[] visited;
	private static List[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new List[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		parents = new int[N+1];
		visited = new boolean[N+1];
//		dfs(1);
//		for (int i = 2; i < N+1; i++) {
//			System.out.println(parents[i]);
//		}
		bfs(1);
		for (int i = 2; i < N+1; i++) {
		System.out.println(parents[i]);
		}
	}

	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < list[cur].size(); i++) {
				int next = (int) list[cur].get(i);
				if(!visited[next]) {
					visited[next] = true;
					parents[next] = cur;
					q.offer(next);
				}
			}
		}
	}

//	private static void dfs(int num) {
//		visited[num] = true;
//		for (int i = 0; i < list[num].size(); i++) {
//			int next = (int) list[num].get(i);
//			if(!visited[next]) {
//				visited[next] = true;
//				parents[next] = num;
//				dfs(next);
//			}
//		}
//		
//	}


}
