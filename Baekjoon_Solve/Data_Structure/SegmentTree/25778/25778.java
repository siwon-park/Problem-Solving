// House Prices Going Up (25778번)
import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 집의 수
		FenwickTree fenwick = new FenwickTree(N);
		for (int i = 1; i < N + 1; i++) {
			fenwick.update(i, Integer.parseInt(br.readLine()));
		}
		
		M = Integer.parseInt(br.readLine()); // 거래 수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String tx = st.nextToken();
			if ("U".equals(tx)) {
				int idx = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				fenwick.update(idx, val);
			} else {
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				long ans = fenwick.sum(r) - fenwick.sum(l - 1);
				bw.write(ans + "\n");
			}
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
		this.size = n;
	}
	
	void update(int i, int v) {
		while (i <= size) {
			tree[i] += v;
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
