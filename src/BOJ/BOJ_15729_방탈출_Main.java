package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15729_방탈출_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] note = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			note[i] = Integer.parseInt(st.nextToken());
		}
		int[] start = new int[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if(start[i]!=note[i]) {
				for (int j = i; j < i+3; j++) {
					if(j>=N) break;
					int val = start[j]==1? 0 : 1 ;
					start[j] = val;
				}
				ans++;
			}
		}
		System.out.println(ans);
	}
}
