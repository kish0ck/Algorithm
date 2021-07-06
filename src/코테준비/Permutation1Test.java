package 코테준비;

public class Permutation1Test {

	
	// 1, 2, 3
	// 3자리수 순열
	// 3P3 = 3! = 6가지 경우
	
	public static void main(String[] args) {
		int n = 3;
		for (int i = 1; i <=n; i++) { // 첫째수 : 1, 2, 3 시도
			for (int j = 1; j <= n; j++) { // 둘째수 : 1, 2, 3 시도
				if(i != j) { // 첫째 수와 둘째 수가 다르면
					for (int k = 1; k <= n; k++) { //셋째수 : 1, 2, 3 시도
						if(k!=i &&k != j) System.out.println(i+" "+j+" "+k);
					}
				}
			}
		}
		
	}

}
