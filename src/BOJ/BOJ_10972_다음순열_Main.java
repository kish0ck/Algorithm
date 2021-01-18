package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972_다음순열_Main {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(next_permutation()) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i]+" ");
			}
		}else {
			System.out.println(-1);
		}
	}

	private static boolean next_permutation() {
		int i = N-1;
		while(i>0&&arr[i-1]>=arr[i]) --i;
		
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>=arr[j]) --j;
		
		swap(i-1,j);
		
		j = N-1;
		while(i<j) swap(i++,j--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
