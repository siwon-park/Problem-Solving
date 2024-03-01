// 홍익 투어리스트 (23326번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static TreeSet<Integer> treeSet = new TreeSet<>((o1, o2) -> Integer.compare(o1, o2));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 구역의 수
		Q = Integer.parseInt(st.nextToken()); // 쿼리의 수
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a != 0) treeSet.add(i);
		}
		
		int cur = 0; // 현재 칸
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if (op == 1) { // x번 구역이 명소인지 확인
				int x = Integer.parseInt(st.nextToken()) - 1;
				if (treeSet.contains(x)) {
					treeSet.remove(x);
				} else {
					treeSet.add(x);
				}
			} else if (op == 2) { // x칸 만큼 이동
				int x = Integer.parseInt(st.nextToken());
				cur = (cur + x) % N;
			} else {
				if (treeSet.isEmpty()) { // 명소가 존재하지 않으면
					bw.write(-1 + "\n");
				} else {
					Integer target = treeSet.ceiling(cur); // 현재 칸보다 큰 칸 중에서 가장 작은 칸을 찾음
					if (target == null) { // 그러한 칸이 없으면
						target = treeSet.first(); // 맨 앞 칸이 이동할 칸임
						bw.write((N + target - cur) + "\n"); // 한 바퀴 돈 다음 더 갔을 때의 칸을 구함
					} else {
						bw.write((target - cur) + "\n");
					}					
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
