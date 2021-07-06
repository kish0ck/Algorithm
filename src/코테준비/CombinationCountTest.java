package 코테준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombinationCountTest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		System.out.println(combination(N,R));
	}

	private static int combination(int n, int r) {
		if(r==0 || n==r) return 1;
		return combination(n-1,r-1) + combination(n-1,r);
	}

}
