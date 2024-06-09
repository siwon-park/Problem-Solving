// 의리 게임 (28424번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static int[] parent;
	static int[][] alchol; // 0: 현재 섭취량, 1: 만취 상한선
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[a] = b; // a의 부모는 b로
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		alchol = new int[N + 1][2];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
			alchol[i][1] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int ord = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if (ord == 1) {
				int v = Integer.parseInt(st.nextToken()); // 섭취해야할 알콜
				if (alchol[idx][0] + v <= alchol[idx][1]) { // v를 전부 섭취 가능
					alchol[idx][0] += v;
				} else { // 전부 다 섭취 불가능 -> 섭취할 수 있는대로 먹은 다음 부모에게 전달
					v -= (alchol[idx][1] - alchol[idx][0]); // 남은 양
					alchol[idx][0] = alchol[idx][1];
					int nxt = idx + 1; // 다음 사람이 N보다 크면 break
					if (nxt > N) continue;
					union(idx, nxt);
					while (v > 0) {
						int p = find(nxt); // nxt의 부모
						if (p == N && alchol[p][0] == alchol[p][1]) break; // N도 섭취가 불가하면 break
						if (alchol[p][0] + v <= alchol[p][1]) {
							alchol[p][0] += v;
							v = 0;
						} else {
							v -= (alchol[p][1] - alchol[p][0]); // 남은 양
							alchol[p][0] = alchol[p][1];
							if (p + 1 <= N) {
								union(p, p + 1);
							}
						}
						nxt = p;
					}
				}
			} else { // 현재 idx번 사람이 마신 알콜량을 출력
				bw.write(alchol[idx][0] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
