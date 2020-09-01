package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15566_개구리1_Main {

	private static int N;
	private static int M;
	private static List<Integer> frog_lotus[];
	private static int[] lotus;
	private static int[][] log;
	private static boolean result;
	private static int[][] frog;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException  {
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		frog = new int[N][4]; // 개구리의 흥미도
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 4; j++) {
				frog[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		frog_lotus = new ArrayList[N]; // 개구리의 선호 연꽃
		for (int i = 0; i < N; i++) {
			frog_lotus[i] = new ArrayList<Integer>();
		}
		
		// 1-1. 선호하는 연꽃이 같을경우 한번 넣어줌
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			if(A==B) {
				frog_lotus[i].add(A);
			}else {
				frog_lotus[i].add(A);
				frog_lotus[i].add(B);
			}
		}
		
		log = new int[M][3]; // 통나무 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				log[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		
		lotus = new int[N];
		Arrays.fill(lotus, -1);
		result = false;  // 답확인을 위한 boolean 변수
		sb = new StringBuilder();
		
		// 2. 순열
		permutation(0);
		
		// 3. 답 출력
		if(result) {
			System.out.println(sb.toString());
		}else System.out.println("NO");
		
		
	}

	private static void permutation(int cnt) {
		if(cnt==N) {
			boolean flag = true;
			for (int i = 0; i < M; i++) {
				int ycc1 = log[i][0];
				int ycc2 = log[i][1];
				int title = log[i][2];
				
				int frog1 = lotus[ycc1];
				int frog2 = lotus[ycc2];
				
				if(frog[frog1][title]!=frog[frog2][title]) {
					flag = false;
					break;
				}
				
			}
			
			if(flag) {
				result = true;
				sb.append("YES\n");
				for (int i = 0; i < N; i++) {
					sb.append((lotus[i]+1)+" ");
				}
			} 
			return;
		}
		
		if(result) return;
		for (int i = 0; i < frog_lotus[cnt].size(); i++) {
			int ycc = frog_lotus[cnt].get(i);
			if(lotus[ycc]==-1) {
				lotus[ycc] = cnt;
				permutation(cnt+1);
				if(result) return;
				lotus[ycc] = -1;
			}
		}
		
	}

	

}
