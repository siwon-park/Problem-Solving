// 로봇 시뮬레이션 (2174번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, N, M;
	static Robot[] robots;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] graph;
	static boolean isCrashed = false;
	
	/*
	 * 벽이랑 부딪히면 0, 로봇이랑 부딪히면 부딪힌 로봇 숫자, 안착했으면 -1
	 * */
	static int simulate(int rn, int w, int cnt) {
		Robot robot = robots[rn];
		graph[robot.y][robot.x] = 0; // 로봇을 빈 칸으로 변경
		while (cnt-- > 0) {
			int k = (robot.k + w + 4) % 4;
			int ny = robot.y + dy[k];
			int nx = robot.x + dx[k];
			if (w == 0) { // F일 경우에만 이동
				if (ny < 0 || ny >= B || nx < 0 || nx >= A) {
					isCrashed = true;
					return 0;
				}
				if (graph[ny][nx] != 0) {
					isCrashed = true;
					return graph[ny][nx];
				}
				robot.y = ny;
				robot.x = nx;	
			}
			robot.k = k;
		}
		
		graph[robot.y][robot.x] = rn;
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		graph = new int[B][A];
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		robots = new Robot[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = B - Integer.parseInt(st.nextToken());
			String way = st.nextToken();
			int k = -1; // 로봇의 방향
			if (way.equals("N")) {
				k = 0;
			} else if (way.equals("E")) {
				k = 1;
			} else if (way.equals("S")) {
				k = 2;
			} else {
				k = 3;
			}
			robots[i] = new Robot(y, x, k);
			graph[y][x] = i;
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int rn = Integer.parseInt(st.nextToken());
			String cmd = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			if (isCrashed) continue;
			int x = 0;
			if (cmd.equals("L")) {
				x = -1;
			} else if (cmd.equals("R")) {
				x = 1;
			}
			int ret = simulate(rn, x, cnt);
			if (ret == 0) {
				bw.write(String.format("Robot %d crashes into the wall", rn));
			} else if (ret > 0) {
				bw.write(String.format("Robot %d crashes into robot %d", rn, ret));
			}
		}
		
		if (!isCrashed) {
			bw.write("OK");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class Robot {
	int y, x, k;
	Robot() {}
	Robot(int y, int x, int k) {
		this.y = y;
		this.x = x;
		this.k = k;
	}
}