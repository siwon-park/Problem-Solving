// 멀티탭 스케줄링 (1700번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K; // 멀티탭 구멍의 수, 전기용품 사용 횟수
	static int[] orders; // 사용 순서
	static int[][] idxTable; // 인덱스 테이블
	static boolean[] using; // 각 전기용품의 사용 중 여부
	static Pair[] pairs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		using = new boolean[101];
		 
		orders = new int[K + 1];
		idxTable = new int[101][102];
		for (int i = 0; i < 101; i++) {
			Arrays.fill(idxTable[i], 101);
			idxTable[i][0] = 0;
		}
		
		pairs = new Pair[101];
		for (int i = 0; i < 101; i++) pairs[i] = new Pair(i, 0, 0);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < K + 1; i++) {
			orders[i] = Integer.parseInt(st.nextToken());
			idxTable[orders[i]][0] += 1; // 등장 횟수 증가
			int cnt = idxTable[orders[i]][0];
			idxTable[orders[i]][cnt] = i;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(
				(Pair o1, Pair o2) -> Integer.compare(o2.idx, o1.idx)
		);
		
		int total = 0;
		for (int i = 1; i < K + 1; i++) {
			int cur = orders[i];
			if (pq.size() < N) { // 멀티탭에 꽂힌 제품의 수가 구멍의 수 이하면 삽입
				pairs[cur].cnt += 1;
				pairs[cur].idx = idxTable[cur][pairs[cur].cnt + 1];
				// 현재 꽂혀있는 제품일 경우 -> 우선순위 큐만 재정렬함
				if (using[cur]) {
					// 재정렬을 위한 더미 데이터
					pq.add(new Pair(1, 200, 200));
					pq.poll();
				} else { // 현재 꽂혀있지 않은 제품인 경우
					pq.add(pairs[cur]);
					using[cur] = true;
				}
			} else { // 구멍의 수가 full이면
				pairs[cur].cnt += 1;
				pairs[cur].idx = idxTable[cur][pairs[cur].cnt + 1];
				// 현재 사용중인 제품인 경우
				if (using[cur]) {
					pq.add(new Pair(1, 200, 200));
					pq.poll();
				} else { // 현재 사용 중인 제품이 아닌 경우
					Pair out = pq.poll();
					using[out.no] = false;
					pq.add(pairs[cur]);
					using[cur] = true;
					total += 1; // 멀티탭을 뽑은 횟수 증가
				}
			}
			pq.add(new Pair(1, 200, 200));
			pq.poll();
		}
		
		System.out.println(total);
	}	
}


class Pair {
	int no;
	int cnt;
	int idx;
	
	Pair(int no, int cnt, int idx) {
		this.no = no;
		this.cnt = cnt;
		this.idx = idx;
	}
}