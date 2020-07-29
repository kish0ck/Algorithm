package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16917_양념반후라이드반_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int ans = X*A+B*Y;
		for (int i=1; i<=100000; i++) {
            int price = 2*i*C + Math.max(0, X-i)*A + Math.max(0, Y-i)*B;
            if (ans > price) ans = price;
        }
		System.out.println(ans);
		
	}

}
