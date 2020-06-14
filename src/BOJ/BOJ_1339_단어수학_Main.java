package BOJ;

// 2020-06-14
// 13:07 ~ 13:42 ==> 시간초과
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BOJ_1339_단어수학_Main {

	private static int[] arr;
	private static int size;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < N; i++) {
			input[i]  = br.readLine();
			for (int j = 0; j < input[i].length(); j++) {
				set.add(input[i].charAt(j));
			}
		}
		Iterator<Character> set_it = set.iterator();
		size = set.size();
		Character[] letters = new Character[size];
		for (int i = 0; i < set.size(); i++) {
			letters[i]=set_it.next();
		}
		arr = new int[size];
		int idx=0;
		for (int i = 9; i>-1; i--) {
			arr[idx]=i;
			idx++;
			if(idx==size) break;
		}
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		do {
			int sum = 0;
			
			int alpha[] = new int[256];
			for (int i = 0; i < set.size(); i++) {
				alpha[letters[i]] = arr[i];
			}
			for (int j = 0; j < N; j++) {
				int now = 0;
				for (int j2 = 0; j2 < input[j].length(); j2++) {
					now = now * 10 + alpha[input[j].charAt(j2)];
				}
				sum+=now;
			}
			if(sum>max) max=sum;
		}while(nextpermutaion());
		System.out.println(max);
	}

	private static boolean nextpermutaion() {
		int i = size-1;
		while(i>0 && arr[i-1] >= arr[i]) --i;
		
		if(i==0) return false;
		
		int j = size-1;
		while(arr[i-1]>=arr[j]) --j;
		
		swap(i-1, j);
		
		j = size-1;
		while(i<j) {
			swap(i++, j--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
