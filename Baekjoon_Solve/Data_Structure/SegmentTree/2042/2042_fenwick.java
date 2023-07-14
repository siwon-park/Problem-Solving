// 구간 합 구하기 (2042번) - 펜윅 트리 풀이
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K; // 수의 개수, 업데이트 쿼리의 수, 합 쿼리의 수
	static long[] arr;
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N + 1];
		FenwickTree fenwickTree = new FenwickTree(N);
		
		// 초기 숫자 입력
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Long.parseLong(br.readLine());
			fenwickTree.update(i, arr[i]); // 초기 값이 0이니 초기 배열의 값인 arr[i]만큼 update
		}
		
		int a, b;
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if (a == 1) { // 업데이트 쿼리
				long c = Long.parseLong(st.nextToken());
				fenwickTree.update(b, c - arr[b]); // c와 arr[b]의 차이값만큼 업데이트 후
				arr[b] = c; // arr[b]를 c로 바꿈
			} else { // 합 연산 쿼리
				// b부터 c까지의 합은 1부터 c까지의 합에서 1부터 b - 1까지의 합을 뺌
				int c = Integer.parseInt(st.nextToken());
				long sum = fenwickTree.sum(c) - fenwickTree.sum(b - 1);
				bw.write(sum + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();		
	}
}


class FenwickTree {
	
	long[] tree;
	int treeSize;
	
	FenwickTree(int n) {
		// 1부터 n 포함이기 때문에 n + 1
		this.tree = new long[n + 1];
		this.treeSize = n + 1;
	}
	
	void update(int i, long v) {
		while (i < treeSize) { // treeSize가 n + 1이기 때문에 n까지 계산하기 위해 n + 1보다 작을 동안 반복
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