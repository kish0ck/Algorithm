package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911_거북이_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int area = 0;
			String control = br.readLine();
			char[] control_program = new char[control.length()];
			control_program = control.toCharArray();
			char dir = 'N';
			int t_x = 0, t_y = 0, x_max=0, x_min=0, y_max=0, y_min=0;
			for (int i = 0; i < control_program.length; i++) {
				char command = control_program[i];
				if(command == 'L' || command == 'R') {
					if(dir=='W') {
						if(command=='L') {
							dir = 'S';
						}else {
							dir = 'N';
						}
					}else if(dir=='E') {
						if(command=='L') {
							dir = 'N';
						}else {
							dir = 'S';
						}
					}else if(dir=='N') {
						if(command=='L') {
							dir = 'W';
						}else {
							dir = 'E';
						}
					}else { // dir == 'S'
						if(command=='L') {
							dir = 'E';
						}else {
							dir = 'W';
						}
					}
				}else {
					if(command == 'F') { //앞으로 뒤로
						switch(dir) {
							case 'W':
								t_y -= 1;
								break;
							case 'E':
								t_y += 1;
								break;
							case 'N':
								t_x -= 1;
								break;
							case 'S':
								t_x += 1;
								break;
						}
						if(t_x>x_max) x_max=t_x;
						if(t_x<x_min) x_min=t_x;
						if(t_y>y_max) y_max=t_y;
						if(t_y<y_min) y_min=t_y;
					}else { //뒤로
						switch(dir) {
							case 'W':
								t_y += 1;
								break;
							case 'E':
								t_y -= 1;
								break;
							case 'N':
								t_x += 1;
								break;
							case 'S':
								t_x -= 1;
								break;
					}
						if(t_x>x_max) x_max=t_x;
						if(t_x<x_min) x_min=t_x;
						if(t_y>y_max) y_max=t_y;
						if(t_y<y_min) y_min=t_y;
					}
				}
			}
			area = (x_max-x_min) * (y_max-y_min);
			System.out.println(area);
		}
	}

}
