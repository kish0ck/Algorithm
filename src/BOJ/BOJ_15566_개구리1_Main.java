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
	private static boolean flag;
	private static int[] lotus;
	private static boolean[] visited;
	private static List<Integer> frog_lotus[];
	private static int[][] log_info;
	private static int[][] frog_interest;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //0 ≤ M ≤ min(N(N-1)/2, 100)
		
		frog_interest = new int[N][4];
		frog_lotus = new ArrayList[N]; // 개구리가 선호하는 연꽃
		log_info = new int[M][3];
		
		for (int i = 0; i < N; i++) {
			frog_lotus[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 4; j++) {
				frog_interest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 2; j++) {
				int a = Integer.parseInt(st.nextToken())-1;
				if(!frog_lotus[i].contains(a)) frog_lotus[i].add(a);
			}
		}	
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				log_info[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		flag = false;
		lotus = new int[N];
		visited = new boolean[N];
		Arrays.fill(lotus, -1);
		
		List<Integer> frog_num = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if(frog_lotus[i].size()==1) frog_num.add(i);
		}
		if(frog_num.size()==0) {
			for (int i = 0; i < N; i++) {
				frog_num.add(i);
			}
		}
		
loop:	for (int i = 0; i < frog_num.size(); i++) {
			int frog = frog_num.get(i);
			for (int j = 0; j < frog_lotus[frog].size(); j++) {
				visited[frog]=true;
				lotus[frog_lotus[frog].get(j)]=frog;
				dfs(0);
				if(flag) break loop;
				visited[frog]=false;
				lotus[frog_lotus[frog].get(j)]=-1;
			}
		}
		
	
		
		if(flag) {
			System.out.println("YES");
			for (int i = 0; i < N; i++) {
				System.out.print((lotus[i]+1)+" ");
			}
		} else System.out.println("NO");
		
		
		
		
	}

	private static void dfs(int cnt) {
		if(cnt==N-1) {
			boolean flag2 = true;
			for (int i = 0; i < M; i++) {
				int ycc1 = log_info[i][0];
				int ycc2 = log_info[i][1];
				int interst = log_info[i][2];
				
				int frog1 = lotus[ycc1];
				int frog2 = lotus[ycc2];
				if(frog_interest[frog1][interst]!=frog_interest[frog2][interst]) {
					flag2 = false;
					break;
				}
			}
			if(flag2) flag=true;
			return;
		}

		
		if(flag) return;
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				int frog_num = i;
				for (int j = 0; j < frog_lotus[frog_num].size(); j++) {
					int ycc = frog_lotus[frog_num].get(j);
					if(lotus[ycc]==-1) {
						lotus[ycc] = frog_num;
						visited[frog_num]= true;
						dfs(cnt+1);
						if(flag) return;
						visited[frog_num]= false;
						lotus[ycc] = -1;
					}
				}
			}
		}
		
	}



}
