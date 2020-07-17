package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238_스타트택시_Main {

	private static int taxi_r;
	private static int taxi_c;
	private static int fuel;
	private static int N;
	private static int M;
	private static int[] dr= {0,0,1,-1}, dc= {1,-1,0,0};
	private static int[][] map;
	private static int gr;
	private static int gc;
	private static boolean[] guest_visited;
	private static int now_guest_num;
	private static int[][] guest;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) map[i][j]=4001;
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		taxi_r = Integer.parseInt(st.nextToken())-1;
		taxi_c = Integer.parseInt(st.nextToken())-1;
		guest = new int[M+1][4]; 
		for (int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			guest[i][0] = Integer.parseInt(st.nextToken())-1;
			guest[i][1] = Integer.parseInt(st.nextToken())-1;
			guest[i][2] = Integer.parseInt(st.nextToken())-1;
			guest[i][3] = Integer.parseInt(st.nextToken())-1;
		}
		boolean flag=false;
		gr = -1;
		gc = -1;
		now_guest_num = -1;
		guest_visited = new boolean[M+1];
		int cnt=0;
		while(true) {
//			System.out.println();
//			System.out.println("연료 : "+fuel);
//			System.out.println("택시위치 :"+taxi_r+", "+taxi_c);
			if(find_guest(taxi_r,taxi_c,fuel)) {
//				System.out.println("현재손님 : "+ now_guest_num);
//				System.out.println("손님태우고 남은 연료 : "+fuel);
				flag=true;
				if(go_mokJJ(gr,gc,guest[now_guest_num][2],guest[now_guest_num][3])) {
					cnt++;
					if(cnt==M) break;
					taxi_r=guest[now_guest_num][2];
					taxi_c=guest[now_guest_num][3];
				}else {
					flag=false;
					break;
				}
			}else{
				flag=false;
				break;
			}
		}
		
		
		if(!flag) {
			System.out.println("-1");
		}else System.out.println(fuel);
		
		
	}


	private static boolean go_mokJJ(int r, int c, int rr, int cc) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<int[]>();
		visited[r][c] = true;
		q.offer(new int[] {r,c});
		boolean flag=false;
		int plus=0;
loop:	while(!q.isEmpty()) {
			flag = false;
			plus++;
			fuel--;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if(nr==rr&&nc==cc) {
						flag=true;
						break loop;
					}
					if(nr>-1&&nc>-1&&nr<N&&nc<N&&!visited[nr][nc]&&map[nr][nc]!=4001) {
						visited[nr][nc]=true;
						q.offer(new int[] {nr,nc});
					}
				}
				
			}
			if(fuel==0) break;
		}
		if(flag) {
			fuel+=(plus*2);
			return true;
		}else return false;
	}


	private static boolean find_guest(int r, int c, int f) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]-o2[0]==0) {
					return o1[1]-o2[1];
				}else {
					return o1[0]-o2[0];
				}
			}
		});
		boolean ff = false;
		for (int i = 1; i < M+1; i++) {
			if(!guest_visited[i]&&r==guest[i][0]&&c==guest[i][1]) {
				ff = true;
				pq.offer(new int[] {r,c});
				now_guest_num = i;
				guest_visited[i]=true;
				gr=r;gc=c;
				break;
			}
		}
		if(ff) {
			return true;
		}else {
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] {r,c});
			boolean[][] visited = new boolean[N][N];
			visited[r][c] = true;
			boolean flag = false;
			while(!q.isEmpty()) {
				if(f==0) break;
				int size = q.size();
				if(flag) break;
				for (int i = 0; i < size; i++) {
					int[] cur = q.poll();
					for (int d = 0; d < 4; d++) {
						int nr = cur[0]+dr[d];
						int nc = cur[1]+dc[d];
						if(nr>-1&&nc>-1&&nr<N&&nc<N&&map[nr][nc]!=4001&&!visited[nr][nc]) {
							visited[nr][nc] = true;
							q.offer(new int[] {nr,nc});
							for (int m = 1; m < M+1; m++) {
								if(!guest_visited[m]&&guest[m][0]==nr&&guest[m][1]==nc) {
									flag=true;
									pq.offer(new int[] {nr,nc});
								}
							}
						}
					}
				}
				f--;
			}
			if(!flag) return false;
			else {
				int[] now = pq.poll();
				gr=now[0];gc=now[1];
				fuel = f;
				for (int i = 1; i < M+1; i++) {
					if(gr==guest[i][0]&&gc==guest[i][1]) {
						now_guest_num = i;
						guest_visited[i]=true;
						break;
					}
				}
				return true;
			} 
		}
		
	}

}
