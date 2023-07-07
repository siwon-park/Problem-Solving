// 트리의 지름 (1967번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N; // 노드의 수
	static int[] distance; // 거리 테이블
	static ArrayList<ArrayList<Pair>> graph; // 트리
	
	static void dfs(int cur, int d) {
		distance[cur] = d;
		for (int i = 0; i < graph.get(cur).size(); i++) {
			Pair nxtPair = graph.get(cur).get(i);
			if (distance[nxtPair.node] == -1) {
				distance[nxtPair.node] = nxtPair.cost + d;
				dfs(nxtPair.node, nxtPair.cost + d);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
		
		StringTokenizer st;
		int a, b, c;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Pair(b, c));
			graph.get(b).add(new Pair(a, c));
		}
		
		distance = new int[N + 1];
		Arrays.fill(distance, -1);
		dfs(1, 0);
		int fn = 0; // 1번 노드에서 가장 먼 노드
		int d = 0;
		for (int i = 1; i < N + 1; i++) {
			if (distance[i] > d) {
				d = distance[i];
				fn = i;
			}
		}
		
        // 가장 먼 노드에서 가장 멀리 있는 노드까지의 거리를 구함
		d = 0;
		Arrays.fill(distance, -1);
		dfs(fn, 0);
		for (int i = 1; i < N + 1; i++) {
			if (distance[i] > d) {
				d = distance[i];
			}
		}
		
		bw.write(d + "");
		bw.flush();
		bw.close();
		br.close();
	}
}


class Pair {
	int node;
	int cost;
	
	Pair(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}