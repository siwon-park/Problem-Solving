// 수행 시간 (16169번)
import java.io.*;
import java.util.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[n];
		int maxRank = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			Pair pair = new Pair(i, r, t);
			pairs[i] = pair;
			maxRank = Math.max(maxRank, r);
		}
		
		ArrayList<Pair>[] ranks = new ArrayList[maxRank + 1];
		for (int i = 0; i < maxRank + 1; i++) {
			ranks[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n; i++) {
			Pair pair = pairs[i];
			ranks[pair.r].add(pair);
		}
		
		int[] indegree = new int[n]; // i번 컴퓨터의 진입 차수
		for (int i = 1; i < maxRank + 1; i++) {
			for (Pair pair : ranks[i]) {
				// n번째 컴퓨터의 진입차수는 현재 랭크 - 1의 개수
				indegree[pair.n] += ranks[pair.r - 1].size();
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] > o2[0]) return 1;
			else if (o1[0] < o2[0]) return -1;
			else return Integer.compare(o1[1], o2[1]);
		});
		
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				pq.add(new int[] {pairs[i].r, pairs[i].t, pairs[i].n});
				dp[i] = pairs[i].t;
			}
		}
		
		int ans = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0]; // 랭크
			int t = cur[1]; // 시간
			int no = cur[2]; // 번호
			ans = Math.max(ans, dp[no]);
			if (r + 1 <= maxRank) {
				for (int i = 0; i < ranks[r + 1].size(); i++) {
					Pair nxt = ranks[r + 1].get(i);
					indegree[nxt.n] -= 1;
					dp[nxt.n] = Math.max(dp[nxt.n], t + (no - nxt.n) * (no - nxt.n));
					if (indegree[nxt.n] == 0) {
						dp[nxt.n] += nxt.t;
						pq.add(new int[] {nxt.r, dp[nxt.n], nxt.n});
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}

class Pair {
	int n; // 번호
	int r; // 랭크
	int t; // 동작 시간
	Pair() {}
	Pair(int n, int r, int t) {
		this.n = n;
		this.r = r;
		this.t = t;
	}
}
