package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2020-06-15
// 

public class BOJ_6603_로또_Main {

	private static int[] arr;
	private static boolean[] visited;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			arr = new int[N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0);	
			System.out.println();
		}
	}

	private static void combination(int idx, int cnt) {
		if(cnt==6) {
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					System.out.print(arr[i]+" ");
				}
			}System.out.println();
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
