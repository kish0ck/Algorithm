package TOSS_20200801;

import java.io.*;
import java.util.*;

public class Solution_6 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] input_arr = input.toCharArray();
		int N = 1;
		int M = 0;
		for (int i = 0; i < input_arr.length; i++) {
			char ch = input_arr[i];
			if(ch==';') {
				N++;
				M=0;
			}else if(ch==' ') {
				
			}else if(ch=='0'||ch=='1') {
				M++;
			}
		}
		int result = 0;
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		int[][] map = new int[N][M];
		int r=0, c=0;
		for (int i = 0; i < input_arr.length; i++) {
			char ch = input_arr[i];
			if(ch==';') {
				r++;
				c=0;
			}else if(ch==' ') {
				
			}else if(ch=='0'||ch=='1') {
				map[r][c] = ch-'0';
				c++;
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr>-1&&nc>-1&&nr<N&&nc<M&&map[nr][nc]==0) {
							result++;
						}
					}
				}
				
			}
		}
		System.out.println(result);
	}

}
