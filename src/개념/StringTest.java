package 개념;

public class StringTest {

	public static void main(String[] args) {
		String str1 = "Kitty";
		String str2 = "Kitty";
		String str3 = new String("Kitty");
		String str4 = new String("Kitty");
		
		System.out.println(str1==str2); 
		System.out.println(str2==str3);
		System.out.println(str3==str4);
		/*
		 * 출력 값
		 * true
		 * false
		 * false
		 */
		System.out.println(str1.equals(str2)); 
		System.out.println(str2.equals(str3));
		System.out.println(str3.equals(str4));
		/*
		 * 출력 값
		 * true
		 * true
		 * true
		 */
	}

}
