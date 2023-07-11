// 텀 프로젝트 (9466번)
import java.io.*;
import java.util.*;

public class Main {

	static int T, N, ans; // 테스트 케이스, 학생 수
	static int[] arr;
	static boolean[] visited;
	static boolean[] checked; // 해당 노드가 속하는 사이클을 세었는지 유무
	
	static void dfs(int cur) {
		visited[cur] = true;
		if (!visited[arr[cur]]) dfs(arr[cur]);
		else if (!checked[arr[cur]]) {
			ans += 1; // 자기 자신을 포함하기 위해 더함
			int nxt = arr[cur];
			while (nxt != cur) {
				nxt = arr[nxt];
				ans += 1;
			}
		}
		checked[cur] = true;
		return;
 	}
	
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N + 1];
			checked = new boolean[N + 1];
			arr = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			ans = 0;
			for (int i = 1; i < N + 1; i++) {
				if (!visited[i]) dfs(i);
			}
			bw.write(N - ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}