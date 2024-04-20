// Strahler 순서 (9470번)
import java.io.*;
import java.util.*;

public class Main {

	static int TC, K, M, P;
	static int[] indegree;
	static ArrayList<Integer>[] graph;
	
	static void init(int n) {
		indegree = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
	}
	
	static int topologySort() {
		int[] strahler = new int[M + 1];
		int[] bigCount = new int[M + 1];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 1; i < M + 1; i++) { // 진입차수가 0인 노드를 넣음
			if (indegree[i] == 0) queue.add(new int[] {i, 1});
			strahler[i] = 1; // 모든 강의 strahler 순서를 1로 초기화
		}
		
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int cur = pair[0];
			int ord = pair[1];
			for (int i = 0; i < graph[cur].size(); i++) {
				int nxt = graph[cur].get(i);
				indegree[nxt] -= 1; // 진입차수 감소
				if (strahler[nxt] < ord) {
					strahler[nxt] = ord;
					bigCount[nxt] = 1;
				} else if (strahler[nxt] == ord) {
					bigCount[nxt] += 1;
				}
				
				if (indegree[nxt] == 0) { // 진입차수가 0이면 큐에 삽입
					if (bigCount[nxt] == 1) {
						queue.add(new int[] {nxt, strahler[nxt]});
					} else if (bigCount[nxt] >= 2) {
						strahler[nxt] += 1;
						queue.add(new int[] {nxt, strahler[nxt]});
					}
					bigCount[nxt] = 0;
				}
			}
		}
		
		return strahler[M];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken()); // TC의 번호
			M = Integer.parseInt(st.nextToken()); // 노드 수(M번 노드는 항상 바다를 만남)
			P = Integer.parseInt(st.nextToken()); // 간선의 수
			init(M); // 초기화
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				// A -> B; B의 진입차수 1증가
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				indegree[B] += 1;
				graph[A].add(B);
			}
			
			bw.write(K + " " + topologySort() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}