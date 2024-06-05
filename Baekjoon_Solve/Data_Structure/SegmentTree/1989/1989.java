// 부분배열 고르기 2 (1989번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, start, end;
	static long ans;
	static int[] arr;
	
	static class SegmentTree {
		Node[] tree;
		
		SegmentTree(int n) {
			this.tree = new Node[n * 4];
			for (int i = 0; i < N * 4; i++) tree[i] = new Node(0, 0);
		}
		
		void init(int s, int e, int n) {
			if (s == e) {
				tree[n].value = arr[s];
				tree[n].idx = s;
				return;
			}
			int mid = (s + e) >> 1;
			init(s, mid, n * 2);
			init(mid + 1, e, n * 2 + 1);
			tree[n].value = tree[n * 2].value + tree[n * 2 + 1].value;
			tree[n].idx = (arr[tree[n * 2].idx] <= arr[tree[n * 2 + 1].idx]) ? tree[n * 2].idx : tree[n * 2 + 1].idx;
			return;
		}
		
		int findIdx(int s, int e, int n, int l, int r) {
			if (r < s || e < l) return -1;
			if (l <= s && e <= r) return tree[n].idx;
			int mid = (s + e) >> 1;
			int left = findIdx(s, mid, n * 2, l, r);
			int right = findIdx(mid + 1, e, n * 2 + 1, l, r);
			if (left == -1) return right;
			if (right == -1) return left;
			return (arr[left] <= arr[right]) ? left : right;
		}
		
		long getSum(int s, int e, int n, int l, int r) {
			if (r < s || e < l) return 0;
			if (l <= s && e <= r) return tree[n].value;
			int mid = (s + e) >> 1;
			return getSum(s, mid, n * 2, l, r) + getSum(mid + 1, e, n * 2 + 1, l, r);
		}
		
		long getMaxScore(int l, int r) {
			int idx = findIdx(1, N, 1, l, r);
			long maxScore = getSum(1, N, 1, l, r) * arr[idx];
			long leftTmp = -1;
			long rightTmp = -1;
			if (l <= idx - 1) {
				leftTmp = getMaxScore(l, idx - 1);
			}
			if (r >= idx + 1) {
				rightTmp = getMaxScore(idx + 1, r);
			}
			
			ans = Math.max(ans, Math.max(maxScore, Math.max(leftTmp, rightTmp)));
			if (ans == maxScore) {
				start = l;
				end = r;
			} else if (ans == leftTmp) {
				start = l;
				end = idx - 1;
			} else if (ans == rightTmp) {
				start = idx + 1;
				end = r;
			}
			
			return maxScore;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		start = 0;
		end = 0;
		
		SegmentTree segTree = new SegmentTree(N);
		segTree.init(1, N, 1);
		segTree.getMaxScore(1, N);
		bw.write(ans + "\n");
		bw.write(start + " " + end);
		bw.flush();
		br.close();
		bw.close();
	}
}


class Node {
	long value;
	int idx;
	Node() {}
	Node(long value, int idx) {
		this.value = value;
		this.idx = idx;
	}
}
