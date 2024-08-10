// 버블 소트 (1517번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1][2]; // 숫자, 원래 인덱스
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		
		// 정렬(arr[i][0] 오름차순)
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] > o2[0]) return 1;
			else if (o1[0] < o2[0]) return -1;
			else return Integer.compare(o1[1], o2[1]);
		});
		
		FenwickTree fenwick = new FenwickTree(N);
		long ans = 0;
		for (int i = 1; i < N + 1; i++) {
			fenwick.update(arr[i][1]); // arr[i][1] 지점에 1을 업데이트
			// 구간 [arr[i][1] + 1, N]의 합 누적
			ans += fenwick.sum(N) - fenwick.sum(arr[i][1]);
		}
		
		bw.write(ans + "");
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
		this.size  = n;
	}
	
	void update(int i) {
		while (i <= size) {
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
