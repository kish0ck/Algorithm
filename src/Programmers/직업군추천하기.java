package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 직업군추천하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        
        Map<String, Integer> languagesPreference = new HashMap<String, Integer>();
        int languagesLength = languages.length;
        for(int i=0; i<languagesLength; i++){
            languagesPreference.put(languages[i], preference[i]);
        }
        int tableLength = table.length;
        List<String> result = new ArrayList<String>();
        int highScore = Integer.MIN_VALUE;
        for(int i=0; i<tableLength; i++){
            StringTokenizer st = new StringTokenizer(table[i]," ");
            int sum = 0;
            String returnStr = st.nextToken();
            int point = 5;
            while(st.hasMoreTokens()){
                String language = st.nextToken();
                if(languagesPreference.containsKey(language)){
                    sum += (languagesPreference.get(language)*point);
                } 
                point--;
            }
            
            if(highScore<sum){
                highScore = sum;
                answer = returnStr;
                result.clear();
                result.add(returnStr);
            }else if(highScore==sum){
                result.add(returnStr);    
            }
            
        }
        
        // for(int i=0; i<list.size(); i++){
        //     System.out.println(list.get(i));
        // }
        
        if(result.size()>1){
            Collections.sort(result);
            answer = result.get(0);
        }
        
        return answer;
    }
}
