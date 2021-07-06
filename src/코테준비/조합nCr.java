package 코테준비;

import java.util.Scanner;

public class 조합nCr {

	private static int nCr(int N,int R) {
		if(R==N) return 1;
		if(R==1) return N;
	
		return nCr(N-1,R)+nCr(N-1,R-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		
		System.out.println(nCr(N,R));
	}

}
