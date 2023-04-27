import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = {-1, 0, 1, 0, -1, 1, 1, -1};
	static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
	static int N;
	static int[][] graph, modifiedGraph;
	static Pair[] zombies;
	
	static boolean inRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String order = br.readLine(); // 아리의 움직임 명령
		int M = order.length(); // 명령의 크기

		Queue<Pair> q = new LinkedList<>(); // 좀비의 위치를 담은 임시 큐
		graph = new int[N][N];
		modifiedGraph = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();;
			for (int j = 0; j < N; j++) {
				if (line.charAt(j) == 'Z') { // 좀비는 2표시
					modifiedGraph[i][j] = 2;
					q.add(new Pair(i, j, 2));
				} else if (line.charAt(j) == 'S') { // 스위치는 1표시
					graph[i][j] = 1;
					modifiedGraph[i][j] = 1;
				}
			}
		}
		
		int Z = 0; // 좀비의 수
		zombies = new Pair[q.size()];
		while (!q.isEmpty()) {
			zombies[Z++] = q.poll();
		}
		
		boolean flag = true; // 좀비를 만나지 않고 이동 가능한지 유무
		int ay = 0;
		int ax = 0;
		int aw = 2; // 아리의 현재 방향
		for (int i = 0; i < M; i++) {
			char x = order.charAt(i); // 명령
			
			if (x == 'F') { // 한 칸 앞으로 전진
				int ny = ay + dy[aw];
				int nx = ax + dx[aw];
				// 벽에 부딪히면 제자리에 있음 -> 범위 안일 경우에만 이동
				if (inRange(ny, nx)) {
					// 스위치를 만나면 주변을 1로 바꿈
					if (graph[ny][nx] == 1) {
						for (int k = 0; k < 8; k++) { // 8방향으로 불이 켜짐
							if (inRange(ny + dy[k], nx + dx[k])) {
								modifiedGraph[ny + dy[k]][nx + dx[k]] = 1; 
							}
						}
					}
					// 좀비를 만나면 flag를 false로 바꾸고 break
					else if (modifiedGraph[ny][nx] == 2) {
						flag = false;
						break;
					}
					// 아리의 위치를 이동
					ay = ny;
					ax = nx;
				}
				
			} else if (x == 'L') { // 왼쪽으로 90도 회전
				aw = (aw - 1 >= 0) ? aw - 1 : 3;
			} else if (x == 'R') { // 오른쪽으로 90도 회전
				aw = (aw + 1 <= 3) ? aw + 1 : 0;
			}
			
			Pair[] tmpZombies = new Pair[Z]; // 임시 좀비 배열
			for (int z = 0; z < Z; z++) {
				Pair pair = zombies[z];
				// 원래 좀비가 있던 곳의 위치를 0으로 마킹함
				if (modifiedGraph[pair.y][pair.x] != 1) {
					modifiedGraph[pair.y][pair.x] = 0;
				}
				// 좀비 이동 -> 벽에 부딪히면 방향을 바꿈
				int zy = pair.y + dy[pair.dir];
				int zx = pair.x + dx[pair.dir];
				if (inRange(zy, zx)) { // 범위 안이면
					tmpZombies[z] = new Pair(zy, zx, pair.dir);
				} else { // 벽에 부딪혔으면
					int dir = 0;
					if (pair.dir == 0) dir = 2;
					else if (pair.dir == 1) dir = 3;
					else if (pair.dir == 2) dir = 0;
					else if (pair.dir == 3) dir = 1;
					tmpZombies[z] = new Pair(pair.y, pair.x, dir);
				}
			}
			
			// 이동한 곳이 불이 켜진 곳이 아니면 좀비를 표시
			for (int z = 0; z < Z; z++) {
				Pair pair = tmpZombies[z];
				if (modifiedGraph[pair.y][pair.x] != 1) {
					modifiedGraph[pair.y][pair.x] = 2;
					if (pair.y == ay && pair.x == ax) flag = false;
				}
				zombies[z] = pair;
			}
			
		}
		
		if (flag) System.out.println("Phew...");
		else System.out.println("Aaaaaah!");
	}
}

class Pair {
	int y;
	int x;
	int dir; // 방향
	
	Pair(int y, int x, int dir) {
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
}