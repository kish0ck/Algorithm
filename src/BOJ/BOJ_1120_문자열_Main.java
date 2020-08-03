package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120_문자열_Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String A = st.nextToken();
		String B = st.nextToken();
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= B.length() - A.length(); i++) {
			int count = 0;
			for (int j = 0; j < A.length(); j++) {
				if(A.charAt(j) != B.charAt(i+j)) count++;
			}
			if(ans>count) ans=count;
		}
		System.out.println(ans);
	
	}


}
