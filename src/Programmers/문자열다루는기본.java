package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 문자열다루는기본 {

	public static void main(String[] args) {
		String s = "a234";
//		String s = "1234";
		System.out.println(solution(s));
	}
	public static boolean solution(String s) {
        boolean answer = true;
        int sLength = s.length();
        if(sLength==4 || sLength==6){
            for(int i=0; i<sLength; i++){
                if(s.charAt(i)=='1'||s.charAt(i)=='2'||s.charAt(i)=='3'
                  ||s.charAt(i)=='4'||s.charAt(i)=='5'||s.charAt(i)=='6'
                  ||s.charAt(i)=='7'||s.charAt(i)=='8'||s.charAt(i)=='9'
                   ||s.charAt(i)=='0'){
                    
                }else{
                    answer = false;
                    System.out.println(s.charAt(i));
                    break;  
                }
            }    
        }else {
            answer = false;
        }
        return answer;
    }
}
