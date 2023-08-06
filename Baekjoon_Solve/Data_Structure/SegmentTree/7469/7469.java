package BOJ;

// K번째 수 (7469번)
import java.io.*;
import java.util.*;

public class Main {

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 배열의 크기
		int m = Integer.parseInt(st.nextToken()); // Q함수의 호출 횟수
		
		st = new StringTokenizer(br.readLine());
		// n + 1 크기로 선언하면 음수가 들어왔을 때 정렬하면 0이 존재하여 제대로 압축을 할 수 없음
		int[] arr = new int[n];
		int[] tmp = new int[n]; // 좌표 압축용
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			tmp[i] = arr[i];
		}
		
		Arrays.sort(tmp); // 정렬
		HashMap<Integer, Integer> compression = new HashMap<>();
		for (int i = 1; i < n + 1; i++) {
			compression.put(tmp[i - 1], i);
		}
		
		PersistentSegmentTree pst = new PersistentSegmentTree();
		pst.init(pst.root[0], 1, n);
		
		for (int i = 1; i < n + 1; i++) { // arr[i]에 해당하는 위치에 1을 증가 -> 몇 번째 큰 원소인지 찾아서 해당 번째에 1을 업데이트
			pst.update(pst.root[i - 1], pst.root[i], 1, n, compression.get(arr[i - 1]));
		}
		
		int a, b, k;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int idx = pst.findKth(pst.root[a - 1], pst.root[b], 1, n, k);
			bw.write(tmp[idx - 1] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
 	}
}


class PersistentSegmentTree {
	Node[] root;
	
	PersistentSegmentTree() {
		this.root = new Node[100_055];
		for (int i = 0; i < 100_055; i++) root[i] = new Node();
	}
	
	void init(Node node, int s, int e) {
		if (s == e) {
			return;
		}
		int mid = (s + e) / 2;
		node.left = new Node();
		node.right = new Node();
		init(node.left, s, mid);
		init(node.right, mid + 1, e);
		node.val = node.left.val + node.right.val;
		return;
	}
	
	void update(Node prev, Node now, int s, int e, int idx) {
		if (s == e) {
			now.val += 1;
			return;
		}
		int mid = (s + e) / 2;
		if (idx <= mid) {
			now.left = new Node();
			now.right = prev.right;
			update(prev.left, now.left, s, mid, idx);
		} else {
			now.right = new Node();
			now.left = prev.left;
			update(prev.right, now.right, mid + 1, e, idx);
		}
		now.val = now.left.val + now.right.val;
		return;	
	}
	
	int findKth(Node prev, Node now, int s, int e, int k) {
		if (s == e) return s;
		int diff = now.left.val - prev.left.val; // 왼쪽 자식의 수
		int mid = (s + e) / 2;
		if (k <= diff) return findKth(prev.left, now.left, s, mid, k);
		else return findKth(prev.right, now.right, mid + 1, e, k - diff);
	}
	
 }


class Node {
	
	int val;
	Node left, right;
	
	Node(){}
}