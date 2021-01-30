package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17478_재귀함수가뭔가요_Main {

	private static String str1, str2, str3, str4, str5, str6, str7;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		str1 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		str2 = "\"재귀함수가 뭔가요?\"";
		str3 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		str4 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		str5 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		str6 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		str7 = "라고 답변하였지.";
		
		System.out.println(str1);
		dfs(0, N);
	}

	private static void dfs(int cnt, int n) {
		if(cnt==n) {
			for (int i = 0; i < cnt; i++) {
				System.out.print("----");
			}System.out.println(str2);
			for (int i = 0; i < cnt; i++) {
				System.out.print("----");
			}System.out.println(str6);
			for (int i = 0; i < cnt; i++) {
				System.out.print("----");
			}System.out.print(str7);
			return;
		}
		
		
		for (int i = 0; i < cnt; i++) {
			System.out.print("----");
		}System.out.println(str2);
		for (int i = 0; i < cnt; i++) {
			System.out.print("----");
		}System.out.println(str3);
		for (int i = 0; i < cnt; i++) {
			System.out.print("----");
		}System.out.println(str4);
		for (int i = 0; i < cnt; i++) {
			System.out.print("----");
		}System.out.println(str5);
		dfs(cnt+1, n);
		System.out.println();
		for (int i = 0; i < cnt; i++) {
			System.out.print("----");
		}System.out.print(str7);
	}

	

}
