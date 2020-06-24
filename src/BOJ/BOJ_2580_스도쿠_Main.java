package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2020-06-24

public class BOJ_2580_스도쿠_Main {

	private static boolean[][] col_check;
	private static boolean[][] row_check;
	private static boolean[][] square_check;
	private static int[][] board;
	private static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[9][9];
		col_check = new boolean[9][10];
		row_check = new boolean[9][10];
		square_check = new boolean[9][10];

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				col_check[i][board[i][j]] = true;
				squre(i, j, board[i][j]);
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != 0) {
					row_check[i][board[j][i]] = true;
				}
			}
		}
		
		flag = false;
		go(0, 0, 0);

	}

	private static void go(int i, int j, int cnt) {
		if (i == 9 && j == 0) {
			flag = true;
			for (int k = 0; k < 9; k++) {
				for (int k2 = 0; k2 < 9; k2++) {
					System.out.print(board[k][k2] + " ");
				}
				System.out.println();
			}
			
		}

		int nextj = 0;
		int nexti = 0;
		if (j == 8) {
			nexti = i + 1;
			nextj = 0;
		} else {
			nexti = i;
			nextj = j + 1;
		}

		if(flag) return;
		
		if (board[i][j] != 0) {
			go(nexti, nextj, cnt + 1);
		} else {
			for (int k = 1; k < 10; k++) {
				if (!col_check[i][k] && !row_check[j][k] && !square_check[square_number(i, j)][k]) {
					col_check[i][k] = true;
					row_check[j][k] = true;
					square_check[square_number(i, j)][k] = true;
					board[i][j] = k;
					go(nexti, nextj, cnt + 1);
					board[i][j] = 0;
					col_check[i][k] = false;
					row_check[j][k] = false;
					square_check[square_number(i, j)][k] = false;
				}
			}
		}
	}

	private static int square_number(int i, int j) {
		if (i < 3 && j < 3) { // 1번네모
			return 0;
		} else if (i < 3 && 2 < j && j < 6) { // 2번네모
			return 1;
		} else if (i < 3 && 5 < j && j < 9) { // 3번네모
			return 2;
		} else if (2 < i && i < 6 && j < 3) { // 4번네모
			return 3;
		} else if (2 < i && i < 6 && 2 < j && j < 6) { // 5번네모
			return 4;
		} else if (2 < i && i < 6 && 5 < j && j < 9) { // 6번네모
			return 5;
		} else if (5 < i && i < 9 && j < 3) { // 7번네모
			return 6;
		} else if (5 < i && i < 9 && 2 < j && j < 6) { // 8번네모
			return 7;
		} else {
			return 8;
		}

	}

	private static void squre(int i, int j, int k) {
		if (i < 3 && j < 3) { // 1번네모
			square_check[0][k] = true;
		} else if (i < 3 && 2 < j && j < 6) { // 2번네모
			square_check[1][k] = true;
		} else if (i < 3 && 5 < j && j < 9) { // 3번네모
			square_check[2][k] = true;
		} else if (2 < i && i < 6 && j < 3) { // 4번네모
			square_check[3][k] = true;
		} else if (2 < i && i < 6 && 2 < j && j < 6) { // 5번네모
			square_check[4][k] = true;
		} else if (2 < i && i < 6 && 5 < j && j < 9) { // 6번네모
			square_check[5][k] = true;
		} else if (5 < i && i < 9 && j < 3) { // 7번네모
			square_check[6][k] = true;
		} else if (5 < i && i < 9 && 2 < j && j < 6) { // 8번네모
			square_check[7][k] = true;
		} else {
			square_check[8][k] = true;
		}
	}

}