package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427_불_Main {

	private static int[] dx;
	private static int[] dy;
	private static Queue<int[]> sg;
	private static int w;
	private static int h;
	private static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine()," ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			sg = new LinkedList<int[]>();
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if(map[i][j]=='@') {
						sg.add(new int[] {i,j});
					}
				}
			}
			dx = new int[] {0,0,1,-1};
			dy = new int[] {1,-1,0,0};
			int time = 0;
			check = false;
			while(true) {
				time++;
				map = fire(map);
//				System.out.println(time+"번째 map");
//				printMap(map);
				move(map);
//				System.out.println("상근이");
//				for (int[] i : sg) {
//		            System.out.println(Arrays.toString(i));
//		        }
				
				if(check) {
					System.out.println(time+1);
					break;
				}
				if(sg.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					break;
				}
			}
			
			
		}
	}

	private static void printMap(char[][] map) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}

	private static void move(char[][] map) {
		boolean[][] visited = new boolean[h][w];
loop:	for (int i = 0; i < sg.size(); i++) {
			int[] cur = sg.poll();
			int r = cur[0];
			int c = cur[1];
			visited[r][c] = true;
			for (int d = 0; d < 4; d++) {
				int nr = dx[d] + r;
				int nc = dy[d] + c;
				if(nr>-1&&nc>-1&&nr<h&&nc<w&&map[nr][nc]=='.'&&!visited[nr][nc]) {
					visited[nr][nc] = true;
					if(nr==0||nc==0||nr==h-1||nc==w-1) {
						check = true;
						break loop;
					}
					sg.offer(new int[] {nr, nc});
				}
			}
		}
		
	}

	private static char[][] fire(char[][] map) {
		char[][] clone = new char[h][w];
		for (int i = 0; i < h; i++) {
			clone[i] = map[i].clone();
		}
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(map[i][j]=='*') {
					q.offer(new int[] {i, j});
				}
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = cur[0] + dx[d];
				int nj = cur[1] + dy[d];
				if(ni>-1&&nj>-1&&ni<h&&nj<w&&map[ni][nj]!='#'&&!visited[ni][nj]) {
					visited[ni][nj] = true;
					clone[ni][nj] = '*';
				}
			}
		}
		
		return clone;
	}

}
