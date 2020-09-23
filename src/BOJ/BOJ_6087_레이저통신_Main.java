package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_6087_레이저통신_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		
		int answer = 0, start_r = 0, start_c = 0, end_r=0, end_c=0;
		boolean flag = false;
		
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if(map[i][j]=='C') {
					if(!flag) {
						start_r = i;
						start_c = j;
						flag = true;
					}else {
						end_r = i;
						end_c = j;
						break;
					}
				}
			}
		}
		
		int[][] visited = new int[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		int[] dr = {0, 0, 1, -1};
		int[] dc = {1, -1, 0, 0};
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		pq.offer(new int[] {start_r, start_c, 0, 4}); // r, c, 거울개수, 방향
		
		visited[start_r][start_c] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[0]==end_r&&cur[1]==end_c) {
				answer = cur[2];
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + cur[0];
				int nc = dc[d] + cur[1];
				
				if(nr>-1&&nc>-1&&nr<H&&nc<W && map[nr][nc]!='*') {
					if(cur[3]==4 || cur[3]==d) {
						if(visited[nr][nc] >= cur[2]) {
							visited[nr][nc] = cur[2];
							pq.offer(new int[] {nr, nc, cur[2], d});
						}
					}else {
						if(visited[nr][nc] >= cur[2]+1) {
							visited[nr][nc] = cur[2]+1;
							pq.offer(new int[] {nr, nc, cur[2]+1, d});
						}
					}
				}
			}
		}
		
		
		System.out.println(answer);
		
		
	}

}
