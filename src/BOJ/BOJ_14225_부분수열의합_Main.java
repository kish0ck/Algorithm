package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 2020-06-15
// 20:00 ~ 20:20

public class BOJ_14225_부분수열의합_Main {

	private static int target;
	private static int N;
	private static boolean[] visited;
	private static int[] S;
	private static Set<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		set = new HashSet<Integer>();
		target = 1;
		while(true) {
			visited = new boolean[N];
			combination(0,0);
			target++;
			if(target==N+1) break;
		}
		int ans = 0;
		for (int i = 1; ; i++) {
			if(!set.contains(i)) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

	private static void combination(int idx, int cnt) {
		if(cnt==target) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(visited[i]) sum+=S[i];
			}
			set.add(sum);
			return;
		}
		
		if(idx<N) {
			visited[idx] = true;
			combination(idx+1, cnt+1);
			visited[idx] = false;
			combination(idx+1, cnt);
		}
		
	}

}
