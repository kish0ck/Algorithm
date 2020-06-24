package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RE_BOJ_2931_가스관_Main2 {

	private static boolean flag;
	private static char[][] map;
	private static int R;
	private static int C;
	private static int mc;
	private static int mr;
	private static int ar, ac;
	private static char atype;
	private static boolean[] visited;
	private static int[] dx= {0,0,1,-1}, dy= {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		mr = 0;
		mc = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='M') {
					mr=i;mc=j;
				}
			}
		}
		flag = false;
bb:		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='.') {
					visited = new boolean[7];
					go(i,j,0);
					if(flag) break bb;
				}
			}
		}
		System.out.println((ar+1)+" "+(ac+1)+" "+atype);
		
	}

	private static void go(int r, int c, int cnt) {
		if(cnt==1) {
			boolean[][] visited = new boolean[R][C];
			Queue<int[]> q = new LinkedList<int[]>();
			visited[mr][mc]=true;
			
			for (int i = 0; i < 4; i++) {
				int rr = mr+dx[i];
				int cc = mc+dy[i];
				if(rr>-1&&cc>-1&&rr<R&&cc<C&&map[rr][cc]!='.') {
					q.offer(new int[] {rr,cc,map[rr][cc]});
					visited[rr][cc]=true;
				} 
			}
			
			
			
loop:		while(!q.isEmpty()) {
				int[] cur = q.poll();
				int nr = cur[0];
				int nc = cur[1];
				visited[nr][nc] = true;
				if(map[nr][nc]=='|') {
					if(nr+1<R&&!visited[nr+1][nc]) {
						if(map[nr+1][nc]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr+1,nc});
						}
					}
					if(nr-1>-1&&visited[nr-1][nc]) {
						if(map[nr-1][nc]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr-1,nc});
						}
					}
				}else if(map[nr][nc]=='-') {
					if(nc+1<C&&!visited[nr][nc+1]) {
						if(map[nr][nc+1]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr,nc+1});
						}
					}
					if(nc-1>-1&&!visited[nr][nc-1]) {
						if(map[nr][nc-1]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr,nc-1});
						}
					}
				}else if(map[nr][nc]=='+') {
					if(nc+1<C&&!visited[nr][nc+1]) {
						if(map[nr][nc+1]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr,nc+1});
						}
					}
					if(nc-1>-1&&!visited[nr][nc-1]) {
						if(map[nr][nc-1]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr,nc-1});
						}
					}
					if(nr+1<R&&!visited[nr+1][nc]) {
						if(map[nr+1][nc]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr+1,nc});
						}
					}
					if(nr-1>-1&&visited[nr-1][nc]) {
						if(map[nr-1][nc]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr-1,nc});
						}
					}
				}else if(map[nr][nc]=='1') {
					if(nc+1<C&&!visited[nr][nc+1]) {
						if(map[nr][nc+1]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr,nc+1});
						}
					}
					if(nr+1<R&&!visited[nr+1][nc]) {
						if(map[nr+1][nc]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr+1,nc});
						}
					}
				}else if(map[nr][nc]=='2') {
					if(nc+1<C&&!visited[nr][nc+1]) {
						if(map[nr][nc+1]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr,nc+1});
						}
					}
					if(nr-1>-1&&visited[nr-1][nc]) {
						if(map[nr-1][nc]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr-1,nc});
						}
					}
				}else if(map[nr][nc]=='3') {
					if(nc-1>-1&&!visited[nr][nc-1]) {
						if(map[nr][nc-1]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr,nc-1});
						}
					}
					if(nr-1>-1&&visited[nr-1][nc]) {
						if(map[nr-1][nc]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr-1,nc});
						}
					}
				}else {
					if(nc-1>-1&&!visited[nr][nc-1]) {
						if(map[nr][nc-1]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr,nc-1});
						}
					}
					if(nr+1<R&&!visited[nr+1][nc]) {
						if(map[nr+1][nc]=='Z') {
							ar = r;
							ac = c;
//							atype = map[nr][nc];
							flag = true;
							break loop;
						}else {
							q.offer(new int[] {nr+1,nc});
						}
					}
				}
			}
			System.out.println();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]+" ");
				}System.out.println();
			}
			return;
		}
		
		for (int i = 0; i < 7; i++) {
			// | - + 1 2 3 4
			// 0 1 2 3 4 5 6
			if(!visited[i]) {
				switch(i) {
				case 0:
					map[r][c]='|';
					atype = map[r][c];
					go(r,c,cnt+1);
					map[r][c]='.';
					break;
				case 1:
					map[r][c]='-';
					atype = map[r][c];
					go(r,c,cnt+1);
					map[r][c]='.';
					break;
				case 2:
					map[r][c]='+';
					atype = map[r][c];
					go(r,c,cnt+1);
					map[r][c]='.';
					break;
				case 3:
					map[r][c]='1';
					atype = map[r][c];
					go(r,c,cnt+1);
					map[r][c]='.';
					break;
				case 4:
					map[r][c]='2';
					atype = map[r][c];
					go(r,c,cnt+1);
					map[r][c]='.';
					break;
				case 5:
					map[r][c]='3';
					atype = map[r][c];	
					go(r,c,cnt+1);
					map[r][c]='.';
					break;
				case 6:
					map[r][c]='4';
					atype=map[r][c];
					go(r,c,cnt+1);
					map[r][c]='.';
					break;
				}
			}
		}
		
	}

}
