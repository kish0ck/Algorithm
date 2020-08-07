package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1713_후보추천하기_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //사진 틀
		List<Integer> Frame = new ArrayList<Integer>();
		int input_count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] input = new int[input_count]; // 입력값 넣는 배열
		for (int i = 0; i < input_count; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 구현
		int[] student = new int[101]; // 최대 학생은 100까지 있으므로 학생 추천수
		for (int i = 0; i < input_count; i++) {
			if(student[input[i]]==0) { // 현재 후보자가 틀에 없을때
				if(Frame.size()<N) {
					Frame.add(input[i]);
					student[input[i]]++;
				}else {
					int min_student = 0;
					int min_student_val = Integer.MAX_VALUE;
					int min_student_idx = 0;
					for (int j = 0; j < Frame.size(); j++) {
						int student_number = Frame.get(j);
						if(min_student_val>student[student_number]) {
							min_student_val = student[student_number];
							min_student = student_number;
							min_student_idx = j;
						}
					}
					student[min_student] = 0;
					Frame.remove(min_student_idx);
					Frame.add(input[i]);
					student[input[i]]++;
				}
			}else { // 현재 후보자가 틀에 있을때
				student[input[i]]++;
			}
		}
		
		//사진틀에 사진이 게재된 최종 후보의 학생 번호를 증가하는 순서대로 출력한기 위한 정렬
		Frame.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		// 3. 출력
		for (int i = 0; i < Frame.size(); i++) {
			System.out.print(Frame.get(i)+" ");
		}
	}

}
