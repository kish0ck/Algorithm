package Programmers;

public class 키패드누르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] matrix = new int[9][12];
        matrix[0][1] = 4; matrix[0][4] = 3; matrix[0][7] = 2;
        matrix[0][3] = 4; matrix[0][6] = 3; matrix[0][9] = 2;
        matrix[0][10] = 1; matrix[0][11] = 1; 
        matrix[0][2] = 3; matrix[0][5] = 2; matrix[0][8] = 1; 
        
        matrix[8][1] = 3; matrix[8][4] = 2; matrix[8][7] = 1;
        matrix[8][3] = 3; matrix[8][6] = 2; matrix[8][9] = 1;
        matrix[8][10] = 2; matrix[8][11] = 2; 
        matrix[8][2] = 2; matrix[8][5] = 1; matrix[8][0] = 1; 
        
        matrix[5][1] = 2; matrix[5][4] = 1; matrix[5][7] = 2;
        matrix[5][3] = 2; matrix[5][6] = 1; matrix[5][9] = 2;
        matrix[5][10] = 3; matrix[5][11] = 3; 
        matrix[5][2] = 1; matrix[5][8] = 1; matrix[5][0] = 2;
        
        matrix[2][1] = 1; matrix[2][4] = 2; matrix[2][7] = 3;
        matrix[2][3] = 1; matrix[2][6] = 2; matrix[2][9] = 3;
        matrix[2][10] = 4; matrix[2][11] = 4; 
        matrix[2][5] = 1; matrix[2][8] = 2; matrix[2][0] = 3;

        int length = numbers.length;
        String nowLeft = "10", nowRight = "11";
        for(int i=0; i<length; i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                answer += "L";
                nowLeft = numbers[i]+"";
            }else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                answer += "R";
                nowRight = numbers[i]+"";
            }else{
                if(matrix[numbers[i]][Integer.parseInt(nowLeft)]>matrix[numbers[i]][Integer.parseInt(nowRight)]){ //오른쪽이 가깝
                    answer += "R";
                    nowRight = numbers[i]+"";          
                }else if(matrix[numbers[i]][Integer.parseInt(nowLeft)]<matrix[numbers[i]][Integer.parseInt(nowRight)]){//왼쪽이 가깝
                    answer += "L";
                    nowLeft = numbers[i]+"";
                }else{ 
                    if(hand.equals("right")){
                        answer += "R";
                        nowRight = numbers[i]+"";    
                    }else{
                        answer += "L";
                        nowLeft = numbers[i]+"";    
                    }
                }
                    
            }
        }
        return answer;
    }

}
