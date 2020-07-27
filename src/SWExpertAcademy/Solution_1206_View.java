package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc < 11; tc++) {
			int ans = 0;
			int col = Integer.parseInt(br.readLine());
			boolean[][] building = new boolean[255][col];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < col; i++) {
				int val = Integer.parseInt(st.nextToken());
				int cnt = 0;
				while(true) {
					if(cnt==val) break;
					building[254-cnt][i]=true;
					cnt++;
				}
			}
			
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < 255; j++) {
					if(building[j][i]) {
						if(i+2<col&&i-2>-1) {
							if(!building[j][i+1]&&!building[j][i+2]&&!building[j][i-1]&&!building[j][i-2]) {
								ans++;
							}
						}
					}
				}
			}
			
			System.out.println("#"+ tc + " "+ ans);
		}
	}

}
