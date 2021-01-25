package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식_Main {

	private static List[] list;
	private static boolean[] visited;
	private static List<Integer> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		list = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		result = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		visited[1] = true;
		int count = 0;
		for (int i = 0; i < list[1].size(); i++) {
			int next = (int) list[1].get(i);
			if(!visited[next]) {
				visited[next] = true;
				count++;
			}
			
			for (int j = 0; j < list[next].size(); j++) {
				int next2 = (int) list[next].get(j);
				if(!visited[next2]) {
					visited[next2] = true;
					count++;
				}
			}
			
		}
		
		System.out.println(count);
	}

}
