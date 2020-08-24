package Programmers;

import java.util.Arrays;

public class 좌물쇠와열쇠_2020_KAKAO_BLIND_RECRUITMENT {

	private static int[][] k;
	private static int M;
	private static int N;
	public static void main(String[] args) {
		int[][] key= {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
		System.out.println(solution(key, lock));
	}
	private static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		M = key.length;
		N = lock.length;
		int[][] map = new int[3*N][3*N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[N+i][N+j] = lock[i][j];
				if(lock[i][j]==0) {
					map[N+i][N+j]=2;
					count++;
				} 
			}
		}
		
		k = key;
		int turn=0;
loop:	while(true) {
			k = turn(k);
			for (int i = 0; i < 3*N; i++) {
				for (int j = 0; j < 3*N; j++) {
					
					int cnt=0;
forloop:			for (int i2 = 0; i2 < M; i2++) {
						for (int j2 = 0; j2 < M; j2++) {
							if(i2+i<3*N&&j2+j<3*N) {
								if(map[i+i2][j+j2]==1&&k[i2][j2]==1) break forloop;
								if(map[i+i2][j+j2]==2&&k[i2][j2]==1) cnt++;
							}
						}
					}
					
					if(cnt==count) {
						answer=true;
						break loop;
					}
					
				}
			}
			
			turn++;
			if(turn==4) break;
		}
		
		return answer;
	}
	
	private static int[][] turn(int[][] key_clone) {
		int[][] key90 = new int[M][M];
		for (int i = 0; i < M; i++) {
			int[] arr = key_clone[i];
			for (int j = 0; j < M; j++) {
				key90[j][M-1-i] = arr[j];
			}
		}
		return key90;
	}
}
