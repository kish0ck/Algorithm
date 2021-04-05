package Programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

	public static void main(String[] args) {
//		int[] priorities = {2,1,3,2};
//		int location = 2;
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		System.out.println(solution(priorities, location));
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < priorities.length; i++) {
        	q.offer(new int[] {i, priorities[i]});
		}
        
loop:	while(true) {
        	int[] cur = q.poll();
        	int nowNum = cur[0];
        	int nowVal = cur[1];
        	
        	boolean flag = true;
        	for (int[] i : q) {
				if(i[1]>nowVal) {
					q.offer(new int[] {nowNum, nowVal});
					flag = false;
					break;
				}
			}
        	
        	if(flag) {
        		answer++;
        		if(location==nowNum) {
        			break loop;
        		}
        	}
        }
        
        return answer;
    }

}
