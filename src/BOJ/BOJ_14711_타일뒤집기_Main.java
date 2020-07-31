package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14711_타일뒤집기_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] tile = new char[N][N];
		char[][] clone = new char[N][N];
		String input = br.readLine();
		tile[0] = input.toCharArray();
		for (int i = 0; i < N; i++) {
			Arrays.fill(clone[i], '.');
		}
		for (int i = 1; i < N; i++) {
			Arrays.fill(tile[i], '.');
		}
		for (int i = 0; i < N; i++) {
			clone[0][i] = tile[0][i];
		}
		
		int[] dr = {0,0,-1,1};
		int[] dc = {-1,1,0,0};
		
//		for (int i = 0; i < N; i++) {
//			if(clone[0][i]=='#') clone[0][i]='.';
//			else clone[0][i]='#';
//		}
		
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N; j++) {
				if(tile[i][j]=='#') {
					for (int d = 0; d < 4; d++) {
						int ni = i + dr[d];
						int nj = j + dc[d];
						if(ni>-1&&nj>-1&&ni<N&&nj<N) {
							if(clone[ni][nj]=='.') {
								clone[ni][nj]='#';
							}else {
								clone[ni][nj]='.';
							}
						}
					}
				}
			}
			for (int j = 0; j < N; j++) {
				tile[i+1][j] = clone[i+1][j];
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(tile[i]));
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(clone[i]));
		}
	}

}
