package 개념;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerStirngsplit {

	public static void main(String[] args) {
		String str = "kistone:and:kitty";
		StringTokenizer st = new StringTokenizer(str,":");
		System.out.println("StringToeknizer 예시 1");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("\nsplit() 예시 1");
		String[] sp = str.split(":");
		System.out.println(Arrays.toString(sp));
		
		System.out.println("\nsplit() 예시 2 : 원하는 길이 까지만 쪼개기");
		String str2 = "1/2/3/4/5";
		String[] sp2 = str2.split("/",3);
		System.out.println(Arrays.toString(sp2));

		
		
		System.out.println("\nsplit() 예시 3 : 끝의 구분자는 인식하지 않는다  앞과 중간 구분자는 인식");
		String str3 = "/1/2/3/4/5/";
		String[] sp3 = str3.split("/");
		System.out.println(Arrays.toString(sp3));

		System.out.println("\nsplit() 예시 4 : 음수가 들어가면 앞뒤 상관없이 그냥 /을 구분자로 다 쪼갠다");
		String str4 = "/1/2/3/4/5/";
		String[] sp4 = str4.split("/",-1);
		System.out.println(Arrays.toString(sp4));
	}
}
/**
 * 출력
StringToeknizer 예시 1
kistone
and
kitty

split() 예시 1
[kistone, and, kitty]

split() 예시 2 : 원하는 길이 까지만 쪼개기
[1, 2, 3/4/5]

split() 예시 3 : 끝의 구분자는 인식하지 않는다  앞과 중간 구분자는 인식
[, 1, 2, 3, 4, 5]

split() 예시 4 : 음수가 들어가면 앞뒤 상관없이 그냥 /을 구분자로 다 쪼갠다
[, 1, 2, 3, 4, 5, ]
*/


