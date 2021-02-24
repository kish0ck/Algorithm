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
        int[][] map = new int[n][n];
        for(int i=0; i<arr1.length; i++){
            String str2 = Integer.toBinaryString(arr1[i]);
            int cnt = n-1;
            for(int j=str2.length()-1; j>-1; j--){
              map[i][cnt] = str2.charAt(j)-'0'; 
              cnt--;
            }
            for(int j=cnt; j>-1 ;j--){
                map[i][j]=0;
            }
        }
        for(int i=0; i<arr2.length; i++){
            String str2 = Integer.toBinaryString(arr2[i]);
            int cnt = n-1;
            for(int j=str2.length()-1; j>-1; j--){
              if(map[i][cnt]==1) {
            	  cnt--;
            	  continue;
              } 
              if(str2.charAt(j)-'0'==1) map[i][cnt]=1;
              cnt--;
            }
        }
        
        for (int i = 0; i < n; i++) {
			answer[i]="";
        	for (int j = 0; j < n; j++) {
				if(map[i][j]==1) {
					answer[i]+="#";
				}else {
					answer[i]+=" ";
				}
			}
		}
        return answer;
    }

}
