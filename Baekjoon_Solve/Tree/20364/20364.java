// 부동산 다툼 (20364번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q; // 땅의 개수, 오리의 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		int[] ducks = new int[Q];
		boolean[] visited = new boolean[N + 1];
		for (int i = 0; i < Q; i++) ducks[i] = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < Q; i++) {
			int k = ducks[i]; // i번째 오리가 원하는 땅의 번호
			boolean flag = true;
			int first = 0; // 가장 먼저 마주치는 땅의 번호
			while (k > 1) {
				// 역순으로 방문하므로 가장 먼저 마주치는 땅의 번호를 찾기 위해서는 1까지 올라가야 함
				if (visited[k]) {
					flag = false;
					first = k;
				}
				k >>= 1;
			}
			if (flag) {
				bw.write(0 + "\n");
				visited[ducks[i]] = true;
			} else {
				bw.write(first + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}