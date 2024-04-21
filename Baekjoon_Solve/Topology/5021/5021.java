// 왕위 계승 (5021번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static HashMap<String, Integer> hashMap = new HashMap<>();
	static ArrayList<Integer>[] graph;
	static int[] indegree;
	static double[] kingPoint;
	
	static void topologySort(int n) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) queue.add(i);
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				indegree[nxt] -= 1;
				kingPoint[nxt] += 0.5 * kingPoint[cur];
				if (indegree[nxt] == 0) queue.add(nxt);
			}
		}
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int node = 0;
		String ancestor = br.readLine();
		hashMap.putIfAbsent(ancestor, node++);
		indegree = new int[101];
		kingPoint = new double[101];
		kingPoint[hashMap.get(ancestor)] = 1;
		graph = new ArrayList[101];
		for (int i = 0; i < 101; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			String f = st.nextToken();
			String m = st.nextToken();
			if (!hashMap.containsKey(f)) {
				hashMap.put(f, node++);
			}
			if (!hashMap.containsKey(m)) {
				hashMap.put(m, node++);
			}
			if (!hashMap.containsKey(c)) {
				hashMap.put(c, node++);
			}
			graph[hashMap.get(f)].add(hashMap.get(c));
			graph[hashMap.get(m)].add(hashMap.get(c));
			indegree[hashMap.get(c)] = 2;
		}
		
		topologySort(node);
		
		double max = 0;
		String succeeder = "";
		for (int i = 0; i < M; i++) {
			String candidate = br.readLine();
			if (!hashMap.containsKey(candidate)) {
				hashMap.put(candidate, node++);
			}
			int c = hashMap.get(candidate);
			if (max < kingPoint[c]) {
				max = kingPoint[c];
				succeeder = candidate;
			}
		}
		
		bw.write(succeeder);
		bw.flush();
		bw.close();
		br.close();
	}
}
