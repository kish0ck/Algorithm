package TOSS_20200801;

import java.io.*;
import java.util.*;

public class Solution_3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] num = new int[10];
		boolean[] visited = new boolean[10];
		
		while(st.hasMoreTokens()) {
			int number = Integer.parseInt(st.nextToken());
			if(!visited[number]) {
				visited[number] = true;
				num[number] = Function.compute(number);
			}
			System.out.print(num[number]+" ");
		}
	}
}
