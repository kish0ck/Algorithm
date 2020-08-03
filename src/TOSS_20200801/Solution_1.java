package TOSS_20200801;

import java.io.*;

public class Solution_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char before = input.charAt(0);
		boolean result = true;
		if(input.charAt(input.length()-1)=='1') {
			result = false;
		}else {
			for (int i = 1; i < input.length(); i++) {
				char now = input.charAt(i);
				if(before=='1') {
					if(now=='1') {
						result = false;
						break;
					}
				}
				before = now;
			}
		}
		System.out.println(result);
	}

}

