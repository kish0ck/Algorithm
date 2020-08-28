package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_19563_개구리1_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
        a = Math.abs(a);
        b = Math.abs(b);
        
        if(a+b<=c) {
          if((a+b)%2==0 && c%2 == 0) System.out.println("YES");
          else if((a+b)%2!=0 && c%2 != 0) System.out.println("YES");
          else System.out.println("NO");
        } else System.out.println("NO");
	}

}
