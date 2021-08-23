package Programmers;

import java.util.HashMap;
import java.util.Set;

public class 위장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map= new HashMap<String, Integer>();
        for (int i = 0; i < clothes.length; i++) {
			if(map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], map.get(clothes[i][1])+1);
			}else {
				map.put(clothes[i][1], 1);
			}
		}
        
        Set<String> keyset = map.keySet();
        
        for (String k : keyset) {
			answer *= map.get(k)+1;
		}
        return answer-1;
    }
}
