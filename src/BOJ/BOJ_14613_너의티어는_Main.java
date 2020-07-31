package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14613_너의티어는_Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		double W = Double.parseDouble(st.nextToken()); 
		double L = Double.parseDouble(st.nextToken());
		double D = Double.parseDouble(st.nextToken());
		
		double[][] dp = new double[21][3001];
		dp[0][2000] = 1;
		
		for (int i = 1; i < 21; i++) {
			for (int j = 1000; j < 3001; j++) {
				
				if(dp[i-1][j]==0) continue;
				
				// 이겼을때
				dp[i][j+50] += dp[i-1][j]*W;
				// 졌을때
				dp[i][j-50] += dp[i-1][j]*L;
				// 비겼을때
				dp[i][j] += dp[i-1][j]*D;
			}
			
		}
		
		double b, s, g, p, d;
		b = s = g = p = d = 0.0;
		for (int i = 1000; i < 3001; i++) {
			if(i<1500) {
				b+=dp[20][i];
			}else if(i<2000) {
				s+=dp[20][i];
			}else if(i<2500) {
				g+=dp[20][i];
			}else if(i<3000) {
				p+=dp[20][i];
			}else d+=dp[20][i];
		}
		
		System.out.printf("%.8f\n", b);
		System.out.printf("%.8f\n", s);
		System.out.printf("%.8f\n", g);
		System.out.printf("%.8f\n", p);
		System.out.printf("%.8f\n", d);
	}



}
