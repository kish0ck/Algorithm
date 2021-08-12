package Programmers;

import java.util.Arrays;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(prices)));
	}
	public static int[] solution(int[] prices) {
        int pricesLength = prices.length;
		int[] answer = new int[pricesLength];
		
		for (int i = 0; i < pricesLength; i++) {
			int nowValue = prices[i];
			int cnt = 0;
			for (int j = i+1; j < pricesLength; j++) {
				if(nowValue>prices[j]) {
					cnt++;
					break;
				}else {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
        
        
        
        return answer;
    }

}
