// 공장 (7578번)
import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] pairList = new int[N][2];
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int m = 0;
		for (int k = 0; k < 2; k++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int p = Integer.parseInt(st.nextToken());
				if (!hashMap.containsKey(p)) {
					hashMap.put(p, ++m);
					pairList[i][k] = m;		
				} else {
					pairList[i][k] = hashMap.get(p);
				}
			}
		}
		
		FenwickTree fenwickTree = new FenwickTree(N);
		long ans = 0;
		for (int i = 0; i < N; i++) {
			fenwickTree.update(pairList[i][1], 1); // pair.s와 pair.e를 잇는 간선을 추가 (pair.e 지점에 += 1)
			ans += fenwickTree.count(N) - fenwickTree.count(pairList[i][1]);
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}


class FenwickTree {
	int[] tree;
	int size;
	
	FenwickTree(int n) {
		this.tree = new int[n + 1];
		this.size = n + 1;
	}
	
	void update(int i, int v) {
		while (i < size) {
			tree[i] += v;
			i += (i & -i);
		}
	}
	
	long count(int i) {
		long ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
}