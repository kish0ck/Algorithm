package Programmers;
import java.util.*;

public class 영어끝말잇기_스킬체크test레벨2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	        int answer1 = 1, answer2 = -1; //정답 [번호(answer1), 차례(answer2)]
	        int wordsLength = words.length; // 끝말잇기에 사용한 단어들 개수 
	        List<String> isUsed = new ArrayList<String>();
	        
	        String beforeWord = words[0];
	        isUsed.add(beforeWord);
	        
	        for(int i=1; i<wordsLength; i++){
	            answer1++;
	            if(answer1>n) answer1=1;
	            String nowWord = words[i];
	            if(isUsed.contains(nowWord)) { // 사용된 단어일 경우
	                if((i+1)%n!=0){
	                    answer2 = (i+1)/n + 1;
	                }else{
	                    answer2 = (i+1)/n;
	                }
	                break;
	            }else{ // 사용되지 않은 단어일 경우
	                isUsed.add(nowWord);
	                // 이전단어 마지막 알파벳, 현재단어 첫번째 알파벳 비교
	                char beforeLastAlphabet = beforeWord.charAt(beforeWord.length()-1);
	                char nowFirstAlphabet = nowWord.charAt(0);
	                if(beforeLastAlphabet!=nowFirstAlphabet) {
	                    if((i+1)%n!=0){
	                        answer2 = (i+1)/n + 1;
	                    }else{
	                        answer2 = (i+1)/n;
	                    }
	                    break;
	                }else {
	                    beforeWord = nowWord;
	                }
	                    
	            }
	        }
	        
	        answer[0] = answer1;
	        answer[1] = answer2;
	        
	        if(answer2 == -1){
	            answer[0] = 0;
	            answer[1] = 0;
	        }
	        
	        return answer;
	    }
	}
}
