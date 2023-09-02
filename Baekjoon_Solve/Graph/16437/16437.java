// 양 구출 작전 (16437번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] island; // 각 섬에 살고있는 동물의 수
	static ArrayList<ArrayList<Integer>> graph;
	
	static long dfs(int cur) {
		long sum = island[cur];
		for (int i = 0; i < graph.get(cur).size(); i++) {
			int nxt = graph.get(cur).get(i);
			sum += dfs(nxt);
		}
		if (sum < 0) sum = 0; // 내려가는 도중 늑대의 수가 양의 수보다 크면 도달 불가능하므로 0을 반환
		return sum;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		island = new int[N + 1];
		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
		
		int n = 2;
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			String t = st.nextToken();
			int a = Integer.parseInt(st.nextToken()); // 살고 있는 개체의 수
			int p = Integer.parseInt(st.nextToken()); // 부모
			graph.get(p).add(n);
			if (t.equals("S")) { // 양인 경우 -> 양수를 기록
				island[n] += a;
			} else { // 늑대인 경우 -> 음수를 기록
				island[n] -= a;
			}
			n++;
		}
		
		long ans = dfs(1);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
}