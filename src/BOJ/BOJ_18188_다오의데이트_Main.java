package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2020-07-02
public class BOJ_18188_다오의데이트_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		int N = Integer.parseInt(br.readLine());
		char[][] marid = new char[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			marid[i][0] = st.nextToken().charAt(0);
			marid[i][1] = st.nextToken().charAt(0);
		}
		boolean flag = false;
		String answer2 = "";
loop:	for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]=='D') {
					Queue<int[]> q = new LinkedList<int[]>();
					Queue<String> q2 = new LinkedList<String>();
					q.offer(new int[] {i,j,0});
					q2.offer(answer2);
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						int r = cur[0];
						int c = cur[1];
						int turn = cur[2];
						String str = q2.poll();
						if(turn==N) {
							answer2 = str;
							break loop;
						} 
						for (int t = 0; t < 2; t++) {
							String str2 = str;
							switch(marid[turn][t]) {
							case 'W'://위
								if(r-1>-1&&map[r-1][c]!='@') {
									if(map[r-1][c]=='Z') {
										str2+="W";
										flag = true;
										answer2=str2;
										break loop;
									}else {
										str2+="W";
										q.offer(new int[] {r-1,c,turn+1});
										q2.offer(str2);
									}
								}
								break;
							case 'D'://오른쪽
								if(c+1<W&&map[r][c+1]!='@') {
									if(map[r][c+1]=='Z') {
										str2+="D";
										flag = true;
										answer2=str2;
										break loop;
									}else {
										str2+="D";
										q2.offer(str2);
										q.offer(new int[] {r,c+1,turn+1});
									}
								}
								break;
							case 'A' ://왼쪽
								if(c-1>-1&&map[r][c-1]!='@') {
									if(map[r][c-1]=='Z') {
										str2+="A";
										flag = true;
										answer2=str2;
										break loop;
									}else {
										str2+="A";
										q2.offer(str2);
										q.offer(new int[] {r,c-1,turn+1});
									}
								}
								break;
							case 'S' ://아랫쪽
								if(r+1<H&&map[r+1][c]!='@') {
									if(map[r+1][c]=='Z') {
										str2+="S";
										flag = true;
										answer2=str2;
										break loop;
									}else {
										str2+="S";
										q2.offer(str2);
										q.offer(new int[] {r+1,c,turn+1});
									}
								}
								break;
							}
						}
					}
					break loop;
				}
			}
		}
		String answer = "";
		if(flag) {
			answer = "YES";
		}else {
			answer = "NO";
		}
		System.out.println(answer);
		if(flag) {
			System.out.println(answer2);
		}
	}

}
