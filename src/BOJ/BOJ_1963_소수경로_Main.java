package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963_소수경로_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		List<String> list = new ArrayList<String>();
		for (int i = 1000; i < 10000; i++) {
			boolean flag = false;
			for (int j = 2; j < i; j++) {
				if(i%j==0) {
					flag=true;
					break;
				}
			}
			if(!flag) list.add(String.valueOf(i));
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String start = st.nextToken();
			String end = st.nextToken();
			Queue<String> q = new LinkedList<String>();
			q.offer(start);
			List<String> visited = new ArrayList<String>();
			int turn=0;
			boolean flag = false;
loop:		while(!q.isEmpty()) {
				flag = false;
				int size = q.size();
				for (int s = 0; s < size; s++) {
					String cur = q.poll();
					if(cur.equals(end)) {
						flag = true;
						break loop;
					} 
					char[] arr = cur.toCharArray();
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j <= 9; j++) {
							if(arr[i]-'0'!=j) {
								char[] copy = arr.clone();
								copy[i] = (char)(j+'0');
								String str = "";
								for (int k = 0; k < 4; k++) {
									str+=copy[k];
								}
								if(list.contains(str)&&!visited.contains(str)) {
									q.offer(str);
									visited.add(str);
								}
							}
						}
					}
				}
				turn++;
			}
			if(flag) {
				System.out.println(turn);
			}else {
				System.out.println("Impossible");
			}
		}
		
	}

}
