package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2210_숫자판점프_Main {

	private static int[] dx;
	private static int[] dy;
	private static List<String> list;
	private static int[][] map;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList<String>();
		dx = new int[] {0,0,1,-1};
		dy = new int[] {1,-1,0,0};
		answer = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				char[] pan = new char[6];
				pan[0] = (char)map[i][j];
				dfs(1, i, j, pan);
			}
		}
		System.out.println(answer);
		
	}

	private static void dfs(int cnt, int x, int y, char[] pan) {
		if(cnt==6) {
			String str = "";
			for (int i = 0; i < 6; i++) {
				str+=pan[i];
			}
			if(!list.contains(str)) {
				list.add(str);
				answer++;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>-1 && ny>-1 && nx<5 && ny<5) {
				pan[cnt] = (char)map[nx][ny];
				dfs(cnt+1, nx, ny, pan);
			}
		}
	}

}
