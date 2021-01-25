package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불_Main {

	private static int[] dr;
	private static int[] dc;
	private static int w;
	private static int h;
	private static Queue<int[]> user;
	private static Queue<int[]> fire;
	private static char[][] map;
	private static boolean isBreak;
	private static boolean user_status;
	private static boolean[][] user_visited;
	private static boolean[][] fire_visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dr = new int[] { -1, 1, 0, 0 };
		dc = new int[] { 0, 0, -1, 1 };
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			user = new LinkedList<int[]>();
			fire = new LinkedList<int[]>();
			user_visited = new boolean[h][w];
			fire_visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@') {
						user.add(new int[] { i, j });
						user_visited[i][j] = true;
						map[i][j] = '.';
					} else if (map[i][j] == '*') {
						fire_visited[i][j] = true;
						fire.add(new int[] { i, j });
					}
				}
			}

			// 2. 구현
			// '.': 빈 공간, '#': 벽, '@': 상근이의 시작 위치, '*': 불
			int time = 0;
			isBreak = false; // (T:탈출, F:탈출못함)
			user_status = false; // 상근이 상태(T:움직임, F:못움직임)
			while (true) {
				time++;
				user_status = false;
				move(fire, '*');
				move(user, '@');
				if (!user_status) break;
				if (isBreak) break;
			}
			if(isBreak) {
				System.out.println(time);
			} else if(!user_status) System.out.println("IMPOSSIBLE");

		}
	}

	private static void move(Queue<int[]> q, char wh) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + r;
				int nc = dc[d] + c;
				if (nr > -1 && nc > -1 && nr < h && nc < w) {
					if (wh == '@') { // 상근이일때
						if (!user_visited[nr][nc]&&map[nr][nc] == '.') {
							user_visited[nr][nc] = true;
							user_status = true;
							user.add(new int[] { nr, nc });
						}
					} else { // 불일때
						if (!fire_visited[nr][nc]&&map[nr][nc] != '#') {
							fire_visited[nr][nc] = true;
							map[nr][nc] = '*';
							fire.add(new int[] { nr, nc });
						}
					}
				} else {
					if (wh == '@') {
						isBreak = true;
						break;
					}
				}
			}
		}
	}

}