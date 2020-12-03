package Programmers;

import java.util.Arrays;
import java.util.Stack;

public class Solution_1_20201025 {
	static class code{
		int index;
		char ch;
		
		public code(int index, char ch) {
			super();
			this.index = index;
			this.ch = ch;
		}

	}
	public static void main(String[] args) {
//		String s = "{cpp{java}}{python}";
//		int[] idx = {0,4,9,10,11,18};
		String s = "ab{}cd{efg{}h}{ij}";
		int[] idx = {3,6,11,3,14,11};
		int[] result = solution(s, idx);
		System.out.println(Arrays.toString(result));
	}

	private static int[] solution(String s, int[] idx) {
		int[] answer = {};
		Stack<code> stack = new Stack<code>();
		int[] check = new int[s.length()];
		int idx_idx=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='{') {
				if(i==idx[idx_idx]) {
					idx_idx++;
					stack.add(new code(i, s.charAt(i)));
				}else {
					stack.add(new code(i, s.charAt(i)));
				}
			}
			if(s.charAt(i)=='}') {
				if(i==idx[idx_idx]) {
					idx_idx++;
					check[i] = stack.peek().index;
					check[stack.peek().index] = i;
//					System.out.println(i+"  :  "+stack.peek().toString());
					stack.pop();
				}else {
					check[i] = stack.peek().index;
					check[stack.peek().index] = i;
//					System.out.println(i+" :  "+stack.peek().toString());
					stack.pop();
				}
			}
		}
		
		answer = new int[idx.length];
		for (int i = 0; i < idx.length; i++) {
			answer[i] = check[idx[i]];
		}
//		System.out.println(Arrays.toString(check));
		return answer;
	}

}
