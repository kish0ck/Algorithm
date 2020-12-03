package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 2 ≤ N ≤ 100
		int K = Integer.parseInt(st.nextToken()); // 1 ≤ K ≤ 2N
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[2*N]; // i번째 내구도
		// arr[0]   올라가는 위치
		// arr[N-1] 내려가는 위치
		for (int i = 0; i < 2*N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] belt = new int[2*N];
		
	}

}
