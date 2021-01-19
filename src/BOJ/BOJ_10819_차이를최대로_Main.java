package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로_Main {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(input);
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new int[N];
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		do {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum+=Math.abs(arr[i]-arr[i+1]);
			}
			if(sum>result) result=sum;
		}while(np());
		System.out.println(result);
	}

	private static boolean np() {
		int i = N-1;
		while(i>0&&arr[i-1]>=arr[i]) i--;
		
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>=arr[j]) j--;
		
		swap(i-1, j);
		j=N-1;
		
		while(i<j) swap(i++, j--);
		return true;
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
