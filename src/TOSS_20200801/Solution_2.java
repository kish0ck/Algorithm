package TOSS_20200801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		boolean result = true;
		Set<Integer> set = new HashSet<Integer>();
		int before = 0;
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(before>num) {
				result = false;
				break;
			}
			before = num;
			set.add(num);
			if(num<1||num>45) {
				result = false;
				break;
			}
		}
		if(result&&set.size()!=6) result=false;
		System.out.println(result);
	}

}
