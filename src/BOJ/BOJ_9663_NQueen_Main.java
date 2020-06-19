package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen_Main {

	private static int N, ans;
	private static boolean[] check_col;
	private static boolean[] check_diagonal1;//↗↙
	private static boolean[] check_diagonal2;//↖↘

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check_col = new boolean[N];
		check_diagonal1 = new boolean[N*2];
		check_diagonal2 = new boolean[N*2];
		ans=0;
		backtracking(0);
		System.out.println(ans);
	}

	private static void backtracking(int row) {
		if(row==N) {
			ans++;
			return;
		}
		
		for (int col = 0; col < N; col++) {
			if(check(row,col)) {
				check_col[col] = true;
				check_diagonal1[row+col] = true;
				check_diagonal2[row-col+N] = true;
				backtracking(row+1);
				check_diagonal1[row+col] = false;
				check_diagonal2[row-col+N] = false;
				check_col[col] = false;
			}
		}
		
	}

	private static boolean check(int row, int col) {
		
		if(check_col[col]) return false;
		
		if(check_diagonal1[row+col]) return false;
		
		if(check_diagonal2[row-col+N]) return false;
		
		return true;
	}

}
