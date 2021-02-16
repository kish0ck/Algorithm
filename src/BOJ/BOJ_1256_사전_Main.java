package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1256_사전_Main {

	private static int len;
	private static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());  // "a"의 개수// 1 <= N, M <= 100       
		int M = Integer.parseInt(st.nextToken());  // "z"의 개수
		int K = Integer.parseInt(st.nextToken());  // 1 <= K < 1,000,000,000  
		
		len = N+M;
		arr = new char[len];
		for (int i = 0; i < len; i++) {
			if(i<N) {
				arr[i] = 'a';
			}else {
				arr[i] = 'z';
			}
		}
		int cnt = 0;
		boolean flag = false;
		do {
			cnt++;
			if(cnt==K) {
				flag = true;
				for (int i = 0; i < len; i++) {
					System.out.print(arr[i]);
				}
			}
		}while(np());
		if(!flag) System.out.println(-1);
	}

	private static boolean np() {
		int i = len -1;
		while(i>0 && arr[i-1]>=arr[i]) --i;
		
		if(i==0) return false;
		
		int j = len -1;
		while(arr[i-1]>=arr[j]) --j;
		
		swap(i-1,j);
		
		j = len-1;
		while(i<j) swap(i++,j--);
		
		return true;
	}

	private static void swap(int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
