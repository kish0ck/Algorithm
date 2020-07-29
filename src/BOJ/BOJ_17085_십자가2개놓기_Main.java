package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17085_십자가2개놓기_Main {

	private static int ans;
	private static int[] res;
	private static int N;
	private static int M;
	private static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
		}
		
		int val = (N > M) ? N/2 : M/2;
		res = new int[2];
		Arrays.fill(res, -1);
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j]=='#') dfs(i,j,0,val);
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int cnt, int val) {
		if(cnt==1) {
			for (int v = val; v > -1; v--) {
				if(check(r,c,v)) {
					res[cnt] = v;
					int sum = (res[0]*4+1) * (res[1]*4+1);
					if(sum>ans) {
						ans=sum;
					}
					return;
				}
			}
		}
		
		for (int v = val; v > -1; v--) {
			if(check(r,c,v)) {
				res[cnt] = v;
				change(r,c,v);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(board[i][j]=='#') dfs(i,j,cnt+1,val);
					}
				}
				change(r,c,v);
			}
		}
		
	}

	private static void change(int r, int c, int v) {
		char ch = (board[r][c]=='.')? '#' : '.' ;
		for (int i = v; i > 0; i--) {
			board[r+i][c]=ch;
			board[r-i][c]=ch;
			board[r][c+i]=ch;
			board[r][c-i]=ch;
		}
		board[r][c]=ch;
	}

	private static boolean check(int r, int c, int v) {
		boolean flag = true;
		for (int i = v; i > 0; i--) {
			if(r+i>=N||r-i<0||c+i>=M||c-i<0
					||board[r+i][c]=='.'||board[r-i][c]=='.'||board[r][c+i]=='.'||board[r][c-i]=='.') {
				flag=false;
				break;
			}
		}
		return flag;
	}

}
