package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13335_트럭_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken()); // 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대하중
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] truck = new int[n]; // 트럭 무게
		int[] bridge = new int[w]; // 다리 상태
		boolean[] visited = new boolean[n]; // 사용한 트럭
		
		for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		int time = 0;
		int weight = 0; // 현재 다리의 무게
	
		while(true) {
			time++; // 1. 시간증가
			
			weight-=bridge[w-1]; // 2. 현재 다리의 무게에서 다리의 마지막칸에 있는 무게 빼기
		
			for (int i = w-1; i > 0; i--) { // 3. 다리 한칸씩 이동
				bridge[i] = bridge[i-1]; 
			}
			
			int now_truck = -1; // 4. 현재 이동할 차례 트럭 
			for (int i = 0; i < n; i++) {
				if(!visited[i]) {
					now_truck = i;
					break;
				}
			}
			
			if(now_truck!=-1&&weight+truck[now_truck]<=L) {
				// 5. 다리에 현재 이동할 차례의 트럭 무게가 최대하중 이하이면 bridge[0]에 현재 이동할 차례의 트럭 넣기 
				weight+=truck[now_truck];
				visited[now_truck] = true;
				bridge[0] = truck[now_truck]; 
			}else {
				bridge[0] = 0; 
			}
			
			if(now_truck==-1&&weight==0) break;
		}
		
		System.out.println(time);
		
	}

}
