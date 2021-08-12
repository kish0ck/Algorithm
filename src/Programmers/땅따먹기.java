package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 땅따먹기 {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
		System.out.println(solution(land));
	}
	static int solution(int[][] land) {
        int landLength = land.length;
        for (int i = 0; i < landLength-1; i++) {
        	PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[0]-o1[0];
				}
			});
        	for (int j = 0; j < 4; j++) {
				pq.offer(new int[] {land[i][j], j});
			}
        	int[] pq1 = pq.poll(); 
        	int[] pq2 = pq.poll(); 
        	int max1Value = pq1[0]; // 최대값
        	int max1Idx = pq1[1];   // 최대값 인덱스 
        	int max2Value = pq2[0]; // 최대값 전 최대값
        	
        	for (int j = 0; j < 4; j++) {
				if(j==max1Idx) {
					land[i+1][j] = land[i+1][j] + max2Value;
				}else {
					land[i+1][j] = land[i+1][j] + max1Value;
				}
			}
        	
		}
        int answer = -1;
        for(int i=0;i<4;i++) {
        	if(land[landLength-1][i]>answer) answer = land[landLength-1][i];
        }
        
        
        return answer;
    }
}
