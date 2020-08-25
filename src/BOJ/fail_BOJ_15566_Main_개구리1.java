package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class fail_BOJ_15566_Main_개구리1 {

	private static int[] lotus;
	private static int N;
	private static int M;
	private static List<Integer> frog_love[];
	private static int[][] frog_interest;
	private static int[][] frog_lotus;
	private static int[][] log_info;
	private static boolean flag;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //0 ≤ M ≤ min(N(N-1)/2, 100)
		
		frog_interest = new int[N][4];
		frog_lotus = new int[N][2];
		log_info = new int[M][3];
		frog_love = new ArrayList[N];
		
		for (int i = 0; i < frog_love.length; i++) {
			frog_love[i] = new ArrayList<Integer>();
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
				frog_lotus[i][j] = a;
				if(!frog_love[i].contains(a)) frog_love[i].add(a);
			}
		}	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				log_info[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		flag = false;
		lotus = new int[N]; //연꽃
		visited = new boolean[N]; 
		Arrays.fill(lotus, -1);
		
		
		
loop:	for (int i = 0; i < N; i++) {
			for (int j = 0; j < frog_love[i].size(); j++) {
				visited[i]=true;
				lotus[frog_love[i].get(j)] = i;
				dfs(0);
				if(flag) break loop;
				visited[i]=false;
				lotus[frog_love[i].get(j)] = -1;
			}
		}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
		
		
		
		
	}

	private static void dfs(int cnt) {
		if(cnt==N) {
			boolean flag2 = true;
			System.out.println(Arrays.toString(lotus));
			for (int i = 0; i < M; i++) {
				int ycc1 = log_info[i][0];//연꽃1
				int ycc2 = log_info[i][1];//연꽃2
				int jj = log_info[i][2]; //주제
				
				int frog1 = lotus[ycc1];
				int frog2 = lotus[ycc2];
				
				int inter1 = frog_interest[frog1][jj];
				int inter2 = frog_interest[frog2][jj];
				
				if(inter1!=inter2) {
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
				for (int j = 0; j < frog_love[i].size(); j++) {
					if(lotus[frog_love[i].get(j)]==-1) {
						lotus[frog_love[i].get(j)]=i;
						visited[i]=true;
						dfs(cnt+1);
						if(flag) break;
						visited[i]=false;
						lotus[frog_love[i].get(j)]=-1;
					}
				}
			}
		}
	}

}
