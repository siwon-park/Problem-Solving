import java.util.*;
import java.io.*;

public class Main {

	static int N, M; // N x N 격자의 크기, 탈영병의 수
	static final int MAX = Integer.MAX_VALUE;
	static int ans; // 최소 비용
	static int[][] graph; // 격자판
	static Pair[] dpList; // 탈영병 위치 배열
	static int[][][] distanceTable; // i번 탈영병에 대한 최단거리 테이블(0번은 출발 부대)
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[] visited;
	
	static void backtrack(int k, int s, int cost) { // 백트랙킹 순열 구성
		if (cost > ans) return; // 현재 비용이 현재의 최소 비용보다 크면 return
		if (k == M + 1) { // 출발지와 탈영병 M명을 포함하기 때문에 M + 1임
			ans = Math.min(ans, cost + distanceTable[s][dpList[0].y][dpList[0].x]);
			return;
		}
		for (int i = 1; i <= M; i++) {
			if (!visited[i]) {
				visited[i] = true;
				backtrack(k + 1, i, cost + distanceTable[s][dpList[i].y][dpList[i].x]);
				visited[i] = false;
			}
		}
	}
	
	static void dijkstra(int m) { // m번 병사에 대한 다익스트라
		int[][] distance = distanceTable[m]; // m번 탈영병의 최단거리 테이블
		Pair start = dpList[m]; // m번 병사의 위치
		distance[start.y][start.x] = 0; // 출발지의 비용은 0
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.d, o2.d)); // 최소 비용 우선순위 큐
		pq.add(new Pair(0, start.y, start.x));
		
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (distance[pair.y][pair.x] < pair.d) continue; // 이미 최단 거리이면 무시
			for (int k = 0; k < 4; k++) {
				int ny = pair.y + dy[k];
				int nx = pair.x + dx[k];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue; // 범위를 벗어나면 무시
				int cost = graph[ny][nx] + pair.d; // 다음 위치까지 가는데 드는 비용
				if (cost < distance[ny][nx]) { // 다음 위치까지 가는데 드는 비용이 더 싸면
					distance[ny][nx] = cost; // 최소 비용 갱신
					pq.add(new Pair(cost, ny, nx));
				}
			}
		}
	}
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ans = MAX;
        
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dpList = new Pair[6];
        visited = new boolean[6];
        distanceTable = new int[6][N][N];
        
        M = 0;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        		if (graph[i][j] == 0) dpList[++M] = new Pair(i, j); // m번 탈영병 기록
        		else if (graph[i][j] == -1) dpList[0] = new Pair(i, j); // 출발 부대 기록
        		for (int k = 0; k < 6; k++) distanceTable[k][i][j] = MAX;
        	}
        }
        
        graph[dpList[0].y][dpList[0].x] = 0; // 출발부대의 위치 0으로 초기화
        
        for (int m = 0; m <= M; m++) dijkstra(m); // 최단거리 테이블 생성
        
        if (M == 0) System.out.println(0); // 탈영병이 존재하지 않으면 0 출력
        else {
        	backtrack(1, 0, 0); // 출발 부대에서 시작하므로 이미 1개를 선택한 상태       	
        	System.out.println(ans);
        }
    }
}


class Pair {
	int d; // 비용
	int y;
	int x;
	
	Pair(){}
	
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	Pair(int d, int y, int x) {
		this.d = d;
		this.y = y;
		this.x = x;
	}
}