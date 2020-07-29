package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_8980_택배_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int box = Integer.parseInt(st.nextToken());
			pq.add(new int[] {from,to,box});
		}
		
		
		int ans = 0;
		int[] village = new int[N+1];
		for (int i = 0; i < M; i++) {
			int[] cur = pq.poll();
			int from = cur[0];
			int to = cur[1];
			int box_val = cur[2];
			int max = 0;
			boolean flag = false;
			for (int j = from; j < to; j++) {
				if(village[j]<C) {
					if(max<village[j]) max=village[j];
				}else {
					flag=true;
					break;
				} 
			}
			if(!flag) {
				int val = 0;
				if(max+box_val<=C) {
					val = box_val;
				}else {
					val = C-max;
				}
				for (int j = from; j < to; j++) {
					village[j]+=val;
				}
				ans+=val;
			}
		}
		System.out.println(ans);

	}

}
