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
        	int[] cur = q.poll();  // 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
        	int nowNum = cur[0];   // 대기목록 번호
        	int nowVal = cur[1];   // 현재 중요도
        	
        	boolean flag = true;
        	for (int[] i : q) {
				if(i[1]>nowVal) { // 2. 나머지 인쇄 대기목록에서 nowVal보다 중요도가 높은 문서가 한 개라도 존재하면 nowVal를 대기목록의 가장 마지막에 넣습니다.
					q.offer(new int[] {nowNum, nowVal});
					flag = false;
					break;
				}
			}
        	
        	if(flag) { // 3. 그렇지 않으면 J를 인쇄합니다.
        		answer++;
        		if(location==nowNum) {
        			break loop; 
        		}
        	}
        }
        
        return answer;
    }

}
