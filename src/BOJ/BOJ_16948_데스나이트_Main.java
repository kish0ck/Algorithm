package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948_데스나이트_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		int[] dx = {-2,-2,0,0,2,2};
		int[] dy = {-1,1,-2,2,-1,1};
		boolean[][] map = new boolean[N][N];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r1,c1,0});
		int ans = -1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==r2&&cur[1]==c2) {
				ans = cur[2];
				break;
			}
			for (int i = 0; i < 6; i++) {
				int nr = cur[0]+dx[i];
				int nc = cur[1]+dy[i];
				if(nr>-1&&nc>-1&&nr<N&&nc<N&&!map[nr][nc]) {
					map[nr][nc] = true;
					q.offer(new int[] {nr,nc,cur[2]+1});
				}
			}
		}
		System.out.println(ans);
	}

}
