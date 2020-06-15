package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합_Main {

	private static int ans;
	private static boolean[] visited;
	private static int cnt;
	private static int N;
	private static int S;
	private static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 1;
		ans = 0;
		while(true) {
			visited = new boolean[N];
			combination(0,0);
			cnt++;
			if(cnt>N) break;
		}
		System.out.println(ans);
	}

	private static void combination(int idx, int count) {
		if(count==cnt) {
			int sum=0;
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					sum+=numbers[i];
				}
			}
			if(sum==S) ans++;
			return;
		}
		
		if(idx<N) {
			visited[idx]=true;
			combination(idx+1, count+1);
			visited[idx]=false;
			combination(idx+1, count);
		}
	}

}
