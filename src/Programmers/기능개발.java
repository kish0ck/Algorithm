package Programmers;

import java.util.Arrays;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
//		int[] progresses = {95, 90, 99, 99, 80, 99};
//		int[] speeds = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
		
	}
	public static int[] solution(int[] progresses, int[] speeds) {
//        int[] answer = {};
        int len = progresses.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
        	if((100-progresses[i])%speeds[i]==0) {
        		arr[i] = (100-progresses[i])/speeds[i];
        	}else {
        		arr[i] = (100-progresses[i])/speeds[i];
        		arr[i]++;
        	}
		}
        
        int[] result = new int[len];
        Arrays.fill(result, -1);
        int before = arr[0];
        int val = 1;
        int idx = 0;
        for (int i = 1; i < len; i++) {
			int now = arr[i];
			if(before>now) {
				val++;
			}else {
				for (int j = 0; j < len; j++) {
					if(result[j]==-1) {
						idx++;
						result[j] = val;
						val=1;
						break;
					}
				}
				before=now;
			}
		}
        
        int[] answer = new int[idx+1];
        int a = 0;
        for (int i = 0; i < idx; i++) {
			answer[i] = result[i];
			a += answer[i];
		}
        answer[idx] = len - a;
//        int idx = -1;
//        for (int i = 0; i < len; i++) {
//        	if(result[i]==-1) {
//        		idx = i;
//        	}
//        }
        
        
        return answer;
    }
}
