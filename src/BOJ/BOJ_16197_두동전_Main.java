package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197_두동전_Main {

	private static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Character[][] map = new Character[N][M];
		boolean flag = false;
		int o1x = 0, o1y =0, o2x=0, o2y=0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='o') {
					if(!flag) {
						flag = true;
						o1x = i; o1y = j;
					}else {
						o2x = i; o2y = j;
					}
					map[i][j] = '.';
				}
			}
		}
		
		q = new LinkedList<int[]>();
		q.offer(new int[] {o1x, o1y, o2x, o2y, 0});
		int[] dx = {0,0,1,-1}, dy= {1,-1,0,0}; //우, 좌, 하, 상
		int ans = 0;
loop:	while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x1 = cur[0], y1 = cur[1], x2 = cur[2], y2 = cur[3];
			int count = cur[4];
			if(count>10) {
				ans = -1;
				break loop;
			} 
			for (int i = 0; i < 4; i++) {
				boolean flag1 = false, flag2 = false;
				int nx1 = x1 + dx[i];
				int ny1 = y1 + dy[i];
				int nx2 = x2 + dx[i];
				int ny2 = y2 + dy[i];
				
				if(nx1>-1 && nx1<N && ny1>-1 && ny1<M) {
					if(map[nx1][ny1]=='#') {
						nx1=x1; ny1=y1; 
					} 
				}else {
					flag1 = true;
				}
				
				if(nx2>-1 && nx2<N && ny2>-1 && ny2<M) {
					if(map[nx2][ny2]=='#') {
						nx2=x2; ny2=y2; 
					} 
				}else {
					flag2 = true;
				}
				
				if((flag1&&!flag2)||(!flag1&&flag2)) {
					ans = count+1;
					break loop;
				}else if(flag1&&flag2) {
					
				}else {
					q.offer(new int[] {nx1,ny1,nx2,ny2,count+1});
				}
			}
		}
		System.out.println(ans);
		
	}

}
