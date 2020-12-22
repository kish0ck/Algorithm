package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭_Main {

	private static int result;
	private static List<Integer> list;
	private static int m;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		list = new ArrayList<Integer>();
		while(st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
		boolean[] visited = new boolean[n];
		result = Integer.MIN_VALUE;
		dfs(0, 0, visited);
		System.out.println(result);
		
	}

	private static void dfs(int cnt, int sum, boolean[] visited) {
		if(cnt==3) {
			if(sum>result) result=sum;
			return;
		}
		
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]&&list.get(i)+sum<=m) {
				visited[i]=true;
				dfs(cnt+1,sum+list.get(i),visited);
				visited[i]=false;
			}
		}
		
	}


}
