package SOCAR_20200823;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

	private static int ans;
	private static int[] dr;
	private static int[] dc;
	private static int size;
	private static int[][] dl;

	public static void main(String[] args) {
		int r=3;
		int[][] delivery = {
				{1, 5},{8, 3},{4, 2},
				{2, 3},{3, 1},{3, 2},
				{4, 2},{5, 2},{4, 1}
				};
		int result = solution(r, delivery);
		
		System.out.println(result);
	}

	private static int solution(int r, int[][] delivery) {
		ans = 0;
		dr = new int[] {0,0,1,-1};
		dc = new int[] {1,-1,0,0};
		size = r;
		dl = delivery;
		boolean[][] tip = new boolean[r][r];
		boolean[][] visited = new boolean[r][r];
		dfs(0,0,0,0,tip,visited);
		
		return ans;
		}

	private static void dfs(int rr, int cc, int time, int tip, boolean[][] tip_visited, boolean[][] visited) {
		if(tip>ans) ans=tip;
		
		for (int d = 0; d < 4; d++) {
			int nr = rr + dr[d];
			int nc = cc + dc[d];
			if(nr>-1&&nc>-1&&nr<size&&nc<size&&!visited[nr][nc]) {
				if(!tip_visited[nr][nc]) {
					boolean[][] v = new boolean[size][size];
					if(time <= dl[nr*size+nc][0]) {
						tip_visited[nr][nc]=true;
						v[nr][nc]=true;
						dfs(nr,nc,time+1,tip+dl[nr*size+nc][1],tip_visited,v);
						tip_visited[nr][nc]=false;
					}
				}else {
					visited[nr][nc]=true;
					dfs(nr,nc,time+1,tip,tip_visited,visited);
					visited[nr][nc]=false;
				}
			}
		}
	}
		
		

}
