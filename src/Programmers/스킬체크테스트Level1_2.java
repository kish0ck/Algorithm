package Programmers;

public class 스킬체크테스트Level1_2 {

	public static void main(String[] args) {
		int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		String hand = "right";
		solution(numbers, hand);
		
	}
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        
        int Lr=3, Lc=0;
        int Rr=3, Rc=2;
        
        for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]==1
			 ||numbers[i]==4
			 ||numbers[i]==7) {
				answer+="L";
				if(numbers[i]==1) { // 0,0
					Lr = 0; Lc = 0;
				}else if(numbers[i]==4) { // 1,0
					Lr = 1; Lc= 0;
				}else { //2,0
					Lr = 2; Lr = 0;
				}
			}else if(numbers[i]==3
		    	   ||numbers[i]==6
				   ||numbers[i]==9) {
				answer+="R";
				if(numbers[i]==3) { // 0,2
					Rr = 0; Rc=2;
				}else if(numbers[i]==6) { // 1,2
					Rr = 1; Rc=2;
				}else { // 2,2
					Rr = 2; Rc= 2;
				}
			}else {
				int L=0, R=0;
				if(numbers[i]==2) { // (0,1)
					L = Math.abs(0-Lr)+Math.abs(1-Lc);
					R = Math.abs(0-Rr)+Math.abs(1-Rc);
				}else if(numbers[i]==5) { //(1,1)
					L = Math.abs(1-Lr)+Math.abs(1-Lc);
					R = Math.abs(1-Rr)+Math.abs(1-Rc);
				}else if(numbers[i]==8) { //(2,1)
					L = Math.abs(2-Lr)+Math.abs(1-Lc);
					R = Math.abs(2-Rr)+Math.abs(1-Rc);
				}else { // numbers[i]==0  // (3,1)
					L = Math.abs(3-Lr)+Math.abs(1-Lc);
					R = Math.abs(3-Rr)+Math.abs(1-Rc);
				}
				
				
				if(L>R) { //오른쪽이 가까울 때
					answer+="R";
					if(numbers[i]==2) { // (0,1)
						Rr=0; Rc=1;
					}else if(numbers[i]==5) { //(1,1)
						Rr=1; Rc=1;
					}else if(numbers[i]==8) { //(2,1)
						Rr=2; Rc=1;
					}else { // numbers[i]==0  // (3,1)
						Rr=3; Rc=1;
					}
				}else if(L<R) { // 왼쪽이 가까울 때
					answer+="L";
					if(numbers[i]==2) { // (0,1)
						Lr=0; Lc=1;
					}else if(numbers[i]==5) { //(1,1)
						Lr=1; Lc=1;
					}else if(numbers[i]==8) { //(2,1)
						Lr=2; Lc=1;
					}else { // numbers[i]==0  // (3,1)
						Lr=3; Lc=1;
					}
				}else { //같을 때
					if(hand.equals("right")) {
						answer+="R";
						if(numbers[i]==2) { // (0,1)
							Rr=0; Rc=1;
						}else if(numbers[i]==5) { //(1,1)
							Rr=1; Rc=1;
						}else if(numbers[i]==8) { //(2,1)
							Rr=2; Rc=1;
						}else { // numbers[i]==0  // (3,1)
							Rr=3; Rc=1;
						}
					}else {
						answer+="L";
						if(numbers[i]==2) { // (0,1)
							Lr=0; Lc=1;
						}else if(numbers[i]==5) { //(1,1)
							Lr=1; Lc=1;
						}else if(numbers[i]==8) { //(2,1)
							Lr=2; Lc=1;
						}else { // numbers[i]==0  // (3,1)
							Lr=3; Lc=1;
						}
					}
				}
			}
		}
        System.out.println(answer);
        return answer;
    }
}
