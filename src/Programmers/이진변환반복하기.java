package Programmers;

public class 이진변환반복하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] solution(String s) {
        int changeCount = 0;
        int removeZero = 0;
        
        while(true){
            if(s.equals("1")){
                break;
            }    
            String tempS = "";
            for(int i=0, sLength=s.length(); i<sLength; i++){
                if(s.charAt(i)=='1'){
                    tempS += "1";
                }else {
                    removeZero++;
                }
            }
            int tempSLength = tempS.length();
            
            s = Integer.toBinaryString(tempSLength);
            changeCount++;
        }
        int[] answer = {changeCount, removeZero};
        return answer;
    }
}
