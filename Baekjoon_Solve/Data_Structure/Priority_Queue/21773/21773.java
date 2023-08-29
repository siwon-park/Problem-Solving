// 가희와 프로세스 1 (21773번)
import java.io.*;
import java.util.*;

public class Main {
	
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Process> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.p > o2.p) return -1;
			else if (o1.p < o2.p) return 1;
			else return Integer.compare(o1.id, o2.id);
		});
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			pq.add(new Process(id, t, p));
		}
		
		while (T-- > 0 && !pq.isEmpty()) {
			Process process = pq.poll();
			process.p -= 1; // 현재 프로세스의 우선순위를 1감소 -> 나머지 프로세스들의 우선순위가 증가
			process.t -= 1; // 실행 시간을 감소
			bw.write(process.id + "\n");
			if (process.t > 0) pq.add(process);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}


class Process {
	int id, t, p;
	Process(int id, int t, int p) {
		this.id = id;
		this.t = t;
		this.p = p;
	}
}