// 북쪽나라의 도로 (1595번)
import java.io.*;
import java.util.*;

public class Main {

	static long[] distance;
	static ArrayList<ArrayList<int[]>> graph;
	
	static void dfs(int cur, int d) {
		distance[cur] = d;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i)[0];
			int c = graph.get(cur).get(i)[1];
			if (distance[nxt] == -1) dfs(nxt, d + c);
		}
	}
	
	/*
	 * 최장 거리와 해당 노드를 반환
	 * */
	static Pair findDist() {
		long d = 0;
		int farNode = 0;
		for (int i = 1; i < 10001; i++) {
			if (distance[i] > d) {
				d = distance[i];
				farNode = i;
			}
		}
		return new Pair(farNode, d);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		graph = new ArrayList<>();
		for (int i = 0; i < 10001; i++) graph.add(new ArrayList<>());
		
		StringTokenizer st;
		int a, b, c;
		String line;
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			st = new StringTokenizer(line);
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new int[] {b, c});
			graph.get(b).add(new int[] {a, c});
		}
		
		distance = new long[10001];
		Arrays.fill(distance, -1);
		dfs(1, 0);
		Pair pair1 = findDist();
		
		Arrays.fill(distance, -1);
		dfs(pair1.node, 0);
		Pair pair2 = findDist();
		
		bw.write(pair2.dist + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	
	int node;
	long dist;
	
	Pair(int node, long dist) {
		this.node = node;
		this.dist = dist;
	}
}
