package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {

	private static int[][] BHPL;
	private static int ans;
	private static int D;
	private static int W;
	private static int K;
	private static int[] arr_combi_pick;
	private static int[] arr_combi_01;
	private static boolean flag;
	private static int[][] clone_arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			BHPL = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					BHPL[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(K<=1||check(BHPL)) {
				System.out.println("#"+tc+" "+ans);
			}else {
				flag = false;
				while(true) {
					ans++;
					arr_combi_pick = new int[ans];
					arr_combi_01 = new int[ans];
					combination_pick(0,0);
					if(flag) break;
				}
				System.out.println("#"+tc+" "+ans);
			}
			
			
		}
		
				
	}

	private static void combination_pick(int cnt, int idx) {
		if(cnt==ans) {
			clone_arr = new int[D][W];
			for (int i = 0; i < D; i++) {
				clone_arr[i] = BHPL[i].clone();
			}
			combination_01(0);
			return;
		}
		
		if(flag) return;

		if(idx<D) {
			combination_pick(cnt, idx+1);
			arr_combi_pick[cnt]=idx;
			combination_pick(cnt+1, idx+1);
		}
	}

	private static void combination_01(int cnt) {
		if(cnt==ans) {
			for (int i = 0; i < ans; i++) {
				int r = arr_combi_pick[i];
				int val = arr_combi_01[i];
				for (int j = 0; j < W; j++) {
					clone_arr[r][j] = val;
				}
			}
			if(check(clone_arr)) {
				flag=true;
			}
			return;
		}
		
		if(flag) return;
 		
		arr_combi_01[cnt]=0;
		combination_01(cnt+1);
		arr_combi_01[cnt]=1;
		combination_01(cnt+1);
	}

	private static boolean check(int[][] board) {
		boolean check_flag = true;
		for (int i = 0; i < W; i++) {
			int count = 1;
			int num = board[0][i];
			for (int j = 1; j < D; j++) {
				if(board[j][i]!=num) {
					count=1;
					if(D-j<K) break;
					num=board[j][i];
				}else {
					count++;
					if(count==K) break;
				}
			}
			if(count<K) {
				check_flag=false;
				break;
			}
		}
		return check_flag;
	}
}
