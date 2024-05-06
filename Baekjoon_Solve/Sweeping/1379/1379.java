// 강의실 2 (1379번)
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		ArrayList<int[]> arrayList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arrayList.add(new int[] {no, s, e});
		}
		
		// s, e가 빠른 순으로 정렬
		Collections.sort(arrayList, (o1, o2) -> {
			if (o1[1] < o2[1]) return -1;
			else if (o1[1] > o2[1]) return 1;
			else return Integer.compare(o1[2], o2[2]);
		});
		
		// e, s가 빠른 순으로 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] < o2[2]) return -1;
			else if (o1[2] > o2[2]) return 1;
			else return Integer.compare(o1[1], o2[1]);
		});
		
		int ans = 0;
		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			int[] cur = arrayList.get(i);
			if (pq.isEmpty()) {
				pq.add(cur);
				arr[cur[0]] = 1;
			} else {
				int[] top = pq.peek();
				if (top[2] <= cur[1]) { // 현재 강의 시작 시간이 pq의 강의 끝 시간 이상이면 강의를 이어서 진행함.
					pq.poll();
					pq.add(cur);
					arr[cur[0]] = arr[top[0]];
				} else {
					pq.add(cur);
					arr[cur[0]] = pq.size();
				}
			}
			ans = Math.max(ans, pq.size());
		}
		
		
		bw.write(ans + "\n");
		for (int i = 1; i < N + 1; i++) bw.write(arr[i] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
