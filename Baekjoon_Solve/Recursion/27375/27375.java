// 금공강 사수 (27375번)
import java.io.*;
import java.util.*;

public class Main {

	static int n, k;
	static int[][] classes;
	static int ans;
	
	static void backtrack(int idx, int score, int[] schedules) {
		if (score == k) {
			ans += 1;
			return;
		}
		
		for (int i = idx; i < n; i++) {
			int w = classes[i][0]; // 요일
			int s = classes[i][1]; // 시작 시간
			int e = classes[i][2]; // 끝 시간
			if (w != 5 && s > schedules[w]) {
				int tmp = schedules[w];
				schedules[w] = e;
				backtrack(i, score + e - s + 1, schedules);
				schedules[w] = tmp;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] schedules = new int[6];
		classes = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			classes[i] = new int[] {w, s, e};
		}
		Arrays.sort(classes, (o1, o2) -> {
			if (o1[1] > o2[1]) return 1;
			else if (o1[1] < o2[1]) return -1;
			else {
				if (o1[2] > o2[2]) return 1;
				else if (o1[2] < o2[2]) return -1;
				else return Integer.compare(o1[0], o2[0]);
			}
		});
		backtrack(0, 0, schedules);
		System.out.println(ans);
	}
}

