package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1463_1로만들기_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		int res = 0;
loop:	while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				if(now==1) break loop;
				
				if(now%3==0) {
					q.offer(now/3);
				}
				if(now%2==0) {
					q.offer(now/2);
				}
				q.offer(now-1);
			}
			res++;
		}
		System.out.println(res);
	}

}
