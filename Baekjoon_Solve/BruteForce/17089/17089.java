// 세 친구 (17089번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static HashSet<Integer>[] hashSetArr = new HashSet[4001];
	
	static void init(int n) {
		for (int i = 0; i < n + 1; i++) {
			hashSetArr[i] = new HashSet<>();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init(N);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			hashSetArr[a].add(b);
			hashSetArr[b].add(a);
		}
		
		int _min = Integer.MAX_VALUE; // 세 친구의 친구 수 합의 최솟값
		for (int a = 1; a <= N; a++) {
			// 친구 수가 2보다 작거나 친구 수에서 2를 뺀 수가 최솟값보다 크거나 같으면 무시
			HashSet<Integer> friendsA = hashSetArr[a];
			if (friendsA.size() < 2 || friendsA.size() - 2 >= _min) continue;
			for (Integer b : friendsA) { // A의 친구 중에서 B를 고름
				HashSet<Integer> friendsB = hashSetArr[b];
				if (friendsB.size() < 2 || friendsB.size() + friendsA.size() - 4 >= _min) continue;
				for (Integer c : friendsB) {
					if (!hashSetArr[c].contains(a)) continue; // a와 친구가 아니면 무시
					_min = Math.min(_min, friendsA.size() + friendsB.size() + hashSetArr[c].size() - 6);
				}
				
			}
		}
		
		if (_min == Integer.MAX_VALUE) _min = -1;
		bw.write(_min + "");
		bw.flush();
		bw.close();
		br.close();
	}
}