package Programmers;

public class 가운데글자가져오기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "abcde";
		String s = "qwer";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		String answer = "";
		int length = s.length();
//		System.out.println(length);
		if (length % 2 == 0) { // 짝수
			answer += s.charAt((length / 2) - 1) + "";
		}
		answer += s.charAt(length / 2) + "";
		return answer;
	}

}
