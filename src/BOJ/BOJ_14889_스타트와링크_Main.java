package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2020-06-15
// 14:00~14:26 ==> 시간초과
// ~43 조합으로 다시품


public class BOJ_14889_스타트와링크_Main {

	private static int N, min=Integer.MAX_VALUE;
	private static boolean[] visited;
	private static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		combination(0, 0);
		System.out.println(min);
	}
	
	private static void combination(int idx, int cnt) {
		if(cnt==N/2) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < N; i++) {
				
				if(!visited[i]) {
					for (int j = 0; j < N; j++) {
						if(!visited[j]) sum1+=arr[i][j];
					}
				}
				
				if(visited[i]) {
					for (int j = 0; j < N; j++) {
						if(visited[j]) sum2+=arr[i][j];
					}
				}
			}
			int cha = Math.abs(sum1-sum2);
			if(min>cha) min=cha;
			return;
		}
		if(idx<N) {
			visited[idx]=true;
			combination(idx+1, cnt+1);
			visited[idx]=false;
			combination(idx+1, cnt);
		}
		
	}
}
