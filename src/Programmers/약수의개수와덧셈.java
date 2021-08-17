package Programmers;

public class 약수의개수와덧셈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            int count = 0;
            int num = 1;
            while(true){
                if(i%num==0) count++;
                num++;
                if(num>i) break;
            }
            
            if(count%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
        }
        return answer;
    }
}
