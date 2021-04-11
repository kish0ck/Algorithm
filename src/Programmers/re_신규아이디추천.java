package Programmers;

public class re_신규아이디추천 {

	public static void main(String[] args) {
//		String new_id = "...!@BaT#*..y.abcdefghijklm";
		String new_id = "z-+.^.";
		System.out.println(solution(new_id));
	}
	public static String solution(String new_id) {
        String answer = "";

        
        boolean flag = true; // 아이디 규칙 확인
        // 1. 아이디 길이는 3자이상 15자이하
        if(new_id.length()<3||new_id.length()>15) flag = false; 
        
        // 2. 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 만 가능
        if(flag) { 
        	for (int i = 0; i < new_id.length(); i++) {
        		char ch = new_id.charAt(i);
        		if((ch>='a'&&ch<='z')||ch=='-'||ch=='_'||ch=='.') {

        		}else {
        			flag = false;
        			break;
        		}
        	}
        }

        // 3. 마침표(.) 처음과 맨끝에는 사용X, 연속으로 사용 X
        if(flag){
        	int len = new_id.length();
        	if(new_id.charAt(0)=='.'||new_id.charAt(len-1)=='.') {
        		flag = false;
        	}
        }
        
        if(flag) {
        	int len = new_id.length();
        	char befCh = new_id.charAt(0); 
        	for (int i = 1; i < len; i++) {
				char curCh = new_id.charAt(i);
				if(befCh==curCh && befCh =='.' && curCh=='.') {
					flag = false;
					break;
				}
				befCh = curCh;
			}
        }
        answer = new_id;
        if(!flag) {
        	// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        	answer = answer.toLowerCase();
        	
        	// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        	String answer2 = "";
        	for (int i = 0; i < answer.length(); i++) {
        		char ch = answer.charAt(i);
        		if((ch>='a'&&ch<='z')||ch=='-'||ch=='_'||ch=='.') {
        			answer2 += ch;
        		}else {
        			
        		}
			}
        	System.out.println("2단계: "+answer2);
        	answer = answer2;
        	
        	// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        	String answer3 = "";
        	answer3+=answer.charAt(0);
        	int len = answer.length();
        	char befCh = answer.charAt(0); 
        	for (int i = 1; i < len; i++) {
				char curCh = answer.charAt(i);
				if(befCh==curCh && befCh =='.' && curCh=='.') {

				}else {
					answer3+=curCh;
				}
				befCh = curCh;
			}
        	answer = answer3;
        	System.out.println("3단계: "+answer3);
        	
        	// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        	String answer4 = "";
        	boolean flag4 = false;
        	if(answer.charAt(0)=='.') {
        		flag4 = true;
        		answer4 = answer.substring(1);
        		System.out.println(answer4);
        	}
        	int lastIdx = answer4.length();
        	if(lastIdx!=0&&answer4.charAt(lastIdx-1)=='.') {
        		flag4 = true;
        		answer4 = answer4.substring(0, lastIdx-1);
        	}
        	if(flag4) answer = answer4;
        	System.out.println("4단계: "+answer4);
        	
        	// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        	String answer5 = "";
        	if(answer == "" || answer.isEmpty()) {
        		answer5 += "a";
        		answer = answer5;
        	}
        	System.out.println("5단계: "+answer);
        	
        	//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
            //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        	if(answer.length()>=16) {
        		String answer6 = "";
        		answer6 = answer.substring(0, 15);
        		if(answer6.charAt(14)=='.') {
        			answer6 = answer6.substring(0, 15);
        		}
        		answer = answer6;
        	}

        	//7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        	if(answer.length()<=2) {
        		int ln = answer.length();
        		char ch = answer.charAt(ln-1);
        		String answer7 = answer;
        		
        		while(true) {
        			if(answer7.length()==3) break;
        			answer7+=ch;
        		}
        		answer = answer7;		
        	}
        }
        
        
        return answer;
    }
}
