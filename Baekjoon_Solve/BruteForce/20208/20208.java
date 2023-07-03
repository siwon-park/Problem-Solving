// 진우의 민트초코우유 (20208번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int ans;
	static int N, M, H, L; // 마을 크기, 초기 체력, 체력 증가량, 초코 우유 개수
	static boolean[] visited; // 방문 배열
	static int[] jinwoo; // 진우
	static int[][] graph, pos; // 마을, 모두의 위치
	static ArrayList<int[]> milks; // 우유 리스트
	
	
	static void dfs(int cur, int h, int cnt) {
		// 현재 위치에서 진우네 집으로 다시 올 수 있는지 확인
		int curY = pos[cur][0];
		int curX = pos[cur][1];
		if (h - (Math.abs(curY - pos[0][0]) + Math.abs(curX - pos[0][1])) >= 0) {
			ans = Math.max(ans, cnt);
		}
		for (int i = 0; i < L; i++) {
			int nxtY = pos[i + 1][0];
			int nxtX = pos[i + 1][1];
			int left = h - (Math.abs(curY - nxtY) + Math.abs(curX - nxtX));
			if (!visited[i] && left >= 0) {
				visited[i] = true;
				dfs(i + 1, left + H, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
	
		graph = new int[N][N];
		jinwoo = new int[2];
		milks = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) { // 진우의 위치를 기록
					jinwoo[0] = i;
					jinwoo[1] = j;
				} else if (graph[i][j] == 2) { // 우유의 위치를 기록
					milks.add(new int[] {i, j});
				}
			}
		}
		
		L = milks.size();
		pos = new int[L + 1][2];
		pos[0][0] = jinwoo[0];
		pos[0][1] = jinwoo[1];
		for (int i = 0; i < L; i++) {
			pos[i + 1][0] = milks.get(i)[0];
			pos[i + 1][1] = milks.get(i)[1];
		}
		
		visited = new boolean[L];
		
		ans = 0;
		dfs(0, M, 0);
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}