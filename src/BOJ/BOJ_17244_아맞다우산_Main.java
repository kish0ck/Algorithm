package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17244_아맞다우산_Main {

	private static int N;
	private static int M;
	private static char[][] map;
	private static int[] dr;
	private static int[] dc;
	private static int[] Xarr;
	private static int Xcnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		map = new char[M][N];
		Xcnt = 0;
		int er=0, ec=0, sr=0, sc=0;
		List<int[]> Xlist = new LinkedList<int[]>();
		dr = new int[] {0,0,1,-1};
		dc = new int[] {1,-1,0,0};
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='X') {
					Xcnt++;
					Xlist.add(new int[] {i,j});
				}else if(map[i][j]=='S') {
					sr=i;
					sc=j;
				}else if(map[i][j]=='E') {
					er=i;
					ec=j;
				}
			}
		}
		
		if(Xcnt==0) {
			int res = bfs(sr,sc,er,ec);
			System.out.println(res);
		}else {
			Xarr = new int[Xcnt];
			for (int i = 0; i < Xcnt; i++) {
				Xarr[i] = i;
			}
			
			int ans = Integer.MAX_VALUE;
			do {
				int sum = 0 ;
				
				int[] S = Xlist.get(Xarr[0]);
				int val1 = bfs(S[0],S[1],sr,sc);
				sum+=val1;
				
				for (int i = 0; i < Xcnt-1; i++) {
					int[] startX = Xlist.get(Xarr[i]);
					int[] endX = Xlist.get(Xarr[i+1]); 
					int val = bfs(startX[0],startX[1],endX[0],endX[1]);
					sum+=val;
				}
				
				int[] E = Xlist.get(Xarr[Xcnt-1]);
				int val2 = bfs(E[0],E[1],er,ec);
				sum+=val2;
				if(ans>sum) ans=sum;
				
			}while(next_permutation());

			System.out.println(ans);
		}
		
		
	}

	private static boolean next_permutation() {
		int i = Xcnt - 1;
		while(i>0&&Xarr[i-1]>=Xarr[i]) --i;
		
		if(i==0) return false;
		
		int j = Xcnt - 1;
		while(Xarr[i-1]>=Xarr[j]) --j;
		
		int temp = Xarr[i-1];
		Xarr[i-1] = Xarr[j];
		Xarr[j] = temp;
		
		j = Xcnt -1;
		while(i<j) {
			temp = Xarr[i];
			Xarr[i] = Xarr[j];
			Xarr[j] = temp;
			i++;j--;
		}
		
		return true;
	}

	private static int bfs(int r1, int c1, int r2, int c2) {
		boolean[][] visited = new boolean[M][N];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r1,c1});
		visited[r1][c1]=true;
		int cnt=0;
loop:	while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if(nr==r2&&nc==c2) break loop;
					if(nr>-1&&nc>-1&&nr<M&&nc<N&&!visited[nr][nc]&&map[nr][nc]!='#') {
						visited[nr][nc] = true;
						q.offer(new int[] {nr,nc});
					}
				}
			}
		}
 		return cnt;
	}

}
