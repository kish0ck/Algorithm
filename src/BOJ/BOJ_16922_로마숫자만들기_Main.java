package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_16922_로마숫자만들기_Main {

	private static List<Integer> list;
	private static int N;
	private static char[] result;
	private static char[] roma;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		roma = new char[] {'I', 'V', 'X', 'L'};
		list = new ArrayList<Integer>();
		result = new char[N];
		dfs(0);
		System.out.println(list.size());
	}

	private static void dfs(int cnt) {
		if(cnt==N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				switch(result[i]) {
					case 'I' :
						sum+=1;
						break;
					case 'V' :
						sum+=5;
						break;
					case 'X' :
						sum+=10;
						break;
					case 'L' :
						sum+=50;
						break;
				}
			}
			if(!list.contains(sum)) list.add(sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			result[cnt] = roma[i];
			dfs(cnt+1);
		}
		
	}

}
