package BOJ;

// 대한민국 (27313번)
import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[K][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i][0] = a;
				arr[i][1] = b;
			}
			
			int node = Math.max(N, M);
			Arrays.sort(arr, (o1, o2) -> {
				if (o1[0] < o2[0]) return -1;
				else if (o1[0] > o2[0]) return 1;
				else return Integer.compare(o1[1], o2[1]);
			});
			
			FenwickTree fenwickTree = new FenwickTree(node);
			long ans = 0;
			for (int i = 0; i < K; i++) {
				fenwickTree.update(arr[i][1]);
				ans += (fenwickTree.sum(node) - fenwickTree.sum(arr[i][1]));
			}
			
			bw.write("Test case " + tc + ": " + ans + "\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}


class FenwickTree {
	long[] tree;
	int size;
	
	FenwickTree(int n) {
		this.tree = new long[n + 1];
		this.size = n + 1;
	}
	
	void update(int i) {
		while (i < size) {
			tree[i] += 1;
			i += (i & -i);
		}
	}
	
	long sum(int i) {
		long ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
}

