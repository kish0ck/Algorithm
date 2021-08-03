package Programmers;

import java.util.*;

public class 기능개발 {

	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
//		int[] progresses = {95, 90, 99, 99, 80, 99};
//		int[] speeds = {1, 1, 1, 1, 1, 1};
//		System.out.println(Arrays.toString(solution(progresses, speeds)));
		
	}
	public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int length = progresses.length;
        for(int i=0; i<length; i++) {
            queue.offer((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
        }
       
        List<Integer> list = new ArrayList<Integer>();
        
        int preValue = queue.poll();
        int count = 1;
        int nowValue = 0;
        while(!queue.isEmpty()){
            nowValue = queue.poll();
            if(preValue >= nowValue){
                count++;
            }else {
                preValue = nowValue;
                list.add(count);
                count = 1;
            }
        }
       
        list.add(count);
       
        // System.out.println("리스트 사이즈 : " + list.size());
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
            // System.out.println("리스트get(i)"+list.get(i));
        }
        
        return answer;
    }
}
