package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913_숨바꼭질4_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 수빈
		int K = Integer.parseInt(st.nextToken()); // 동생
		
		if(N!=K) {
			int[] visited = new int[100001];
			int[] result = new int[100001];
			Arrays.fill(visited, -1);
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(N);
			int ans = 0;
	loop:	while(!q.isEmpty()) {
					ans++;
					int size = q.size();
					for (int s = 0; s < size; s++) {
						int now = q.poll();
						
						if(now-1>-1&& now-1<100001&&visited[now-1]==-1) {
							visited[now-1] = now;
							q.offer(now-1);
							if(now-1==K) {
								result[ans] = now-1;
								break loop;
							}
						}
						
						if(now+1>-1&& now+1<100001&&visited[now+1]==-1) {
							visited[now+1] = now;
							q.offer(now+1);
							if(now+1==K) {
								result[ans] = now+1;
								break loop;
							}
						}
						
						if(now*2>-1&& now*2<100001&&visited[now*2]==-1) {
							visited[now*2] = now;
							q.offer(now*2);
							if(now*2==K) {
								result[ans] = now*2;
								break loop;
							}
						}
					}
					
				}
			
				System.out.println(ans);
				for (int i = ans-1, now = K; i > -1; i--) {
					result[i] = visited[now];
					now = visited[now];
				}
				for (int i = 0; i <= ans; i++) {
					System.out.print(result[i]+" ");
				}
		}else {
			System.out.println("0");
			System.out.println(N);
		}
		
	}

}
