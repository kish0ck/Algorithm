package Programmers;

import java.util.Arrays;

public class fail_좌물쇠와열쇠_2020_KAKAO_BLIND_RECRUITMENT {

	private static int[] dc;
	private static int[] dr;
	private static int M;
	private static int[][] key_clone;
	private static boolean answer;
	private static int move_cnt;
	private static int[] combi;
	private static int[][] key_map;
	public static void main(String[] args) {
		int[][] key= {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
		boolean result = solution(key, lock);
		System.out.println(result);
	}

	private static boolean solution(int[][] key, int[][] lock) {
		answer = false;
		M = key.length;
		int N = lock.length;
		
		// 위, 오른쪽, 아래, 왼쪽
		dr = new int[] {-1,0,1,0};
		dc = new int[] {0,1,0,-1};
		

		key_map = new int[M][M];
		for (int i = 0; i < M; i++) {
			key_map[i] = key[i].clone();
		}
		
		move_cnt = 0;
bw:		while(true) {
			if(move_cnt!=0) {
				combi = new int[move_cnt];
				combination(move_cnt-1,0,lock);
				if(answer) break bw;
			}else {
				key_clone = new int[M][M];
				for (int i = 0; i < M; i++) {
					key_clone[i] = key_map[i].clone();
				}
				for (int i = 0; i < 4; i++) {
					key_clone = rotate(key_clone);
					if(check(key_clone, lock)) {
						answer = true;
						break bw;
					}
				}
			}
			move_cnt++;
			if(move_cnt>Math.pow(4, M*M)) break;
		}
		return answer;
	}
	
	private static boolean check(int[][] key_clone2, int[][] lock) {
		boolean flag = false;
loop:	for (int r = 0; r < M; r++) {
			for (int c = 0; c < M; c++) {
				if(key_clone2[r][c]==1) {
					if(lock[r][c]==1) {
						flag = false;
						break loop;
					}else {
						flag=true;
					}
				}
			}
		}
		return flag;
	}

	private static void combination(int rr, int idx, int[][] lock) {
		if(rr==-1) {
			System.out.println(Arrays.toString(combi));
			key_clone = new int[M][M];
			for (int i = 0; i < M; i++) {
				key_clone[i] = key_map[i].clone();
			}
			for (int move = 0; move < move_cnt; move++) {
				key_clone = move_action(combi[move], key_clone);
			}
			for (int i = 0; i < 4; i++) {
				key_clone = rotate(key_clone);
				if(check(key_clone, lock)) {
					answer = true;
					return;
				}
			}
			return;
		}
		if(idx==4) return;
		if(answer) return;

		combi[rr]=idx;
		combination(rr-1,idx,lock);
		combination(rr,idx+1,lock);
	}
	
	private static int[][] rotate(int[][] k) {
		int[][] clone2 = new int[M][M];
		for (int i = 0; i < M; i++) {
			int[] arr = k[i].clone();
			for (int j = 0; j < M; j++) {
				clone2[j][M-1-i] = arr[j];
			}
		}
		return clone2;
	}

	private static int[][] move_action(int d, int[][] key_clone2) {
		int[][] change_key = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if(key_clone2[i][j]==1) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr>-1&&nc>-1&&nr<M&&nc<M) {
						change_key[nr][nc]=1;
					} 
				}
			}
		}
		return change_key;
	}


}
