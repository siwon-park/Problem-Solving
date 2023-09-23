// 경비행기 (2585번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static Pair S, T;
	static Pair[] points;
	
	static int fuel(Pair a, Pair b) {
		double absDist = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		double dist = Math.sqrt(absDist);
		dist /= (double) 10;
		int f = (int) Math.ceil(dist);
		return f;
	}
	
	static boolean bfs(int limit) {
		boolean[] visited = new boolean[N];
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0, limit, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int needFuel = fuel(pair, T); // 현재위치에서 T까지 가는데 필요한 연료
			if (pair.fuel >= needFuel) return true;
			if (pair.k < K) { // 중간 급유 가능 횟수가 남았으면 급유함
				for (int i = 0; i < N; i++) {
					int f = fuel(pair, points[i]);
					if (pair.fuel >= f && !visited[i]) {
						visited[i] = true;
						queue.add(new Pair(points[i].x, points[i].y, limit, pair.k + 1));
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		points = new Pair[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Pair(x, y);
		}
		
		T = new Pair(10000, 10000);
		S = new Pair(0, 0);
		int s = 1;
		int e = fuel(S, T);
		int ans = 0;
		while (s <= e) {
			int mid = (s + e) >> 1;
			boolean flag = bfs(mid);
			if (flag) {
				e = mid - 1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int x, y, fuel, k;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Pair(int x, int y, int fuel, int k) {
		this.x = x;
		this.y = y;
		this.fuel = fuel;
		this.k = k;
	}
}