package 코테준비;

public class SubSet1Test {
	// 1,2,3 으로 만들 수 있는 부분집합
	public static void main(String[] args) {
		boolean[] selected = new boolean[4];	// 선택 true, 비션택 false
		for (int i = 1; i >= 0; --i) {
			selected[1] = i%2==1 ? true : false;
			for (int j = 1; j >= 0; --j) {
				selected[2] = j%2==1 ? true : false;
				for(int k = 1; k >= 0; --k) {
					selected[3] = k%2==1 ? true : false;
					for(int s = 1,size = selected.length; s<size; s++) {
						System.out.print(selected[s] ? s : "X" + "\t");
					}
					System.out.println();
				}
			}
		}
	}

}
