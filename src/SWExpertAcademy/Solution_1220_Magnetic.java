package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1220_Magnetic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc < 11; tc++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 1::N극, 2::S극
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[j][i]==1) {
						break;
					}else if(map[j][i]==2) {
						map[j][i]=0;
					}
				}
				for (int j = N-1; j > -1; j--) {
					if(map[j][i]==1) {
						map[j][i]=0;
					}else if(map[j][i]==2) {
						break;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				boolean flag = false;
				for (int j = 0; j < N; j++) {
					if(!flag) {
						if(map[j][i]==1) {
							flag = true;
						}
					}else {
						if(map[j][i]==2) {
							ans++;
							flag=false;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

}
