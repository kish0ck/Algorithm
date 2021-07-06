package 코테준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nextCombination {
	// 1부터 N까지의 수
	static int N, R, totalCount;
	static int[] numbers, comb; // R개의 수 저장
	static int[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		numbers = new int[N];
		selected = new int[N];
		comb = new int[R];
		for(int i=1; i<=N; ++i) { 	// number 배열에 1부터 차례로 넣음
			numbers[i-1] = i;
		}
		for(int i=N-1; i>=N-R; --i) {	// select 배열에 맨 뒤부터 R개만큼 1을 채움
			selected[i] = 1;
		}
		for(int j=0, k=0; j<N; ++j) {		// 처음 조합 하나를 출력하기 위해 comb에 넣어줌
			if(selected[j]==1) comb[k++] = numbers[j];
		}
		
		do {
			System.out.println(Arrays.toString(comb));
		} while(nextCombination());
		System.out.println("총 경우의 수 : " + totalCount);
	}
	
	static void swap(int i, int j) {
		int tmp = selected[i];
		selected[i] = selected[j];
		selected[j] = tmp;
	}
	
	public static boolean nextCombination() {
		totalCount++;
		// 1. 뒷쪽부터 왼쪽으로 탐색하며 교환이 필요한 위치 찾기
		int i=N-1;
		while(i>0 && selected[i-1] >= selected[i]) --i;
		
		// 찾은 위치가 0이면 이미 내림차순된 순열이므로 다음 순열은 없다.
		if(i==0) return false;
		
		// 2. i-1 위치 : 교환이 필요한 위치
		//    i-1 위치값과 교환할 뒷쪽에서 다음 큰 수 찾기
		int j = N-1;
		while(selected[i-1] >= selected[j]) --j;
		// 3. i-1 위치값과 j 위치값 교환
		swap(i-1, j);
		// 4. i 위치부터 끝까지의 순열을 오름차순으로 재조정
		j = N-1;
		while(i<j) swap(i++, j--);
		
		for(int k=0, x=0; k<N; ++k) {
			if(selected[k]==1) comb[x++] = numbers[k];
		}
		
		return true;
	}
}
