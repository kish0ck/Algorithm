package 개념;

import java.util.HashMap;

public class Ex_18 {

	public static void main(String[] args) {
		String str1 = "Hello! Java World";
		int index = str1.indexOf("Java"); // 7 
		int size = "Java".length(); // 4 
		String str2 = str1.substring(index, index+size); // Java
		str2 = str2.toLowerCase(); // java
		str2 = str2.replace('a', 'A'); //jAvA
		
		
		HashMap map = new HashMap();
		map.put(1, "kim");
		map.put(1, "lee");
		map.put(1, "Jung");
		map.put(1, "Park");
		System.out.println(map.size()); // 1
		System.out.println(map.get(1)); // Park
	}

}
