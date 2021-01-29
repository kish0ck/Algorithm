package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int F = Integer.parseInt(st.nextToken()); // 꼭대기층
		int S = Integer.parseInt(st.nextToken()); // 현재
		int G = Integer.parseInt(st.nextToken()); // 도착
		int U = Integer.parseInt(st.nextToken()); // 위
		int D = Integer.parseInt(st.nextToken()); // 아래
		
		if(S==G) {
			System.out.println("0");
			return;
		} 
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);
		boolean[] visited = new boolean[F+1];
		visited[S] = true;
		int[] d = {U, (0-D)};
		boolean flag = false;
		int count = 0;
bfs:	while(!q.isEmpty()) {
			count++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int cur = q.poll();
				for (int i = 0; i < 2; i++) {
					int next = cur + d[i];
					if(next==G) {
						flag = true;
						break bfs;
					}
					if(next>0&&next<F+1&&!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
		}
		if(!flag) {
			System.out.println("use the stairs");
		} else {
			System.out.println(count);
		}
		
	}

}
