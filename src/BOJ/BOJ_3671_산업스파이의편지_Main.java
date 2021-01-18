package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_3671_산업스파이의편지_Main {

	private static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < C; tc++) {
			String input = br.readLine();
			char[] arr = input.toCharArray();
			System.out.println(Arrays.toString(arr));
			list = new ArrayList<Integer>();
			for (int i = 0; i < (1<<arr.length); i++) {
				String str = "";
				for (int j = 0; j < arr.length; j++) {
					if((i&1<<j)!=0) {
						str+=arr[j];
//						System.out.print(arr[j]+" ");
					}
				}
				if(str!="") {
					int num = Integer.parseInt(str);
					boolean flag = true;
					for (int j = 2; j < num-1; j++) {
						if(num%j==0) {
							flag = false;
							break;
						}
					}
					if(flag) list.add(num);
				}	
			}
			System.out.println(list.size());
		}
	}

}
