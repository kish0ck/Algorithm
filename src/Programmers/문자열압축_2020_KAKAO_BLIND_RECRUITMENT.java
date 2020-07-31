package Programmers;

import java.util.Arrays;

public class 문자열압축_2020_KAKAO_BLIND_RECRUITMENT {

	public static void main(String[] args) {
		int res1 = solution("aabbaccc");
		int res2 = solution("ababcdcdababcdcd");
		int res3 = solution("abcabcdede");
		int res4 = solution("abcabcabcabcdededededede");
		int res5 = solution("xababcdcdababcdcd");
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		System.out.println(res4);
		System.out.println(res5);
	}
	
	private static int solution(String s) {
		int answer = Integer.MAX_VALUE;
		int len = s.length();
		int unit = len/2;
		if(len==1) return 1;
		while(true) {
			String[] arr = new String[len/unit];
			int idx = 0;
			String str = "";
			boolean flag = false; // 딱떨어지는지?
			if(len%unit==0) flag=true;
			for (int i = 0; i < len; i++) {
				if(idx+unit>len) break;
				arr[i] = s.substring(idx, idx+unit);
				idx+=unit;
			}
			int count = 1;
			for (int i = 1; i < len/unit+1; i++) {
				String before = arr[i-1];
				if(i==len/unit) {
					if(count<=1) {
						str+=arr[len/unit-1];
					}else {
						str+=count+""+arr[len/unit-1];
					}
				}else {
					String now = arr[i];
					if(now.equals(before)) {
						count++;
					}else {
						if(count<=1) {
							str+=before;
						}else {
							str+=count+""+before;
						}
						count=1;
					}
				}
			}
			if(!flag) str+=s.substring(len-(len%unit), len);
			if(str.length()<answer) answer=str.length();
			unit--;
			if(unit==0) break;
		}
		
		return answer;
	}
}
