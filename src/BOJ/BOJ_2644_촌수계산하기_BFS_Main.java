package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산하기_BFS_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 전체 사람의 수
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken()); // a와 b의 촌수 계산
		int m = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수 m
		int[][] matrix = new int[n][n];
		int[] answer = new int[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(a-1);
		visited[a-1]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == b) break;
			for (int i = 0; i < n; i++) {
				if(matrix[now][i] == 1 && visited[i] == false) {
					q.offer(i);
					visited[i]=true;
					answer[i] = answer[now]+1;
				}
			}
		}
		if(answer[b-1]==0) {
			System.out.println(-1);
		}else {
			System.out.println(answer[b-1]);
		}
	}

}
