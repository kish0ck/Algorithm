package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1347_미로만들기_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] note = br.readLine().toCharArray();
		int dir = 0; // 0남 1서 2북 3동
		int max_r=50, max_c=50;
		int min_r=50, min_c=50;
		int now_r = 50, now_c = 50;

		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] {50, 50});
		for (int i = 0; i < N; i++) {
			if(note[i]=='R'||note[i]=='L') {
				if(note[i]=='R') { //오른쪽 회전
					if(dir==3) {
						dir=0;
					}else {
						dir++;
					}
					
				}else { // 왼쪽 회전
					if(dir==0) {
						dir=3;
					}else {
						dir--;
					}
				}
			}else {
				if(note[i]=='F') { //앞으로
					if(dir==0) {//남
						now_r++;
						if(max_r<now_r) max_r=now_r;
					}else if(dir==1) {//서
						now_c--;
						if(min_c>now_c) min_c=now_c;
					}else if(dir==2) {//북
						now_r--;
						if(min_r>now_r) min_r=now_r;
					}else {//동
						now_c++;
						if(max_c<now_c) max_c=now_c;
					}
				}else { // 뒤로
					if(dir==0) {//남 이니까 북
						now_r--;
						if(min_r>now_r) min_r=now_r;
					}else if(dir==1) {//서니까 동
						now_c++;
						if(max_c<now_c) max_c=now_c;
					}else if(dir==2) {//북 이니까 남
						now_r++;
						if(max_r<now_r) max_r=now_r;
					}else {//동 이니까 서
						now_c--;
						if(min_c>now_c) min_c=now_c;
					}
				}
				list.add(new int[] {now_r, now_c});
			}
		}
		
		char[][] board = new char[101][101];
		for (int r = min_r; r <= max_r; r++) {
			for (int c = min_c; c <= max_c; c++) {
				board[r][c] = '#';
			}
		}
		
		for (int j = 0; j < list.size(); j++) {
			int[] cur = list.get(j);
			board[cur[0]][cur[1]] = '.';
		}
		
		for (int r = min_r; r <= max_r; r++) {
			for (int c = min_c; c <= max_c; c++) {
				System.out.print(board[r][c]);
			}System.out.println();
		}
	}

}
