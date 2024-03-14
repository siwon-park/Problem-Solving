// 수상 택시 (2836번)
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> backward = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > b) { // 역행해야 하는 구간을 모아서 순행 구간으로 처리
				backward.add(new int[] {b, a});
			}
		}
		
		Collections.sort(backward, (o1, o2) -> {
			if (o1[0] > o2[0]) return 1;
			else if (o1[0] < o2[0]) return -1;
			else return Integer.compare(o1[1], o2[1]);
		});
		
		long ans = M;
		long dist = 0;
		int last = 0;
		for (int i = 0; i < backward.size(); i++) {
			int[] pair = backward.get(i);
			int first = pair[0];
			int second = pair[1];
			if (last < first) {
				dist += second - first;
				last = second;
			} else {
				if (last < second) { // last < second일 때만 더함 => last == second면 중복이니 계산할 필요 없음
					dist += second - last;
					last = second;
				}
			}
		}

		System.out.println(ans + dist * 2);
	}
}
