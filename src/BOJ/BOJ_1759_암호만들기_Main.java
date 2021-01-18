package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기_Main {

	private static int totalCnt;
	private static int L;
	private static int C;
	private static char[] input;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		input = new char[C];
		for (int i = 0; i < C; i++) {
			input[i] =st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		arr = new int[C];
		Arrays.fill(arr, 1);
		for (int i = 0; i < L; i++) {
			arr[i]=0;
		}
		Arrays.sort(arr);
		totalCnt = 0;
		do {
			String str = "";
			int ja = 0, mo =0;
			for (int i = 0; i < C; i++) {
				if(arr[i]==0) {
					str += input[i];
					if(input[i]=='a'||input[i]=='e'||input[i]=='i'||input[i]=='o'||input[i]=='u') {
						mo++;
					}else ja++;
				}
			}
			if(mo>0&&ja>1) {
				System.out.println(str);
			}
		}while(np());
		
	}

	private static boolean np() {
		totalCnt++;
		
		int i = C-1;
		while(i>0&&arr[i-1]>=arr[i]) --i;
		
		if(i==0) return false;
		
		int j = C-1;
		while(arr[i-1]>=arr[j]) --j;
		
		swap(i-1, j);
		
		j = C-1;
		while(i<j) swap(i++, j--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
