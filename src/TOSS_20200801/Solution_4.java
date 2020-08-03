package TOSS_20200801;

import java.util.*;
import java.io.*;

public class Solution_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		while(st.hasMoreTokens()) {
			String gzsd = st.nextToken(); // 현재 결제수단
			if(!set.contains(gzsd)) {
				set.add(gzsd);
				list.add(gzsd);
			}else {
				list.remove(gzsd);
				list.add(gzsd);
			}
			if(list.size()>5) list.remove(0);
			for (int i = list.size()-1; i > -1; i--) {
				System.out.print(list.get(i)+" ");
			}System.out.println();
		}
	}

}
