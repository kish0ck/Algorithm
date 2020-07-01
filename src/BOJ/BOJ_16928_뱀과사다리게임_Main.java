package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //사다리수
		int M = Integer.parseInt(st.nextToken()); //뱀의수
		int[][] ladder = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ladder[i][0] = Integer.parseInt(st.nextToken());
			ladder[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] snake = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			snake[i][0] = Integer.parseInt(st.nextToken());
			snake[i][1] = Integer.parseInt(st.nextToken());
		}
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {1,0});
		int ans = 0;
		boolean[] visited = new boolean[101];
		visited[1] = true;
loop:	while(!q.isEmpty()) {
			int[] cur = q.poll();
			int now_idx = cur[0];
			int cnt = cur[1];
			for (int i = 1; i < 7; i++) {
				int next_idx = now_idx+i;
				if(next_idx<101&&!visited[next_idx]) {
					visited[next_idx] = true;
					if(next_idx==100) {
						ans = cnt+1;
						break loop;
					}else if(next_idx<100){
						boolean flag = false;
						
						for (int j = 0; j < N; j++) {
							if(next_idx==ladder[j][0]) {
								flag = true;
								q.offer(new int[] {ladder[j][1],cnt+1});
							}
						}
						
						for (int j = 0; j < M; j++) {
							if(next_idx==snake[j][0]) {
								flag = true;
								q.offer(new int[] {snake[j][1],cnt+1});
							}
						}
						if(!flag) {
							q.offer(new int[] {next_idx, cnt+1});
						}
					}
				}
			}
		}	
		System.out.println(ans);
	}

}
