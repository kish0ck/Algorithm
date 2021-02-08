package BOJ;

import java.util.Scanner;

public class BOJ_2231_분해합_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = -1;
		for (int i = N; i > 0; i--) {
			int sum = 0;
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				sum+=(str.charAt(j)-'0');
			}
			if(sum+i==N) {
				result = i;
			} 
		}
		if(result==-1) {
			System.out.println(0);
		}else {
			System.out.println(result);
		}
	}
}
