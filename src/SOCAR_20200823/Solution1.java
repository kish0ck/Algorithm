package SOCAR_20200823;

public class Solution1 {
	static String[] bakery_schedule = { "09:05 10", "12:20 5", "13:25 6", "14:24 5" };
	static String current_time = "12:05";
	static int K = 10;

	static String[] bakery_schedule2 = { "12:00 10" };
	static String current_time2 = "12:00";
	static int K2 = 10;

	static String[] bakery_schedule3 = { "12:00 10" };
	static String current_time3 = "12:00";
	static int K3 = 11;

	public static void main(String[] args) {
		// int ans = solution(bakery_schedule,current_time,K);
		System.out.println(solution(bakery_schedule, current_time, K));

	}

	public static int solution(String[] bakery_schedule, String current_time, int K) {
		int answer = 0;
		int size = bakery_schedule.length;

		int[] countB = new int[size]; // 빵개수
		String[] bakeryS = new String[size];
		String curT; //현재시간

		String[] tmp;
		tmp = current_time.split(":");
		curT = tmp[0] + tmp[1];
		int ct = Integer.parseInt(curT);

		// String으로 분리
		for (int i = 0; i < size; i++) {
			tmp = bakery_schedule[i].split(" ");
			countB[i] = Integer.parseInt(tmp[1]);

			String[] t = tmp[0].split(":");
			bakeryS[i] = t[0] + t[1];
		}

		int index = 0;
		while (true) {
			int st = Integer.parseInt(bakeryS[index]);
			if (ct <= st) {
				break;
			}
			index++;
		} // ex) index=0이면 bakery[0] 부터 보면됨

		int bread = 0;
		int indexT;
		boolean flag = false;
		for (indexT = index; indexT < size; indexT++) {
			bread += countB[indexT];
			if (bread >= K) {
				flag = true;
				break;
			}
		}

		int h, m;
		if (flag) {
			h = Integer.parseInt(bakeryS[indexT].substring(0, 2)) - Integer.parseInt(curT.substring(0, 2));
			int m1 = Integer.parseInt(bakeryS[indexT].substring(2));
			int m2 = Integer.parseInt(curT.substring(2));
			if (m1 - m2 < 0) {
				m1 += 60;
				h--;
			}
			m = m1 - m2;

			answer = h * 60 + m;

		} else
			answer = -1;

		return answer;
	}
}