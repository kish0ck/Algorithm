package Programmers;

import java.util.StringTokenizer;

public class 최댓값과최소값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public String solution(String s) {
	        String answer = "";
	        StringTokenizer st = new StringTokenizer(s, " ");
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        while(st.hasMoreTokens()){
	            int value = Integer.parseInt(st.nextToken());
	            // System.out.println(value);
	            if(value>max) max=value;
	            if(value<min) min=value;
	        }
	        answer = min+" "+max;
	        return answer;
	    }
}
