package BOJ;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2020-06-13
// 22:30 ~ 23:00
public class BOJ_2529_부등호_Main {

	private static int k;
	private static String[] input_arr, num_arr;
	private static boolean[] visited;
	private static List<String> ans_list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input_arr = new String[k];
		for (int i = 0; i < k; i++) {
			input_arr[i] = st.nextToken();
		}
		num_arr = new String[k+1];
		visited = new boolean[10];
		ans_list = new ArrayList<String>(); 
		permutation(0);
		System.out.println(ans_list.get(ans_list.size()-1));
		System.out.println(ans_list.get(0));
	}

	private static void permutation(int idx) {
		if(idx>k) {
			boolean flag = true;
			int index = 0;
			for (int i = 0; i < input_arr.length; i++) {
				String num1 = num_arr[index];
				String num2 = num_arr[index+1];
				if(input_arr[i].equals("<")) {
					if(Integer.parseInt(num1)>Integer.parseInt(num2)) {
						flag=false;
						break;
					}
					index++;
				}else {
					if(Integer.parseInt(num1)<Integer.parseInt(num2)) {
						flag=false;
						break;
					}
					index++;
				}
			}
			
			if(flag) {
				String val = "";
				for (int i = 0; i < num_arr.length; i++) {
					val+=num_arr[i];
				}
				ans_list.add(val);
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(!visited[i]) {
				visited[i]=true;
				num_arr[idx] = String.valueOf(i);
				permutation(idx+1);
				visited[i]=false;
			}
		}
		
	}
}
