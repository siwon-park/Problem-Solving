// 문제집 (1766번)
import java.io.*;
import java.util.*;

public class Main {
	
	/*
	 * 위상 정렬
	 * */
	static void topologySort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 쉬운 문제를 더 빨리 풀기 위해 우선 순위 큐 사용
		
		for (int i = 1; i < N + 1; i++) { // 문제 번호가 낮을 수록 쉬운 문제
			if (indegree[i] == 0) pq.add(i); // 진입 차수가 0이면 큐에 삽입
		}
		
		int idx = 0; // result 배열에 넣을 인덱스
		while (!pq.isEmpty()) {
			int cur = pq.poll(); // 문제 번호 -> 현재 번호의 문제를 품
			sb.append(cur + " ");
			for (int i = 0; i < graph.get(cur).size(); i++) {
				int nxt = graph.get(cur).get(i); // 다음에 풀 문제
				indegree[nxt] -= 1; // 다음 문제의 진입 차수를 1 감소
				if (indegree[nxt] == 0) pq.add(nxt); // 다음 문제의 진입 차수가 0이되면 삽입
			}
		}
	}
	
	static int N, M; // 문제의 수, 정보의 개수
	static int[] indegree; // 진입 차수
	static ArrayList<ArrayList<Integer>> graph; // 연결 관계 그래프
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N + 1];
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
		
		int A, B;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			indegree[B] += 1; // B의 진입 차수를 증가 -> A번 문제를 먼저 풀고 B를 품
			graph.get(A).add(B); // A -> B
		}
		
		sb = new StringBuilder();
		topologySort();
		System.out.println(sb);
		br.close();
	}
}