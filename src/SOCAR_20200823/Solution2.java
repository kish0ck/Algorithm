package SOCAR_20200823;

public class Solution2 {

	public static void main(String[] args) {
		String[] drum = {"######", ">#*###", "####*#", "#<#>>#", ">#*#*<","######"};
		int res = solution(drum);
		System.out.println(res);
	}

	private static int solution(String[] drum) {
		int ans=0;
		int r = drum.length;
		char[][] map = new char[r][r];
		for (int i = 0; i < r; i++) {
			map[i] = drum[i].toCharArray();
		}
		
		
		for (int c = 0; c < r; c++) {
			boolean flag88 = false;
			boolean flag8 = false;
			int rr = 0 ;
			int cc = c;
			while(true) {
				if(rr==r) break;
				switch(map[rr][cc]) {
					case '#':
						rr++;
						break;
					case '>':
						cc++;
						break;
					case '<':
						cc--;
						break;
					case '*':
						if(!flag8) { // * 처음
							rr++;
							flag8=true;
						}else {
							flag88=true;//*두번째
							break;
						}
						break;
				}
				if(flag88) break;
			}
			
			if(rr==r) {
				ans++;
			} 
		}
		
		
		return ans;
	}

}
