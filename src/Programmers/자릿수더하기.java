package Programmers;

public class 자릿수더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        int strLength = str.length();
        for(int i=0; i<strLength; i++){
            answer += Integer.parseInt(str.charAt(i)+"");
        }
        return answer;
    }

}
