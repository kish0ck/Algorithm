package BOJ;

import java.util.Scanner;

public class BOJ_10974_모든순열_Main {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		do {
			for (int i = 0; i < N; i++) {
				if(i==N-1) System.out.println(arr[i]);
				else System.out.print(arr[i]+" ");
			}
		}while(next_permutaion());
	}

	private static boolean next_permutaion() {
		int i = N-1;
		while(i>0&&arr[i-1]>=arr[i]) --i;
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>=arr[j]) --j;
		
		swap(i-1, j);
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
