package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16159_전광판의숫자_Main {

	private static int[] arr;
	private static int[][] num8;
	private static int[][] num9;
	private static int[][] num7;
	private static int[][] num6;
	private static int[][] num5;
	private static int[][] num4;
	private static int[][] num3;
	private static int[][] num2;
	private static int[][] num1;
	private static int[][] num0;
	private static int count;
	private static boolean flag;
	private static int[][] board;
	private static boolean flag2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		board = new int[7][len];
		for (int i = 0; i < len; i++) {
			board[0][i] = str.charAt(i) - '0';
		}
		for (int i = 1; i < 7; i++) {
			str = br.readLine();
			for (int j = 0; j < len; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		num0 = new int[7][6];
		num0[1][2] = 1;
		num0[1][3] = 1;
		num0[2][1] = 1;
		num0[2][4] = 1;
		num0[3][1] = 1;
		num0[3][4] = 1;
		num0[4][1] = 1;
		num0[4][4] = 1;
		num0[5][2] = 1;
		num0[5][3] = 1;
		num1 = new int[7][6];
		num1[1][3] = 1;
		num1[2][2] = 1;
		num1[2][3] = 1;
		num1[3][3] = 1;
		num1[4][3] = 1;
		num1[5][3] = 1;
		num2 = new int[7][6];
		num2[1][1] = num2[1][2] = num2[1][3] = num2[1][4] = num2[2][4] = num2[3][1] = num2[3][2] = num2[3][3] = num2[3][4] = num2[4][1] = num2[5][1] = num2[5][2] = num2[5][3] = num2[5][4] = 1;
		num3 = new int[7][6];
		num3[1][1] = 1;
		num3[1][2] = 1;
		num3[1][3] = 1;
		num3[2][4] = 1;
		num3[3][3] = 1;
		num3[4][4] = 1;
		num3[5][1] = 1;
		num3[5][2] = 1;
		num3[5][3] = 1;
		num4 = new int[7][6];
		num4[1][3] = 1;
		num4[2][2] = 1;
		num4[2][3] = 1;
		num4[3][1] = 1;
		num4[3][3] = 1;
		num4[4][0] = 1;
		num4[4][1] = 1;
		num4[4][2] = 1;
		num4[4][3] = 1;
		num4[4][4] = 1;
		num4[5][3] = 1;

		num5 = new int[7][6];
		num5[1][1] = 1;
		num5[1][2] = 1;
		num5[1][3] = 1;
		num5[1][4] = 1;
		num5[2][1] = 1;
		num5[3][1] = 1;
		num5[3][2] = 1;
		num5[3][3] = 1;
		num5[4][4] = 1;
		num5[5][1] = 1;
		num5[5][4] = 1;
		num5[6][2] = 1;
		num5[6][3] = 1;

		num6 = new int[7][6];
		num6[1][1] = num6[2][1] = num6[3][1] = num6[3][2] = num6[3][3] = num6[3][4] = num6[4][1] = num6[4][4] = num6[5][1] = num6[5][2] = num6[5][3] = num6[5][4] = 1;
		num7 = new int[7][6];
		num7[1][1] = num7[1][2] = num7[1][3] = num7[1][4] = num7[2][4] = num7[3][3] = num7[4][3] = num7[5][3] = 1;
		num8 = new int[7][6];
		num8[1][1] = num8[1][2] = num8[1][3] = num8[1][4] = num8[2][1] = num8[2][4] = num8[3][1] = num8[3][2] = num8[3][3] = num8[3][4] = num8[4][1] = num8[4][4] = num8[5][1] = num8[5][2] = num8[5][3] = num8[5][4] = 1;
		num9 = new int[7][6];
		num9[0][1] = num9[0][2] = num9[0][3] = num9[0][4] = num9[1][1] = num9[1][4] = num9[2][1] = num9[2][4] = num9[3][1] = num9[3][2] = num9[3][3] = num9[3][4] = num9[4][4] = num9[5][4] = num9[6][4] = 1;
		arr = new int[len / 6];
		count = len / 6;

//		System.out.println("count"+count);
		flag = false;
		check(0);
//		System.out.println(Arrays.toString(arr));
		int input = 0;
		int a = 1;
		for (int i = count - 1; i > -1; i--) {
			input += arr[i] * a;
			a *= 10;
		}
//		System.out.println(input);
		Arrays.sort(arr);
		flag2 = false;
		boolean flag3 = false;
		do {
			if (flag2) {
				int[][] ans = new int[7][len];
				for (int i = 0; i < 7; i++) {
					int idx = -1;
					for (int j = 0; j < len; j++) {
						if (j % 6 == 0)
							idx++;
						switch (arr[idx]) {
						case 0:
							ans[i][j] = num0[i][j % 6];
							break;
						case 1:
							ans[i][j] = num1[i][j % 6];
							break;
						case 2:
							ans[i][j] = num2[i][j % 6];
							break;
						case 3:
							ans[i][j] = num3[i][j % 6];
							break;
						case 4:
							ans[i][j] = num4[i][j % 6];
							break;
						case 5:
							ans[i][j] = num5[i][j % 6];
							break;
						case 6:
							ans[i][j] = num6[i][j % 6];
							break;
						case 7:
							ans[i][j] = num7[i][j % 6];
							break;
						case 8:
							ans[i][j] = num8[i][j % 6];
							break;
						case 9:
							ans[i][j] = num9[i][j % 6];
							break;
						}
					}
				}
				flag3 = true;
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < len; j++) {
						System.out.print(ans[i][j]);
					}
					System.out.println();
				}
				break;
			} else {
				int number = 0;
				int b = 1;
				for (int i = count - 1; i > -1; i--) {
					number += arr[i] * b;
					b *= 10;
				}
				if (number == input)
					flag2 = true;
			}
		} while (next_permutation());

		if (!flag3)
			System.out.println("The End");

	}

	private static boolean next_permutation() {
		int i = count - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;

		if (i == 0)
			return false;

		int j = count - 1;
		while (arr[i - 1] >= arr[j])
			--j;

		swap(i - 1, j);

		j = count - 1;
		while (i < j) {
			swap(i++, j--);
		}
		return true;

	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void check(int cnt) {
		if (cnt == count) {
			flag = true;
			return;
		}
		if (flag)
			return;

		boolean flag0 = false, flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false,
				flag7 = false, flag8 = false, flag9 = false;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 6; j++) {
				if (!flag0) {
					if (board[i][j + (cnt * 6)] != num0[i][j]) {
						flag0 = true;
					}
				}
				if (!flag1) {
					if (board[i][j + (cnt * 6)] != num1[i][j]) {
						flag1 = true;
					}
				}
				if (!flag2) {
					if (board[i][j + (cnt * 6)] != num2[i][j]) {
						flag2 = true;
					}
				}
				if (!flag3) {
					if (board[i][j + (cnt * 6)] != num3[i][j]) {
						flag3 = true;
					}
				}
				if (!flag4) {
					if (board[i][j + (cnt * 6)] != num4[i][j]) {
						flag4 = true;
					}
				}
				if (!flag5) {
					if (board[i][j + (cnt * 6)] != num5[i][j]) {
						flag5 = true;
					}
				}
				if (!flag6) {
					if (board[i][j + (cnt * 6)] != num6[i][j]) {
						flag6 = true;
					}
				}
				if (!flag7) {
					if (board[i][j + (cnt * 6)] != num7[i][j]) {
						flag7 = true;
					}
				}
				if (!flag8) {
					if (board[i][j + (cnt * 6)] != num8[i][j]) {
						flag8 = true;
					}
				}
				if (!flag9) {
					if (board[i][j + (cnt * 6)] != num9[i][j]) {
						flag9 = true;
					}
				}
			}
		}
		if (!flag0)
			arr[cnt] = 0;
		if (!flag1)
			arr[cnt] = 1;
		if (!flag2)
			arr[cnt] = 2;
		if (!flag3)
			arr[cnt] = 3;
		if (!flag4)
			arr[cnt] = 4;
		if (!flag5)
			arr[cnt] = 5;
		if (!flag6)
			arr[cnt] = 6;
		if (!flag7)
			arr[cnt] = 7;
		if (!flag8)
			arr[cnt] = 8;
		if (!flag9)
			arr[cnt] = 9;

		check(cnt + 1);
	}

}
