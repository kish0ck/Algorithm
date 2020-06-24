package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2020-06-24
public class BOJ_18428_감시피하기_Main {

	private static int N;
	private static int[] dx= {0,0,1,-1}, dy= {1,-1,0,0};//우좌하상
	private static char[][] map;
	private static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		flag = false;
		go(0);
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	private static void go(int cnt) {
		if(cnt==3) {
			boolean flag2 = true;
loop:		for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='T') {
						int ni=i,nj=j;
						ni=i+dx[0];
						nj=j+dy[0];
						while(true) {
							if(ni>-1&&nj>-1&&ni<N&&nj<N) {
								if(map[ni][nj]=='S') {
									flag2=false;
									break loop;
								}else if(map[ni][nj]=='O') {
									break;
								}else {
									ni=ni+dx[0];
									nj=nj+dy[0];
								}
							}else {
								break;
							}
						}
						ni=i+dx[1];
						nj=j+dy[1];
						while(true) {
							if(ni>-1&&nj>-1&&ni<N&&nj<N) {
								if(map[ni][nj]=='S') {
									flag2=false;
									break loop;
								}else if(map[ni][nj]=='O') {
									break;
								}else {
									ni=ni+dx[1];
									nj=nj+dy[1];
								}
							}else {
								break;
							}
													
						}
						ni=i+dx[2];
						nj=j+dy[2];
						while(true) {
							if(ni>-1&&nj>-1&&ni<N&&nj<N) {
								if(map[ni][nj]=='S') {
									flag2=false;
									break loop;
								}else if(map[ni][nj]=='O') {
									break;
								}else {
									ni=ni+dx[2];
									nj=nj+dy[2];
								}
							}else {
								break;
							}
							
						}
						ni=i+dx[3];
						nj=j+dy[3];
						while(true) {
							if(ni>-1&&nj>-1&&ni<N&&nj<N) {
								if(map[ni][nj]=='S') {
									flag2=false;
									break loop;
								}else if(map[ni][nj]=='O') {
									break;
								}else {
									ni=ni+dx[3];
									nj=nj+dy[3];
								}
							}else {
								break;
							}
						}
					}
				}
			}
			if(flag2) flag = true;
			return;
		}
		
		if(flag) return;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='X') {
					map[i][j]='O';
					go(cnt+1);
					map[i][j]='X';
				}
			}
		}
		
	}

}
