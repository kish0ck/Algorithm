package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class 두개뽑아서더하기 {

	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		System.out.println(Arrays.toString(solution(numbers)));
	}
	public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
        	int num1 = numbers[i];
        	for (int j = 0; j < numbers.length; j++) {
				if(i!=j) {
					int num2 = numbers[j];
					int num3 = num1 + num2;
					set.add(num3);
				}
			}
		}
        List list = new ArrayList(set);
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = (int)list.get(i);
		}
        
        return answer;
    }
}
