package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 2020-06-15
// 13:30~14:00

public class BOJ_14888_연산자끼워넣기_Main {

	private static int N;
	private static int min;
	private static int max;
	private static int[] op;
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+N-1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N+N-1; i+=2) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		dfs(0);
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void dfs(int cnt) {
		if(cnt==N-1) {
			int sum=arr[0];
			int operator = -1;
			for (int i = 1; i < 2*N-1; i++) {
				if(i%2==0) {
					switch(operator) {
						case 0:
							sum+=arr[i];
							break;
						case 1:
							sum-=arr[i];
							break;
						case 2:
							sum*=arr[i];
							break;
						case 3:
							sum/=arr[i];
							break;
					}
				}else {
					operator=arr[i];
				}
			}
			
			if(sum>max) max=sum;
			if(sum<min) min=sum;
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i]!=0) {
				op[i]--;
				arr[cnt*2+1]=i;
				dfs(cnt+1);
				op[i]++;
			}
		}
	}

}
