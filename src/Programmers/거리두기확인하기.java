package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
	public static boolean flag;

	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		solution(places);
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];
		Arrays.fill(answer, 1);
		for (int i = 0; i < 5; i++) {
			char[][] map = new char[5][5];
			for (int j = 0; j < 5; j++) {
				map[j] = places[i][j].toCharArray();
			}

			loop: for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (map[r][c] == 'P') {
						flag = true;
						bfs(map, r, c);
						if (!flag) {
							answer[i] = 0;
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	public static void bfs(char[][] map, int r, int c) {
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		boolean[][] visited = new boolean[5][5];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int dis = Math.abs(r - nr) + Math.abs(c - nc);
				if (nr > -1 && nc > -1 && nr < 5 && nc < 5 && !visited[nr][nc]) {
					if (map[nr][nc] == 'P') {
						if (dis <= 2) {
							flag = false;
							return;
						}
					} else {
						if (dis <= 2) {
							if (map[nr][nc] == 'O') {
								visited[nr][nc] = true;
								q.offer(new int[] { nr, nc });
							}
						}
					}
				}
			}
		}
	}

}
