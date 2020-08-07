package BOJ;

import java.io.*;
import java.util.*;

public class RE_BOJ_10282_해킹_Main {

	private static boolean[] visited;
	private static int ans1;
	private static int ans2;
	private static List<int[]>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
			list = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				list[i] = new ArrayList<int[]>();
			}
			int d = Integer.parseInt(st.nextToken()); // 의존성 개수
			int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken())-1; // 컴퓨터 a가 컴퓨터 b를 의존하며 
				int b = Integer.parseInt(st.nextToken())-1; // 컴퓨터 b가 감염되면 
				int s = Integer.parseInt(st.nextToken()); // s초 후 컴퓨터 a도 감염
				list[b].add(new int[] {a,s});
			}
			visited = new boolean[n+1];
			ans1 = Integer.MIN_VALUE;
			ans2 = Integer.MAX_VALUE;
			dfs(c-1, 1, 0);
			System.out.println(ans1+" "+ans2);
		}
	}

	private static void dfs(int list_idx, int count, int time) {
		if(count>=ans1) {
			if(count==ans1) {
				if(ans2>time) ans2=time;
			}else {
				ans2=time;
			}
			ans1=count;
		}
		
		for (int i = 0; i < list[list_idx].size(); i++) {
			if(!visited[list[list_idx].get(i)[0]]) {
				visited[list[list_idx].get(i)[0]]=true;
				dfs(list[list_idx].get(i)[0], count+1,time+list[list_idx].get(i)[1]);
				visited[list[list_idx].get(i)[0]]=false;
			}
		}
	}

}
