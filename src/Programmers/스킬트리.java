package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> list = new ArrayList<Character>();
        
        // 1. 리스트 : skill 의 알파벳을 하나씩 다 담아놓는다.
        for (int i = 0; i < skill.length(); i++) {
			list.add(skill.charAt(i));
		}
        
        String[] strArr = new String[skill_trees.length]; 
        
        for (int i = 0; i < skill_trees.length; i++) {
        	// 2. 스킬트리에서 skill에 존재하는 알파벳으로만 changedStr을 만든다.
        	String nowStr = skill_trees[i];
        	String changedStr = "";
        	for (int j = 0; j < nowStr.length(); j++) {
				if(list.contains(nowStr.charAt(j))) changedStr += nowStr.charAt(j);
			}
        	// 3. changedStr을 인덱스에 맞게 strArr에 넣어준다.
        	strArr[i] = changedStr; 
		}
        
        // 4. strArr[i]가 skill 문자에 포함되어있으면 첫번째부터 스킬이 찍혔나 확인해준다.
        for (int i = 0; i < strArr.length; i++) {
        	if(skill.contains(strArr[i])) {
        		int len = strArr[i].length();
        		boolean flag = true;
        		for (int j = 0; j < len; j++) {
					if(strArr[i].charAt(j)!=skill.charAt(j)) {
						flag = false;
						break;
					}
				}
        		if(flag) answer++;
			} 
		}
        return answer;
    }

}
