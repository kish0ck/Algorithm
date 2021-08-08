package Programmers;

import java.util.Arrays;

public class 비밀지도 {

	public static void main(String[] args) {
		int n=5;
		int[] arr1= {9, 20, 28, 18, 11};
		int[] arr2= {30, 1, 21, 17, 28};
		String[] result = solution(n, arr1, arr2);
		System.out.println(Arrays.toString(result));
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        
        for(int i=0; i<n; i++) {
        	String str1 = Integer.toBinaryString(arr1[i]);
        	String str2 = Integer.toBinaryString(arr2[i]);
        	
        	int idx = n-1;
        	for(int j=str1.length()-1; j>-1;j--) {
        		map1[i][idx] = str1.charAt(j)-'0';
        		idx--;
        	}
        	idx = n-1;
        	for(int j=str2.length()-1; j>-1;j--) {
        		map2[i][idx] = str2.charAt(j)-'0';
        		idx--;
        	}
        }
        
        for(int i=0; i<n; i++) {
        	String result = "";
        	for(int j=0; j<n;j++) {
        		if(map1[i][j]==1 || map2[i][j]==1) {
        			result += "#";
        		}else result +=" ";
        	}
        	answer[i] = result;
        }
        
        return answer;
    }

}
