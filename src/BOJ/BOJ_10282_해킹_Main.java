package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_10282_해킹_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
			int d = Integer.parseInt(st.nextToken()); // 의존성 개수
			int c = Integer.parseInt(st.nextToken())-1; // 해킹당한 컴퓨터의 번호 (1 ≤ n ≤ 10,000, 1 ≤ d ≤ 100,000, 1 ≤ c ≤ n)
			List<int[]> list[] = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				list[i] = new ArrayList<int[]>();
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int s = Integer.parseInt(st.nextToken());
				list[b].add(new int[] {a,s});
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
			});
			
			int[] path = new int[n];
			Arrays.fill(path, Integer.MAX_VALUE);
			path[c] = 0;
			pq.offer(new int[] {c, 0});
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				int now_num = cur[0];
				int now_val = cur[1];
				for (int i = 0; i < list[now_num].size(); i++) {
					int[] next = list[now_num].get(i);
					int next_num = next[0];
					int next_val = next[1];
					if(path[next_num]>now_val+next_val) {
						path[next_num]=now_val+next_val;
						pq.offer(new int[] {next_num, path[next_num]});
					}
				}
			}
			
			int ans1 = 0; // 총 감염되는 컴퓨터 수
			int ans2 = 0; // 마지막 컴터가 감염되기 까지 걸리는 시간
			for (int i = 0; i < n; i++) {
				if(path[i]!=Integer.MAX_VALUE) ans1++;
				if(path[i]!=Integer.MAX_VALUE&&ans2<path[i]) ans2=path[i];
			}
			
			System.out.println(ans1+ " "+ans2);
		}
	}
	
}