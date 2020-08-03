package TOSS_20200801;

import java.io.*;
import java.util.*;

public class Solution_5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		List<Integer> kim = new ArrayList<Integer>();
		List<Integer> lee = new ArrayList<Integer>();
		while(st.hasMoreTokens()) {
			int cost = Integer.parseInt(st.nextToken());
			kim.add(cost);
		}
		st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) {
			int cost = Integer.parseInt(st.nextToken());
			lee.add(cost);
		}
		int[] result = new int[kim.size()];
		int now_kim = 0;
		int now_lee = 0;
		for (int i = 0; i < result.length; i++) {
			now_kim+=kim.get(i);
			now_lee+=lee.get(i);
			if(now_kim>now_lee) {
				result[i] = now_kim-now_lee;
				now_lee=0;
				now_kim=0;
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

}
