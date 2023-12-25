// 움직이는 미로 탈출 (16954번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1, 0};
	static final int[] dx = {0, 1, 0, -1, 1, -1, 1, -1, 0};
	static Character[][] graph = new Character[8][8];
	static Queue<Pair> wallsList = new LinkedList<>();
	
	static int simulate() {
		Pair s = new Pair(7, 0, -1);
		boolean[][][] visited = new boolean[8][8][9];
		Queue<Pair> queue = new LinkedList<>();
		queue.add(s);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Pair pair = queue.poll();
				if (graph[pair.y][pair.x] == '#') continue; // 현재 위치가 벽이면 이동 못함
				if (pair.y == 0 && pair.x == 7) return 1;
				for (int k = 0; k < 9; k++) {
					int ny = pair.y + dy[k];
					int nx = pair.x + dx[k];
					if (ny < 0 || ny >= 8 || nx < 0 || nx >= 8 || graph[ny][nx] == '#') continue;
					if (!visited[ny][nx][k]) {
						visited[ny][nx][k] = true;
						queue.add(new Pair(ny, nx, k));
					}
				}
			}
			wallMove();
			
		}
		return 0;
	}
	
	static void wallMove() {
		int size = wallsList.size();
		Queue<Pair> tmp = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			Pair pair = wallsList.poll();
			int ny = pair.y + dy[2];
			graph[pair.y][pair.x] = '.';
			if (ny >= 8) continue;
			Pair nxt = new Pair(ny, pair.x);
			tmp.add(nxt);
			wallsList.add(nxt);
		}
		
		while (!tmp.isEmpty()) {
			Pair pair = tmp.poll();
			graph[pair.y][pair.x] = '#';
		}
		return;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 8; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				graph[i][j] = line.charAt(j);
				if (graph[i][j] == '#') {
					wallsList.add(new Pair(i, j));
				}
			}
		}
		
		int ans = simulate();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int y, x, d;
	Pair() {}
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	Pair(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
}