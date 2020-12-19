package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7568_덩치_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new int[] {x, y});
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			int now_x = list.get(i)[0];
			int now_y = list.get(i)[1];
			int count = 0;
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if(now_x<list.get(j)[0] && now_y<list.get(j)[1]) {
					count++;
				}
			}
			sb.append(count+1+" ");
		}
		System.out.println(sb.toString());
	}

}
