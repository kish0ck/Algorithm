package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int answer = -1;
		int n = maps.length, m = maps[0].length;
		int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[n][m];
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		boolean flag = false; // 상대 팀 진영을 파괴 유무 확인용
		int count = 0;
		loop: while (!q.isEmpty()) {
			count++;
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				int[] cur = q.poll();
				if (cur[0] == n - 1 && cur[1] == m - 1) {
					System.out.println("count :: " + count );
					flag = true;
					break loop;
				}
				for (int d = 0; d < 4; d++) {
					int nr = dr[d] + cur[0];
					int nc = dc[d] + cur[1];
					if (nr > -1 && nc > -1 && nr < n && nc < m && !visited[nr][nc] && maps[nr][nc] == 1) {
//						if (nr == n - 1 && nc == m - 1) {
//							count++;
//							flag = true;
//							break loop;
//						}
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}
				} // for_d END
			} // for_i END
		} // while_END

		if (flag)
			answer = count;

		return answer;
	}

}
