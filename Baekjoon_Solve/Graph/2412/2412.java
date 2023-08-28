// 암벽 등반 (2412번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int n, T;
	static HashMap<Integer, HashSet<Integer>> hashMap;
	
	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 0});
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int y = pair[0];
			int x = pair[1];
			if (y == T) return pair[2];
			for (int a = -2; a <= 2; a++) {
				if (hashMap.get(x + a) == null) continue;
				for (int b = -2; b <= 2; b++) {
					if (hashMap.get(x + a).contains(y + b)) {
						queue.add(new int[] {y + b, x + a, pair[2] + 1});
						hashMap.get(x + a).remove(y + b);
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		hashMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (hashMap.get(x) == null) hashMap.put(x, new HashSet<>());
			hashMap.get(x).add(y);
		}
		
		int ans = bfs();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}