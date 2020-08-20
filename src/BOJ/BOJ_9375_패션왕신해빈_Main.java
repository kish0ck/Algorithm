package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String name = st.nextToken();
				String kind = st.nextToken();
				if(!map.containsKey(kind)) {
					map.put(kind, 1);
				}else {
					map.put(kind, map.get(kind)+1);
				}
			}
			int ans = 1;
			for (int val : map.values()) {
				ans *= val + 1;
			}
			System.out.println(ans-1);
		}
		
	}

}

/*
 * package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈_Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			String[] input = new String[n];
			for (int i = 0; i < n; i++) {
				input[i] = br.readLine();
			}
		
			for (int i = 0; i < (1<<n); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				boolean flag = true;
loop:			for (int j = 0; j < n; j++) {
					if((i&(1<<j))!= 0){
						StringTokenizer st = new StringTokenizer(input[j]," ");
						String name = st.nextToken();
						String kind = st.nextToken();
						if(map.containsKey(kind)) {
							flag = false;
							break loop;
						}else {
							map.put(kind, name);
						}
					}
				}
				if(flag) ans++;
			}
			System.out.println(ans-1);
		}
		
	}

}

 * */

