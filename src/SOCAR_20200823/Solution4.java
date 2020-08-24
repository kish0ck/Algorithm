package SOCAR_20200823;

public class Solution4 {
	static class DelInfo {
		public int limit, tip;

		public DelInfo(int limit, int tip) {
			this.limit = limit;
			this.tip = tip;
		}
	}

	static DelInfo[][] del;
	static int n, res;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		int[][] delivery = {
//            {1,5},{8,3},{4,2},{2,3},{3,1},{3,2},{4,2},{5,2},{4,1}

				{ 1, 10 }, { 8, 1 }, { 8, 1 }, { 3, 100 }, { 8, 1 }, { 8, 1 }, { 8, 1 }, { 8, 1 }, { 8, 1 }, { 8, 1 },
				{ 8, 1 }, { 8, 1 }, { 9, 100 }, { 8, 1 }, { 8, 1 }, { 8, 1 } };
//      int r = 3;
		int r = 4;
		int answer = 0;

		n = r;
		del = new DelInfo[n][n];
		for (int i = 0, size = delivery.length; i < size; i++) {
			int x = i / n;
			int y = i % n;
			del[x][y] = new DelInfo(delivery[i][0], delivery[i][1]);
		}

		res = 0;
		boolean[][] flag = new boolean[n][n];
		boolean[][] visit = new boolean[n][n];
		flag[0][0] = true;
		visit[0][0] = true;
		dfs(0, 0, 0, del[0][0].tip, flag, visit);
		answer = res;

		System.out.println(answer);
	}

	static void dfs(int r, int c, int time, int tip, boolean[][] flag, boolean[][] visit) {
		if (tip > res)
			res = tip;

		for (int i = 0; i < 4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];
			if (dx < 0 || dy < 0 || dx >= n || dy >= n)
				continue;
			if (visit[dx][dy])
				continue;
			if (flag[dx][dy] || del[dx][dy].limit < time) { // 이전에 방문해서 팁을 받았던 곳을 다시 방문할 경우
				visit[dx][dy] = true;
				dfs(dx, dy, time + 1, tip, flag, visit);
				visit[dx][dy] = false;
			} else { // 이전에 방문한 적이 없어서 팁을 받아야 하는 경우
				boolean[][] vi = new boolean[n][n];
				vi[dx][dy] = true;
				flag[dx][dy] = true;
				dfs(dx, dy, time + 1, tip + del[dx][dy].tip, flag, vi);
				flag[dx][dy] = false;
			}
		}
	}
}