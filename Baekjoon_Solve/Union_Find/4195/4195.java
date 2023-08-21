// 친구 네트워크 (4195번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int find(int x) {
		if (parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[b] = a;
	}
	
	static int[] parent = new int[200_002];
	static int[] friends = new int[200_002];
	static HashMap<String, Integer> hashMap;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int F = Integer.parseInt(br.readLine());
			
			// 친구 이름별로 해싱
			int n = 0;
			hashMap = new HashMap<>();
			int[][] rel = new int[F][2];
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String fa = st.nextToken();
				String fb = st.nextToken();
				if (hashMap.get(fa) == null) {
					hashMap.put(fa, n);
					n += 1;
				}
				if (hashMap.get(fb) == null) {
					hashMap.put(fb, n);
					n += 1;
				}
				rel[i][0] = hashMap.get(fa);
				rel[i][1] = hashMap.get(fb);
			}
			
			// 부모 배열, 친구 카운트 초기화
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				friends[i] = 1;
			}
			
			for (int i = 0; i < F; i++) {
				int a = rel[i][0];
				int b = rel[i][1];
				int pa = find(a);
				int pb = find(b);
				if (pa != pb) {
					friends[pa] += friends[pb];
					union(a, b);
				}
				bw.write(friends[pa] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
 	}
}
