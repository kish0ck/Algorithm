package Programmers;

public class 수박수박수박수박수박수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String solution(int n) {
        String answer = "";
        for(int i=0; i<n/2; i++){
            answer += "수박";
        }
        if(n%2==1){
            answer += "수";
        }
        return answer;
    }
}
