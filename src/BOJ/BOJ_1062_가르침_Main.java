package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합사용..
public class BOJ_1062_가르침_Main {

	private static int K;
	private static int N;
	private static int ans;
	private static boolean[] visited;
	private static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str.substring(4,str.length()-4);
		}
		visited = new boolean[26];
		visited['a'-'a']=true;
		visited['n'-'a']=true;
		visited['t'-'a']=true;
		visited['c'-'a']=true;
		visited['i'-'a']=true;
		ans=0;
		if(K<5) {
			System.out.println(ans);
		}else {
			combination(0,5);
			System.out.println(ans);
		}
	}

	private static void combination(int idx, int cnt) {
		if(idx>25&&cnt!=K) return;
		if(cnt==K) {
			int count=0;
			for (int i = 0; i < N; i++) {
				boolean flag = false;
				String str = arr[i];
				for (int j = 0; j < str.length(); j++) {
					if(!visited[str.charAt(j)-'a']) {
						flag = true;
						break;
					}
				}
				if(!flag) count++;
			}
			if(count>ans) ans=count;
			return;
		}
		
		if(idx=='a'-'a'||idx=='n'-'a'||idx=='t'-'a'||idx=='i'-'a'||idx=='c'-'a') {
			combination(idx+1,cnt);
		}else if(idx<26) {
			combination(idx+1,cnt);
			visited[idx]=true;
			combination(idx+1,cnt+1);
			visited[idx]=false;
		}
		
	}

}
